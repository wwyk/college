package com.example.hp.college.util;

import android.content.Context;

import com.example.hp.college.Activity.fragment.ShouyePageFragment;
import com.example.hp.college.bean.dao.DaoMaster;
import com.example.hp.college.bean.dao.DaoSession;
import com.example.hp.college.bean.dao.TzggContactDao;

public class DaoManager {
    private static final String DB_NAME = "tzgg.db";
    private static DaoManager mInstance = null;
    private DaoMaster.DevOpenHelper mhelper;
    private Context mContext;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    private DaoManager(){}

    public static DaoManager getInstance(){
        if (mInstance == null){
            synchronized (DaoManager.class){
                if (mInstance == null){
                    mInstance = new DaoManager();
                }
            }
        }
        return mInstance;
    }
    public void init(ShouyePageFragment shouyePageFragment, Context context){
        mContext = context;
        if (mhelper == null){
            mhelper = new DaoMaster.DevOpenHelper(mContext,DB_NAME,null);
        }
        if (daoMaster == null){
            daoMaster = new DaoMaster(mhelper.getWritableDatabase());
        }
        if (daoSession == null){
            daoSession = daoMaster.newSession();
        }
    }
    public DaoSession getDaoSession(){
        return daoSession;
    }
    public TzggContactDao getTzggContactDao() {
        return daoSession.getTzggContactDao();
    }
}

