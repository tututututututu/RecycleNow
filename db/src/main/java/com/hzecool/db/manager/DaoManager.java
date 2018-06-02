package com.hzecool.db.manager;

import android.content.Context;
import android.util.Log;

import com.hzecool.db.bean.DaoMaster;
import com.hzecool.db.bean.DaoSession;
import com.hzecool.db.utils.utils;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.QueryBuilder;

import java.io.File;

/**
 * 数据库初始化manager
 *
 * @author tutu
 * @date 2017/2/21
 */

public class DaoManager {

    private static DaoSession daoSession;
    public static final String DB_NAME = "app.db";

    public static void setupDatabase(Context context,boolean isDebug) {
        //设置存储路径
        File path = new File(utils.getDbPath(DB_NAME));

        path.getParentFile().mkdirs();

        if (isDebug) {
            Log.e("db", path.getAbsolutePath());
        }

        //创建数据库shop.db"
        TDaoMaster helper = new TDaoMaster(context.getApplicationContext(), path.getAbsolutePath(), null);
        //获取可写数据库
        Database db = helper.getWritableDb();
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(db);
        //获取Dao对象管理者
        daoSession = daoMaster.newSession();

        if (isDebug) {
            QueryBuilder.LOG_SQL = true;
            QueryBuilder.LOG_VALUES = true;
        }
    }

    public static DaoSession getDaoInstant() {
        return daoSession;
    }

    public static void ClearDB(){
        try {
//            getDaoInstant().getBillingDaoScDictColorBeanDao().deleteAll();

        }catch (Exception e){
            
        }

    }
}
