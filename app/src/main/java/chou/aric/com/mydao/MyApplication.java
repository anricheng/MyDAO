package chou.aric.com.mydao;

import android.app.Application;

import chou.aric.com.mydao.dbutils.DBHelper;

/**
 * Created by aric on 16/12/16.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        DBHelper.init(this);
    }
}
