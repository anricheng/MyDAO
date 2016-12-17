package chou.aric.com.mydao.daggerUtils;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import javax.inject.Singleton;

import chou.aric.com.mysqlitedatabase.MySQLiteHelper;
import dagger.Module;
import dagger.Provides;

/**
 * Created by clevo on 2015/6/9.
 * we use this class to get a singleton Application context;
 */
@Module
public class AppModule {

    private Application application;

    public AppModule(Application application){
        this.application=application;
    }


    @Provides
    @Singleton
    public Application provideApplication(){
        return application;
    }

    @Provides
    @Singleton
    public SQLiteDatabase provideMySQLiteHelper(){
        return new MySQLiteHelper(application,"china.db",null,1).getWritableDatabase();
    }
}