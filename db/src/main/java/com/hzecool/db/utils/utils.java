package com.hzecool.db.utils;

import android.os.Environment;
import android.util.Log;

import com.hzecool.common.utils.Utils;

import java.io.File;



/**
 * Created by 47066 on 2017/3/30.
 */

public class utils {

    /**
     * 判断目录是否存在，不存在则判断是否创建成功
     * 如果存在，是目录则返回true，是文件则返回false，不存在则返回是否创建成功
     *
     * @param name 文件名
     * @return {@code true}: 存在或创建成功<br>{@code false}: 不存在或创建失败
     */

    public static String getDbPath(String name) {
        String dbpath = getAppCacheDir() + File.separator + name;
        Log.e("db", dbpath);

        return dbpath;
    }

    /**
     * 获取app缓存目录
     *
     * @return
     */
    public static String getAppCacheDir() {
        StringBuilder builder = new StringBuilder();
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {

            builder.append(Utils.getContext().getExternalCacheDir().getAbsolutePath());

        } else {

            builder.append(Utils.getContext().getCacheDir().getAbsolutePath());
        }

        builder.append(File.separator);

        builder.append("dbCache");


        return builder.toString();
    }

}
