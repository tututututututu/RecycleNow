package com.hzecool.core.share.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.hzecool.common.utils.SizeUtils;
import com.hzecool.core.R;
import com.hzecool.core.share.bean.Puzzle;
import com.hzecool.widget.puzzle.PuzzleView;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by song on 2017/8/11.
 */

public class PuzzleFactory {

    private  String pathFileName;
    private  Puzzle puzzleEntity;
    private  PuzzleView puzzleView;
    private  LinearLayout ll;



    /**
     * 分享货品
     * @param context
     * @param mPics
     */
    public  void SharePuzzle(Context context, List<File> mPics){
        ll = new LinearLayout(context);
        LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(SizeUtils.dp2px(320), ViewGroup.LayoutParams.WRAP_CONTENT);
        ll.setLayoutParams(llParams);
        ll.setBackgroundResource(R.color.base_white);

        puzzleView = new PuzzleView(context);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        puzzleView.setLayoutParams(params);

        ll.addView(puzzleView);
        getFileName(mPics.size());
        puzzleView.setPics(mPics);
        if (pathFileName != null) {
            initCoordinateData(pathFileName, 0,context);
        }
    }

    private  void getFileName(int picNum) {

        switch (picNum) {

            case 2:
                pathFileName = "num_two_style";
                break;
            case 3:
                pathFileName = "num_three_style";
                break;
            case 4:
                pathFileName = "num_four_style";
                break;
            case 5:
                pathFileName = "num_five_style";
                break;
            case 6:
                pathFileName = "num_six_style";
                break;
            case 7:
                pathFileName = "num_seven_style";
                break;
            case 8:
                pathFileName = "num_eight_style";
                break;
            case 9:
                pathFileName = "num_nine_style";
                break;
            default:
                break;
        }
    }

    private  void initCoordinateData(String fileName, int templateNum, Context context) {

        String data = new FileUtil(context).readAsset(fileName);
        try {
            Gson gson = new Gson();
            puzzleEntity = gson.fromJson(data, Puzzle.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (puzzleEntity != null && puzzleEntity.getStyle() != null && puzzleEntity.getStyle().get(templateNum).getPic() != null) {
            puzzleView.setPathCoordinate(puzzleEntity.getStyle().get(templateNum).getPic());
        }

    }
    public  void savePuzzle(Context context,String type) {

        buildDrawingCache(ll);
        ll.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_LOW);
        Bitmap bitmap = ll.getDrawingCache().copy(Bitmap.Config.RGB_565, true);
        try {
            File file = FileUtil.saveBitmapJPG(context,"dd" + System.currentTimeMillis(), bitmap);
            if("0".equals(type)){
                LocalShareUtils.shareMultiplePictureToTimeLine(context,file);
            }else {
                LocalShareUtils.shareMultiplePictureToTimeLine(context,file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private  void buildDrawingCache(View view) {
        try {
            view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        } catch (Exception e) {
            e.printStackTrace();
        }
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
    }
}
