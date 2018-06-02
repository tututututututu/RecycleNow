package com.hzecool.common.image.imageloader;

/**
 * 通知准备就绪
 * modified by soulrelay
 */
public interface SourceReadyListener {

    void onResourceReady(int width, int height);
}
