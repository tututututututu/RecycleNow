package com.hzecool.common.service;

import android.app.IntentService;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * @author tutu
 * @time 2018/3/7
 */

public class VoiceIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    private int VOICE_RESID = -1;
    public static final String VOICE_RES_ID = "voice_res_id";
    public MediaPlayer mMediaPlayer;

    public VoiceIntentService() {
        super("VoiceIntentService");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            int param1 = intent.getIntExtra(VOICE_RES_ID, -1);
            if (param1 != -1) {
                playVoice(param1);
            }
        }
    }

    private void playVoice(int resId) {
        try {
            mMediaPlayer = MediaPlayer.create(this, resId);
            //此处的两个方法需要捕获IO异常
            //设置音频文件到MediaPlayer对象中
            //让MediaPlayer对象准备
//            mMediaPlayer.prepare();
            mMediaPlayer.setLooping(false);
            mMediaPlayer.start();
        } catch (Exception e) {
            Log.d("VoiceIntentService", "设置资源，准备阶段出错");
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        mMediaPlayer.stop();
        mMediaPlayer.release();
        super.onDestroy();
    }
}
