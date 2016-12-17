package chou.aric.com.mysqlitedatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by aric on 16/12/17.
 *We actually provide two way to access android sqlite db,one is basic sqlite sentence and one is google api
 */

public class MySQLiteHelper extends SQLiteOpenHelper{

    public static final String TABLE_NAME="stduent";
    public static final String _ID="_id";
    public static final String NAME="name";
    public static final String AGE="age";




    public MySQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //we can create a table for the database while the db was created;

        String createTableStr = "create table "+TABLE_NAME+" ("+_ID+" Integer primary key,"+NAME+" varchar(10),"+AGE+" Integer)";
        db.execSQL(createTableStr);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
