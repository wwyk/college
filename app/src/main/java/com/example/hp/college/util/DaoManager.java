package com.example.hp.college.util;

import android.content.Context;

import com.example.hp.college.bean.dao.CfbgContactDao;
import com.example.hp.college.bean.dao.DaoMaster;
import com.example.hp.college.bean.dao.DaoSession;
import com.example.hp.college.bean.dao.KydtContactDao;
import com.example.hp.college.bean.dao.StudentsContactDao;
import com.example.hp.college.bean.dao.TzggContactDao;
import com.example.hp.college.bean.dao.XmcgContactDao;
import com.example.hp.college.bean.dao.XsjzContactDao;
import com.example.hp.college.bean.dao.XxgkContactDao;
import com.example.hp.college.bean.dao.XydtContactDao;
import com.example.hp.college.bean.dao.YxxwContactDao;

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
    public void init(Context context){
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
    public CfbgContactDao getCfbgContactDao() {
        return daoSession.getCfbgContactDao();
    }
    public StudentsContactDao getStudentsContactDao() {
        return daoSession.getStudentsContactDao();
    }
    public KydtContactDao getKydtContactDao() {
        return daoSession.getKydtContactDao();
    }
    public XmcgContactDao getXmcgContactDao() {
        return daoSession.getXmcgContactDao();
    }
    public XsjzContactDao getXsjzContactDao() {
        return daoSession.getXsjzContactDao();
    }
    public XxgkContactDao getXxgkContactDao() {
        return daoSession.getXxgkContactDao();
    }
    public XydtContactDao getXydtContactDao() {
        return daoSession.getXydtContactDao();
    }
    public YxxwContactDao getYxxwContactDao() {
        return daoSession.getYxxwContactDao();
    }
}

