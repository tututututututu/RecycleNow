package com.hzecool.app.bean.event;

/**
 * @author tutu
 * @time 2018/1/31
 */

public class VideoFinishEvent {
    private String videoPath;

    public VideoFinishEvent(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }
}
