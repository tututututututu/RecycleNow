package com.hzecool.core.share.utils;

import com.hzecool.core.cache.CacheManager;
import com.hzecool.core.net.FileDownCallBackInterface;
import com.hzecool.core.net.FileDownUpLoad;

/**
 * Created by song on 2017/8/21.
 */

public class ShareUtils {

    /**
     * 下载要分享的图片
     */
    public static void DownLoadPic(String url,String name, FileDownCallBackInterface fileDownCallBackInterface){
        FileDownUpLoad.downLoadFile("share",url,getHotShareDir(),name  + ".png" ,fileDownCallBackInterface);
    }

    /**
     * 获取文件的存储路径
     * @return
     */
    public static String getHotShareDir(){
        return CacheManager.getTyleCachePath(CacheManager.SHARE_CACHE_PATH);
    }
}
