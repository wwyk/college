package com.example.hp.college.bean.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.hp.college.bean.CfbgContact;
import com.example.hp.college.bean.TzggContact;
import com.example.hp.college.bean.StudentsContact;
import com.example.hp.college.bean.KydtContact;
import com.example.hp.college.bean.XmcgContact;
import com.example.hp.college.bean.XsjzContact;
import com.example.hp.college.bean.XxgkContact;
import com.example.hp.college.bean.XydtContact;
import com.example.hp.college.bean.YxxwContact;

import com.example.hp.college.bean.dao.CfbgContactDao;
import com.example.hp.college.bean.dao.TzggContactDao;
import com.example.hp.college.bean.dao.StudentsContactDao;
import com.example.hp.college.bean.dao.KydtContactDao;
import com.example.hp.college.bean.dao.XmcgContactDao;
import com.example.hp.college.bean.dao.XsjzContactDao;
import com.example.hp.college.bean.dao.XxgkContactDao;
import com.example.hp.college.bean.dao.XydtContactDao;
import com.example.hp.college.bean.dao.YxxwContactDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig cfbgContactDaoConfig;
    private final DaoConfig tzggContactDaoConfig;
    private final DaoConfig studentsContactDaoConfig;
    private final DaoConfig kydtContactDaoConfig;
    private final DaoConfig xmcgContactDaoConfig;
    private final DaoConfig xsjzContactDaoConfig;
    private final DaoConfig xxgkContactDaoConfig;
    private final DaoConfig xydtContactDaoConfig;
    private final DaoConfig yxxwContactDaoConfig;

    private final CfbgContactDao cfbgContactDao;
    private final TzggContactDao tzggContactDao;
    private final StudentsContactDao studentsContactDao;
    private final KydtContactDao kydtContactDao;
    private final XmcgContactDao xmcgContactDao;
    private final XsjzContactDao xsjzContactDao;
    private final XxgkContactDao xxgkContactDao;
    private final XydtContactDao xydtContactDao;
    private final YxxwContactDao yxxwContactDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        cfbgContactDaoConfig = daoConfigMap.get(CfbgContactDao.class).clone();
        cfbgContactDaoConfig.initIdentityScope(type);

        tzggContactDaoConfig = daoConfigMap.get(TzggContactDao.class).clone();
        tzggContactDaoConfig.initIdentityScope(type);

        studentsContactDaoConfig = daoConfigMap.get(StudentsContactDao.class).clone();
        studentsContactDaoConfig.initIdentityScope(type);

        kydtContactDaoConfig = daoConfigMap.get(KydtContactDao.class).clone();
        kydtContactDaoConfig.initIdentityScope(type);

        xmcgContactDaoConfig = daoConfigMap.get(XmcgContactDao.class).clone();
        xmcgContactDaoConfig.initIdentityScope(type);

        xsjzContactDaoConfig = daoConfigMap.get(XsjzContactDao.class).clone();
        xsjzContactDaoConfig.initIdentityScope(type);

        xxgkContactDaoConfig = daoConfigMap.get(XxgkContactDao.class).clone();
        xxgkContactDaoConfig.initIdentityScope(type);

        xydtContactDaoConfig = daoConfigMap.get(XydtContactDao.class).clone();
        xydtContactDaoConfig.initIdentityScope(type);

        yxxwContactDaoConfig = daoConfigMap.get(YxxwContactDao.class).clone();
        yxxwContactDaoConfig.initIdentityScope(type);

        cfbgContactDao = new CfbgContactDao(cfbgContactDaoConfig, this);
        tzggContactDao = new TzggContactDao(tzggContactDaoConfig, this);
        studentsContactDao = new StudentsContactDao(studentsContactDaoConfig, this);
        kydtContactDao = new KydtContactDao(kydtContactDaoConfig, this);
        xmcgContactDao = new XmcgContactDao(xmcgContactDaoConfig, this);
        xsjzContactDao = new XsjzContactDao(xsjzContactDaoConfig, this);
        xxgkContactDao = new XxgkContactDao(xxgkContactDaoConfig, this);
        xydtContactDao = new XydtContactDao(xydtContactDaoConfig, this);
        yxxwContactDao = new YxxwContactDao(yxxwContactDaoConfig, this);

        registerDao(CfbgContact.class, cfbgContactDao);
        registerDao(TzggContact.class, tzggContactDao);
        registerDao(StudentsContact.class, studentsContactDao);
        registerDao(KydtContact.class, kydtContactDao);
        registerDao(XmcgContact.class, xmcgContactDao);
        registerDao(XsjzContact.class, xsjzContactDao);
        registerDao(XxgkContact.class, xxgkContactDao);
        registerDao(XydtContact.class, xydtContactDao);
        registerDao(YxxwContact.class, yxxwContactDao);
    }
    
    public void clear() {
        cfbgContactDaoConfig.clearIdentityScope();
        tzggContactDaoConfig.clearIdentityScope();
        studentsContactDaoConfig.clearIdentityScope();
        kydtContactDaoConfig.clearIdentityScope();
        xmcgContactDaoConfig.clearIdentityScope();
        xsjzContactDaoConfig.clearIdentityScope();
        xxgkContactDaoConfig.clearIdentityScope();
        xydtContactDaoConfig.clearIdentityScope();
        yxxwContactDaoConfig.clearIdentityScope();
    }

    public CfbgContactDao getCfbgContactDao() {
        return cfbgContactDao;
    }

    public TzggContactDao getTzggContactDao() {
        return tzggContactDao;
    }

    public StudentsContactDao getStudentsContactDao() {
        return studentsContactDao;
    }

    public KydtContactDao getKydtContactDao() {
        return kydtContactDao;
    }

    public XmcgContactDao getXmcgContactDao() {
        return xmcgContactDao;
    }

    public XsjzContactDao getXsjzContactDao() {
        return xsjzContactDao;
    }

    public XxgkContactDao getXxgkContactDao() {
        return xxgkContactDao;
    }

    public XydtContactDao getXydtContactDao() {
        return xydtContactDao;
    }

    public YxxwContactDao getYxxwContactDao() {
        return yxxwContactDao;
    }

}
