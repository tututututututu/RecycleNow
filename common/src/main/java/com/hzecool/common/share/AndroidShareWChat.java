package com.hzecool.common.share;

import android.app.Activity;
import android.support.v7.app.AlertDialog;

import com.hzecool.common.R;
import com.hzecool.common.utils.ResourceUtils;
import com.hzecool.common.utils.ShareUtils;
import com.hzecool.common.utils.ToastUtils;
import com.hzecool.common.utils.Utils;

import java.util.List;

/**
 * 微信分享选择以及分享
 *
 * @author tutu
 * @date 2017/3/8
 */

public class AndroidShareWChat {


    private static String[] items = new String[]{ResourceUtils.getString(R.string.common_wechat_share_tips), ResourceUtils
            .getString(R.string.common_wechat_share_moment)};

    public static void showShareCheakDlg(final List<String> paths, Activity activity, String title, ShareSuccessInterface shareSuccessInterface) {
        new AlertDialog.Builder(activity)
                .setTitle(R.string.common_select_share_type)
                .setCancelable(true)
                .setItems(items, (dialog, which) -> {
                    switch (which) {
                        case 0:
                            sendFrinds(paths, title, shareSuccessInterface);
                            dialog.cancel();

                            break;
                        case 1:
                            shareWx(paths, title, shareSuccessInterface);
                            dialog.cancel();
                            break;
                        default:
                            break;
                    }
                })
                .setNegativeButton(R.string.common_cancel, (dialog, which) -> dialog.dismiss()).show();

    }

    /**
     * 分享到朋友圈
     */
    private static void shareWx(List<String> paths, String title, ShareSuccessInterface shareSuccessInterface) {

        if (paths == null || paths.size() == 0) {
            ToastUtils.showShortToast(R.string.common_no_photos);
        } else {
            if (ShareUtils.share9PicsToWXCircle(Utils.getContext(), title, paths)) {
                shareSuccessInterface.shareWxSuccess();
            }
        }
    }

    /**
     * 分享到朋友
     */
    private static void sendFrinds(List<String> paths, String title, ShareSuccessInterface shareSuccessInterface) {

        if (paths == null || paths.size() == 0) {
            ToastUtils.showShortToast(R.string.common_no_photos);
        } else {
            if (ShareUtils.sharePicToFriendNoSDK(Utils.getContext(), title, paths)
                    ) {
                shareSuccessInterface.shareWxSuccess();
            }
        }

    }
}
