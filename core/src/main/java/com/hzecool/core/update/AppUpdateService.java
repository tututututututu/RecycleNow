package com.hzecool.core.update;

import android.app.Activity;
import android.text.TextUtils;

import com.hzecool.app.bean.app.VersionInfoBean;
import com.hzecool.common.utils.AppUtils;
import com.hzecool.common.utils.ResourceUtils;
import com.hzecool.common.utils.ToastUtils;
import com.hzecool.core.R;
import com.hzecool.core.base.BaseApp;
import com.hzecool.core.cache.CacheManager;
import com.hzecool.core.log.L;
import com.hzecool.core.manager.ActivityStack;
import com.hzecool.core.net.FileDownCallBackInterface;
import com.hzecool.core.net.FileDownUpLoad;
import com.hzecool.core.net.RxHelper;
import com.hzecool.core.net.RxSubscribe;
import com.hzecool.widget.materialdialog.MaterialDialog;

import java.io.File;
import java.lang.ref.WeakReference;


/**
 * 应用更新服务
 *
 * @author tutu
 * @date 2017/3/16
 */

public class AppUpdateService {

    /**
     * 提示框
     */
    private static MaterialDialog dialog;

    /**
     * 下载进度框
     */
    private static MaterialDialog downDialog;

    /**
     * 外部直接调用这个方法
     */
    public static void updateService(boolean showToast, String phone) {
        ProviderNet.requestCheckUpdate(phone)
                .compose(RxHelper.RxSlhHandleResult())
                .map(netUpdateBean -> {
                    VersionInfoBean lUpdateInfoBean = new VersionInfoBean();
                    if ("1".equals(netUpdateBean.getUpgradeFlag())) {
                        lUpdateInfoBean.setNeedUpdate(true);

                        if ("2".equals(netUpdateBean.getUpgradeMsg().getNoticemethod())) {
                            lUpdateInfoBean.setForce(true);
                        } else {
                            lUpdateInfoBean.setForce(false);
                        }

                        lUpdateInfoBean.setServerVersion("");
                        lUpdateInfoBean.setUpdateMsg(netUpdateBean.getUpgradeMsg().getUpgradeMessage());
                        lUpdateInfoBean.setUrl(netUpdateBean.getUpgradeMsg().getAndroidupgradeurl());
                    } else {
                        lUpdateInfoBean.setNeedUpdate(false);
                    }
                    return lUpdateInfoBean;
                }).subscribe(new RxSubscribe<VersionInfoBean>() {
            @Override
            protected void onSuccess(VersionInfoBean versionInfo) {
                if (versionInfo.isNeedUpdate()) {

                    if (TextUtils.isEmpty(versionInfo.getUrl())) {
                        L.logFile("更新下载链接为空" + versionInfo.toString());
                        ToastUtils.showShortToast(ResourceUtils.getString(R.string.core_downurl_error));
                        return;
                    }

                    //强制更新
                    if ("1".equals(versionInfo.isForce())) {
                        showUpdateDialog(versionInfo, new WeakReference<>(ActivityStack.getTopActivityNoRemove()));
                    } else {
                        //非强制更新
                        showUpdateDialog(versionInfo, new WeakReference<>(ActivityStack.getTopActivityNoRemove()));
                    }

                } else {
                    if (showToast) {
                        ToastUtils.showShortToast(ResourceUtils.getString(R.string.core_fastest_version));
                    }
                }
            }

            @Override
            protected void onFail(String msg) {

            }

            @Override
            protected void onNetError(String msg) {

            }
        });
    }


    /**
     * 显示更新提示框
     *
     * @param versionInfo 版本信息
     */
    private static void showUpdateDialog(VersionInfoBean versionInfo, WeakReference<Activity> activity) {
        String cancelStr = ResourceUtils.getString(R.string.base_cancel);
        if (versionInfo.isForce()) {
            cancelStr = ResourceUtils.getString(R.string.base_exit);
        }

        if (activity.get() == null) {
            return;
        }

        dialog = new MaterialDialog.Builder(activity.get()).positiveText(ResourceUtils.getString(R.string.core_update)).cancelable(false)
                .title(ResourceUtils.getString(R.string.core_hasnew_version))
                .onPositive((dialog14, which) ->
                        {
                            showDownLoadDialog(activity.get());
                            cancelTipsDialog();
                            downApk(versionInfo, activity);
                        }
                )
                .negativeText(cancelStr)
                .onNegative((dialog13, which) -> {

                    if (versionInfo.isForce()) {
                        BaseApp.exit();
                    } else {
                        cancelTipsDialog();
                    }
                })
                .build();

        dialog.setContent(versionInfo.getUpdateMsg());
        dialog.show();
    }

    /**
     * 下载apk文件
     *
     * @param versionInfo 版本信息
     * @param activity    activity
     */
    private static void downApk(VersionInfoBean versionInfo, final WeakReference<Activity> activity) {
        FileDownUpLoad.downLoadFile("downApk",
                versionInfo.getUrl()
                , getNewApkFileDir(), getNewApkName(String.valueOf(versionInfo.getServerVersion()))
                , new FileDownCallBackInterface() {
                    @Override
                    public void onProress(float progress) {
                        downDialog.setProgress((int) (progress * 100));
                    }

                    @Override
                    public void onSuccess(File file) {
                        downFileSuccess(file, activity.get());
                    }

                    @Override
                    public void onFail(Exception e) {
                        cancelDownDialog();
                        cancelTipsDialog();
                    }
                }
        );
    }

    /**
     * 下载文件成功 以及安装
     * 会消失掉下载框和提示框
     *
     * @param file     文件file
     * @param activity activity
     */
    private static void downFileSuccess(File file, Activity activity) {
        chekApk(file);
        cancelDownDialog();
        cancelTipsDialog();
        if (activity == null) {
            return;
        }
        AppUtils.installApp(activity, file);
    }

    /**
     * 检查文件是否可用
     *
     * @param file 下载的文件file
     */
    private static void chekApk(File file) {
        if (!file.exists()) {
            L.logFile("应用更新找不到下载的安装包");
            ToastUtils.showShortToast(ResourceUtils.getString(R.string
                    .core_apk_notfind));
        }
    }


    /**
     * 显示下载进度
     *
     * @param activity
     */
    private static void showDownLoadDialog(Activity activity) {
        if (activity == null) {
            return;
        }
        downDialog = new MaterialDialog.Builder(activity)
                .cancelable(false)
                .title(R.string.core_downing)
                .progress(false, 100)
                .build();
        downDialog.show();
    }

    /**
     * 取消下载进度
     */
    private static void cancelDownDialog() {
        if (downDialog != null) {
            downDialog.cancel();
        }
    }

    /**
     * 取消提示框
     */
    private static void cancelTipsDialog() {
        if (dialog != null) {
            dialog.cancel();
        }
    }

    /**
     * 获取下载app的路径文件夹
     *
     * @return
     */
    public static String getNewApkFileDir() {
        return CacheManager.getTyleCachePath(CacheManager.COMMON_CACHE_PATH);
    }

    /**
     * 新下载app的文件名
     *
     * @param version
     * @return
     */
    public static String getNewApkName(String version) {
        if (TextUtils.isEmpty(version)) {
            version = System.currentTimeMillis() + "";
        }
        return "starff" + version + ".apk";
    }
}
