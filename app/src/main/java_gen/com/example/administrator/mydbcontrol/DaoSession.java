package com.example.administrator.mydbcontrol;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.example.administrator.mydbcontrol.tb_city;
import com.example.administrator.mydbcontrol.tb_province;

import com.example.administrator.mydbcontrol.tb_cityDao;
import com.example.administrator.mydbcontrol.tb_provinceDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig tb_cityDaoConfig;
    private final DaoConfig tb_provinceDaoConfig;

    private final tb_cityDao tb_cityDao;
    private final tb_provinceDao tb_provinceDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        tb_cityDaoConfig = daoConfigMap.get(tb_cityDao.class).clone();
        tb_cityDaoConfig.initIdentityScope(type);

        tb_provinceDaoConfig = daoConfigMap.get(tb_provinceDao.class).clone();
        tb_provinceDaoConfig.initIdentityScope(type);

        tb_cityDao = new tb_cityDao(tb_cityDaoConfig, this);
        tb_provinceDao = new tb_provinceDao(tb_provinceDaoConfig, this);

        registerDao(tb_city.class, tb_cityDao);
        registerDao(tb_province.class, tb_provinceDao);
    }
    
    public void clear() {
        tb_cityDaoConfig.getIdentityScope().clear();
        tb_provinceDaoConfig.getIdentityScope().clear();
    }

    public tb_cityDao getTb_cityDao() {
        return tb_cityDao;
    }

    public tb_provinceDao getTb_provinceDao() {
        return tb_provinceDao;
    }

}
