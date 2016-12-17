package chou.aric.com.mydao;

import android.app.Application;

import chou.aric.com.mydao.daggerUtils.AppComponent;
import chou.aric.com.mydao.daggerUtils.AppModule;
import chou.aric.com.mydao.daggerUtils.DaggerAppComponent;
import chou.aric.com.mydao.dbutils.DBHelper;
import chou.aric.com.mysqlitedatabase.MyDbManager;

/**
 * Created by aric on 16/12/16.
 */

public class MyApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent= DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        DBHelper.init(this);
        MyDbManager.init(this);
    }
}
