package com.example.administrator.mydbcontrol;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Administrator on 2017/5/31.
 */

public class App extends Application{
    public String DB_NAME = "city.db";
    public DaoSession daoSession;
    public SQLiteDatabase db;
    public DaoMaster.DevOpenHelper helper;
    public DaoMaster daoMaster;

    private static App instance;
    private static Context appContext;
    private static DBManager dbManager;
    public static App getAppInsatnce(){
        return instance;
    }
    public static Context getAppContext(){
        return appContext;
    }
    public static DBManager getDBManager(){
        return dbManager;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        setupDatabase();
        instance = this;
        appContext = getApplicationContext();
        dbManager = DBManager.getDBManager();
        //拷贝本地db文件到默认的databases目录下
        copyDBToDatabases();
    }

    private void setupDatabase() {
        //创建数据库
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        helper = new DaoMaster.DevOpenHelper(this, DB_NAME, null);
        Log.e("haifeng","copy了");
        //得到数据库连接对象
        db = helper.getWritableDatabase();
        //得到数据库管理者
        daoMaster =new DaoMaster(db);
        //得到daoSession，可以执行增删改查操作
        daoSession = daoMaster.newSession();
    }


    /**
     * assets目录下的db转移到databases
     */
    private static final String DB_PATH = "/data/data/com.example.administrator.mydbcontrol/databases/";
    public void copyDBToDatabases() {
        try {
            String outFileName = DB_PATH + DB_NAME;
            File file = new File(DB_PATH);
            if (!file.mkdirs()) {
                file.mkdirs();
            }
            File dataFile = new File(outFileName);
            if (dataFile.exists()) {
                dataFile.delete();
            }
            InputStream myInput;
            myInput = App.getAppContext().getAssets().open(DB_NAME);
            OutputStream myOutput = new FileOutputStream(outFileName);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            myOutput.flush();
            myOutput.close();
            myInput.close();
        } catch (IOException e) {
            Log.e("haifeng", "error--->" + e.toString());
            e.printStackTrace();
        }

    }


    public  DaoSession getDaoSession() {
        return daoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }
}
