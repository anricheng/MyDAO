package chou.aric.com.mysqlitedatabase;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by aric on 16/12/17.
 */

public class MyDbManager {
    // use dagger to inject doesn't work ,so we provide a init method to get db
//    @Inject
//    public static SQLiteDatabase mSqliteDatabase;

    @Inject
    Application application;
    public static SQLiteDatabase mSqliteDatabase;

    public static void init(Context context) {
        mSqliteDatabase = new MySQLiteHelper(context, "china.db", null, 1).getWritableDatabase();
    }

    /**
     * @param sql sql sentence string,normally it contains 4 types of sel sentence: add delete update query
     *            add:"insert into table_name values(field_1,field_2,...)"
     *            delete:"delete from table_name where field_name='value'"
     *            update: "update table_name set field_name='field_value' where field_name='value'"
     *            query:"select * from table_name where ...group by...having...order by"
     */
    public static void execute(String sql) {
        checkNotNull();
        mSqliteDatabase.execSQL(sql);
    }

    public static void insertSingle(Student student) {
        checkNotNull();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MySQLiteHelper.NAME, student.getName());
        contentValues.put(MySQLiteHelper.AGE, student.getAge());
        mSqliteDatabase.insert(MySQLiteHelper.TABLE_NAME, null, contentValues);
    }

    public static void insertAll(List<Student> students) {
        checkNotNull();
        for (Student student : students) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(MySQLiteHelper.NAME, student.getName());
            contentValues.put(MySQLiteHelper.AGE, student.getAge());
            mSqliteDatabase.insert(MySQLiteHelper.TABLE_NAME, null, contentValues);
        }
    }

    public static void delete(Student student) {
        checkNotNull();
        String whereAgs[] = new String[]{MySQLiteHelper.NAME + "=" + student.getName() + "and" + MySQLiteHelper.AGE + "=" + student.getAge()};
        mSqliteDatabase.delete(MySQLiteHelper.TABLE_NAME, null, whereAgs);
    }

    public static void update(Student student) {
        checkNotNull();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MySQLiteHelper.NAME, student.getName());
        contentValues.put(MySQLiteHelper.AGE, student.getAge());
        //mSqliteDatabase.update();
    }

    public static void query(Student student) {
        checkNotNull();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MySQLiteHelper.NAME, student.getName());
        contentValues.put(MySQLiteHelper.AGE, student.getAge());
        //mSqliteDatabase.query(MySQLiteHelper.TABLE_NAME,null,contentValues);
    }


    private static void checkNotNull() {
        if (mSqliteDatabase == null) {
            return;
        }
    }
}
