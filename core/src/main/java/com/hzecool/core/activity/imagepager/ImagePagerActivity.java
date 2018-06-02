package com.hzecool.core.activity.imagepager;

import android.content.Context;
import android.graphics.Color;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hzecool.app.bean.app.ARouterUrl;
import com.hzecool.common.image.imageloader.ImageLoaderUtil;
import com.hzecool.common.image.imageloader.glideprogress.ProgressLoadListener;
import com.hzecool.common.utils.HandlerUtil;
import com.hzecool.common.utils.ListConvertUtils;
import com.hzecool.common.utils.NetworkUtils;
import com.hzecool.common.utils.ResourceUtils;
import com.hzecool.common.utils.ScreenUtils;
import com.hzecool.common.utils.ToastUtils;
import com.hzecool.core.R;
import com.hzecool.core.base.TBaseActivity;
import com.hzecool.core.bean.NetQRbean;
import com.hzecool.core.share.SharePhoto;
import com.mylhyl.circledialog.CircleDialog;
import com.mylhyl.circledialog.callback.ConfigButton;
import com.mylhyl.circledialog.callback.ConfigDialog;
import com.mylhyl.circledialog.params.ButtonParams;
import com.mylhyl.circledialog.params.DialogParams;

import java.util.ArrayList;
import java.util.List;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;


/**
 * 图片查看activity
 * 包括dot
 */

@Route(path = ARouterUrl.AR_URL_VIEW_IMG)
public class ImagePagerActivity extends TBaseActivity<IImagePagerView,ImagePagerPresenter> implements IImagePagerView, View.OnClickListener {
    public static final String INTENT_IMGURLS = "imgurls";
    public static final String INTENT_IMGURLS_ID = "imgurls_id";
    public static final String INTENT_IMGURLS_ARRAY = "imgurls_array";
    public static final String INTENT_POSITION = "position";
    private static final int MIN_CLICK_DELAY_TIME = 1000;
    private static long lastClickTime;
    private List<View> guideViewList = new ArrayList<View>();
    private LinearLayout guideGroup;
    public static ImageSize imageSize;
    private View base;

    private OnDownClickListener onDownClickListener;
    private TextView mTvShare;
    private int photoIndex;
    private List<String> mImgUrls;
    private List<String> mFileIdList;


    public void setOnDownClickListener(OnDownClickListener onDownClickListener) {
        this.onDownClickListener = onDownClickListener;
    }


    public void finishAc() {
        finish();
    }


    @Override
    public int getLayoutID() {
        return R.layout.activity_imagepager;
    }

    @Override
    public void initView() {
        PhotoViewPager viewPager = (PhotoViewPager) findViewById(R.id.pager);
        base = findViewById(R.id.rl_base);
        guideGroup = (LinearLayout) findViewById(R.id.guideGroup);
        mTvShare = (TextView) findViewById(R.id.tv_share);
        mTvShare.setOnClickListener(this);
        int startPos = getIntent().getIntExtra(INTENT_POSITION, 0);
        
        mFileIdList = getIntent().getStringArrayListExtra(INTENT_IMGURLS_ID);
        mImgUrls = getIntent().getStringArrayListExtra(INTENT_IMGURLS);
        if (mImgUrls == null || mImgUrls.isEmpty()) {
            mImgUrls = ListConvertUtils.list2Array(getIntent().getStringArrayExtra(INTENT_IMGURLS_ARRAY));
        }

        if (mImgUrls == null || mImgUrls.isEmpty()) {
            ToastUtils.showShortToast(ResourceUtils.getString(R.string.no_picture));
            finish();
            return;
        }

        ImageAdapter mAdapter = new ImageAdapter(this);
        mAdapter.setDatas(mImgUrls);
        viewPager.setAdapter(mAdapter);
        base.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                photoIndex = position;
                for (int i = 0; i < guideViewList.size(); i++) {
                    guideViewList.get(i).setSelected(i == position ? true : false);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setCurrentItem(startPos);

        addGuideView(guideGroup, startPos, mImgUrls);
    }

    @Override
    public void initTitle(ImageView ivBack, TextView tvBack, View llBack, TextView titleName, TextView tvMenu, View titleRoot) {

    }

    @Override
    protected ImagePagerPresenter createPresenter() {
        return new ImagePagerPresenter();
    }

    private void addGuideView(LinearLayout guideGroup, int startPos, List<String> imgUrls) {
        if (imgUrls != null && imgUrls.size() > 0) {
            guideViewList.clear();
            for (int i = 0; i < imgUrls.size(); i++) {
                View view = new View(this);
                view.setBackgroundResource(R.drawable.core_selector_guide_bg);
                view.setSelected(i == startPos ? true : false);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getResources()
                        .getDimensionPixelSize(R.dimen.gudieview_width),
                        getResources().getDimensionPixelSize(R.dimen.gudieview_heigh));
                layoutParams.setMargins(10, 0, 0, 0);
                guideGroup.addView(view, layoutParams);
                guideViewList.add(view);
            }
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.tv_share) {
            if(!NetworkUtils.isConnected()){
                ToastUtils.showShortToast(R.string.net_error);
                return;
            }
            if(mImgUrls == null || mImgUrls.size() == 0 || mImgUrls.isEmpty()){
                ToastUtils.showShortToast(ResourceUtils.getString(R.string.no_picture));
                return;
            }
            if(isFastClick()){
                showShareDialog();
            }
        }
    }

    /**
     * 按钮在规定的时间内只能点击一次
     */
    public static boolean isFastClick() {
        boolean flag = false;
        long curClickTime = System.currentTimeMillis();
        if ((curClickTime - lastClickTime) >= MIN_CLICK_DELAY_TIME) {
            flag = true;
        }
        lastClickTime = curClickTime;
        return flag;
    }

    @Override
    public void onLoadData(NetQRbean netQRbean) {
    }

    @Override
    public void onEmptyData() {

    }

    @Override
    public void onLoadError(String msg) {
    }

    @Override
    public void onNetError(String msg) {
        ToastUtils.showShortToast(R.string.net_error);
    }

    private class ImageAdapter extends PagerAdapter {

        private List<String> datas = new ArrayList<String>();
        private LayoutInflater inflater;
        private Context context;

        public void setDatas(List<String> datas) {
            if (datas != null) {
                this.datas = datas;
            }
        }

        public ImageAdapter(Context context) {
            this.context = context;
            this.inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            if (datas == null) {
                return 0;
            }
            return datas.size();
        }


        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            View view = inflater.inflate(R.layout.item_pager_image, container, false);

            if (view != null) {
                final PhotoView imageView = (PhotoView) view.findViewById(R.id.image);

                imageView.setOnViewTapListener(new PhotoViewAttacher.OnViewTapListener() {
                    @Override
                    public void onViewTap(View view, float x, float y) {
                        finishAc();
                    }
                });


                final ProgressBar pro = (ProgressBar) view.findViewById(R.id.pro);

                //预览imageView
                final ImageView smallImageView = new ImageView(context);
                if (imageSize == null) {
                    int screenWidth = ScreenUtils.getScreenWidth();
                    imageSize = new ImageSize(screenWidth, screenWidth);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(imageSize.getWidth(), imageSize
                        .getHeight());
                layoutParams.gravity = Gravity.CENTER;
                smallImageView.setLayoutParams(layoutParams);
                smallImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ((FrameLayout) view).addView(smallImageView);

                final String imgurl = datas.get(position);


                if (imgurl.startsWith("/")) {
                    ImageLoaderUtil.getInstance().loadImage(imgurl, imageView);
                } else {
                    pro.setVisibility(View.VISIBLE);
                    pro.setProgress(1);

                    if (!NetworkUtils.isConnected()) {
                        pro.setVisibility(View.GONE);
                        ToastUtils.showShortToast(getString(R.string.base_netError));

                    }

                    ImageLoaderUtil.getInstance().loadImageWithProgress(imgurl, imageView, new ProgressLoadListener() {
                        @Override
                        public void update(int bytesRead, int contentLength) {
                            HandlerUtil.post(() -> {
                                if (pro != null) {
                                    if (bytesRead >= contentLength) {
                                        pro.setVisibility(View.GONE);
                                    } else {
                                        int percent = (int) (bytesRead * 100 / contentLength);
                                        pro.setProgress(percent);
                                    }
                                }

                            });
                        }

                        @Override
                        public void onException() {
                            HandlerUtil.post(new Runnable() {
                                @Override
                                public void run() {
                                    if (pro != null) {
                                        if (pro.getVisibility() == View.VISIBLE) {
                                            pro.setVisibility(View.GONE);
                                        }
                                    }

                                }
                            });
                        }

                        @Override
                        public void onResourceReady() {
                            HandlerUtil.post(new Runnable() {
                                @Override
                                public void run() {
                                    if (pro != null) {
                                        if (pro.getVisibility() == View.VISIBLE) {
                                            pro.setVisibility(View.GONE);
                                        }
                                    }

                                }
                            });
                        }
                    });

                }
                imageView.setOnLongClickListener(v -> {
                    if (onDownClickListener != null) {
                        onDownClickListener.onDownClick(imgurl);
                    }
                    return false;
                });
                container.addView(view, 0);
            }
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view.equals(object);
        }

        @Override
        public void restoreState(Parcelable state, ClassLoader loader) {
        }

        @Override
        public Parcelable saveState() {
            return null;
        }

    }


    public interface OnDownClickListener {
        void onDownClick(String path);
    }

    private void showShareDialog() {
        final String[] items = {getString(R.string.share_single), getString(R.string.share_all)};
        new CircleDialog.Builder(this)
                .configDialog(new ConfigDialog() {
                    @Override
                    public void onConfig(DialogParams params) {
                        //增加弹出动画
                        params.animStyle = R.style.dialogWindowAnim;
                    }
                })
                .setTitle(getString(R.string.photo_share))
                .setTitleColor(Color.BLUE)
                .setItems(items, (parent, view, position, id) -> {
                    List<String> fileId = new ArrayList<String>();
                    if (position == 0) {
                        //分享单张
                        fileId.clear();
                        fileId.add(mFileIdList.get(photoIndex));

                        SharePhoto sharePhoto = new SharePhoto();
                        sharePhoto.share(fileId,"","1");
                    }else {
                        //多张
                        SharePhoto sharePhoto = new SharePhoto();
                        sharePhoto.share(mFileIdList,"","1");
                    }
                })
                .setNegative(getString(R.string.cancel), null)
                .configNegative(new ConfigButton() {
                    @Override
                    public void onConfig(ButtonParams params) {
                        //取消按钮字体颜色
                        params.textColor = Color.RED;
                    }
                })
                .show();
    }
}
