
package chou.aric.com.mydao.daggerUtils;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by clevo on 2015/6/9.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    Application getApplication();
    void SQLiteDatabaseInject(SQLiteDatabase myDbManager);
}