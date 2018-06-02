package com.hzecool.core.share;

import android.graphics.BitmapFactory;

import com.hzecool.app.data.ServerUrls;
import com.hzecool.app.data.UserData;
import com.hzecool.common.utils.FileUtils;
import com.hzecool.common.utils.ImageUrlUtils;
import com.hzecool.common.utils.NetworkUtils;
import com.hzecool.common.utils.TimeUtils;
import com.hzecool.common.utils.ToastUtils;
import com.hzecool.core.R;
import com.hzecool.core.manager.ActivityStack;
import com.hzecool.core.net.FileDownCallBackInterface;
import com.hzecool.core.share.utils.LocalShareUtils;
import com.hzecool.core.share.utils.PuzzleFactory;
import com.hzecool.core.share.utils.ShareUtils;
import com.hzecool.widget.materialdialog.MaterialDialog;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.hzecool.core.share.utils.ShareUtils.getHotShareDir;

/**
 *
 * @author song
 * @date 2017/8/21
 */

public class SharePhoto {

    private MaterialDialog progressDialog;
    private int mFinalI = 0;
    private ArrayList<String> imageUrlList;
    private String mType;

    public void share(List<String> fileIdiList, String mUrl,String type) {
        this.mType = type;
        if (fileIdiList.isEmpty() || fileIdiList.size() == 0) {
            ToastUtils.showShortToast(R.string.no_pic_share);
            return;
        }
        if (!NetworkUtils.isConnected()) {
            ToastUtils.showShortToast(R.string.net_error);
            return;
        }
        showProgress();
        DownPhoto(fileIdiList, mUrl);
    }

    private void DownPhoto(final List<String> fileIdiList, String mUrl) {
        imageUrlList = ImageUrlUtils.getImageUrlList(ServerUrls.BaseUrl, fileIdiList, UserData.sessionid, true);
        if (!mUrl.isEmpty()) {
            imageUrlList.add(mUrl);
            fileIdiList.add(TimeUtils.getNowTimeString(TimeUtils.MMDDHHMMSS_PATTERN));
        }
        for (int i = 0; i < imageUrlList.size(); i++) {
            ShareUtils.DownLoadPic(imageUrlList.get(i), fileIdiList.get(i), new FileDownCallBackInterface() {
                @Override
                public void onProress(float progress) {

                }

                @Override
                public void onSuccess(File file) {
                    if (mFinalI == imageUrlList.size() - 1) {
                        mergePhoto(fileIdiList);
                        return;
                    }
                    mFinalI++;
                }

                @Override
                public void onFail(Exception e) {
                    ToastUtils.showShortToast("图片下载失败");
                    cancelProgressBar();
                    mFinalI = 0;
                }
            });
        }
    }

    private void mergePhoto(List<String> fileIdiList) {
        List<File> files = new ArrayList<>();

        BitmapFactory.Options options = null;
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        options.inJustDecodeBounds = true;

        for (int j = 0; j < imageUrlList.size(); j++) {
            List<File> mfile = FileUtils.searchFileInDir(getHotShareDir(), fileIdiList.get(j) + ".png");
            if(mfile == null || mfile.size() == 0 ){
                continue;
            }
            BitmapFactory.decodeFile(mfile.get(0).getAbsolutePath(), options);
            if (options.mCancel || options.outWidth == -1 || options.outHeight == -1) {
                //表示图片已损毁
                // cancelProgressBar();
                 ToastUtils.showShortToast("图片有损坏,可以清理缓存重新分享");
                continue;
            } else {
                files.addAll(mfile);
            }
        }

        if(files == null || files.isEmpty() || files.size() == 0){
            ToastUtils.showShortToast(R.string.clear_do_again);
            return;
        }

        if (files.size() == 1) {
            LocalShareUtils.ShareSingleImage(ActivityStack.getTopActivityNoRemove(), files.get(0));
        } else {

            PuzzleFactory puzzleFactory = new PuzzleFactory();
            puzzleFactory.SharePuzzle(ActivityStack.getTopActivityNoRemove(), files);
            puzzleFactory.savePuzzle(ActivityStack.getTopActivityNoRemove(),mType);

        }
        cancelProgressBar();
        mFinalI = 0;
    }

    public void cancelProgressBar() {
        progressDialog.dismiss();
    }

    public void showProgress() {
        MaterialDialog.Builder builder = new MaterialDialog.Builder(ActivityStack.getTopActivityNoRemove());
        progressDialog = builder.title("图片合成")
                .content("正在合成图片...")
                .cancelable(false)
                .progress(true, 0)
                .show();
    }
}
