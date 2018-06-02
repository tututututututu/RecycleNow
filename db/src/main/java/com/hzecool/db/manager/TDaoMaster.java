package com.hzecool.db.manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.hzecool.db.bean.DaoMaster;


/**
 * DB升级子类 处理表结构等问题
 *
 * @author tutu
 * @date 2017/2/26
 */

public class TDaoMaster extends DaoMaster.OpenHelper {
    public TDaoMaster(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < newVersion) {
            //MigrationHelper.migrate(db, BillingDaoDressStyleBeanDao.class, BillingDaoHrStaffBeanDao.class, BillingDaoScDwxxBeanDao.class, DressStyleDetailDaoBeanDao.class);
        }
    }
}
