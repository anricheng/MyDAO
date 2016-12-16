package chou.aric.com.mydao.dbutils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.greenrobot.greendao.query.Query;

import java.util.List;

/*
 * Created by aric on 16/12/16.
 */

public class DBHelper {

    private static DaoMaster mMaster;
    private static DaoSession mSession;
    private static SQLiteDatabase mSQLiteDatabase;
    private static SonDao mSonDao;
    private static FatherDao mFatherDao;

    public static void init(Context context) {
        mSQLiteDatabase = new DaoMaster.DevOpenHelper(context, "person.db", null).getWritableDatabase();
        mMaster = new DaoMaster(mSQLiteDatabase);
        mSession = mMaster.newSession();
        mSonDao = mSession.getSonDao();
        mFatherDao = mSession.getFatherDao();
    }

    public static void addPerson(Father father, Son son) {
        long insert = mFatherDao.insert(father);
        son.setFatherId(insert);
        mSonDao.insert(son);
    }


    public static List<Son> queryAllSon() {
        return mSonDao.queryBuilder().list();
    }

    public static List<Father> queryAllFather() {
        return mFatherDao.queryBuilder().list();
    }

    public static Son querySonByName(String name) {
        return mSonDao.queryBuilder().where(SonDao.Properties.Name.eq(name)).unique();
    }

    public static Father queryFatherByName(String name) {
        return mFatherDao.queryBuilder().where(FatherDao.Properties.Name.eq(name)).unique();
    }

    public static List<Father> queryFatherByLikeName(String name) {
        return mFatherDao.queryBuilder().where(FatherDao.Properties.Name.like(name + "%")).list();
    }

    public static List<Father> queryFatherBetween(int start, int end) {
        return mFatherDao.queryBuilder().where(FatherDao.Properties.Age.between(start, end)).list();
    }


    public static List<Father> queryFatherGreaterThan(int start) {
        return mFatherDao.queryBuilder().where(FatherDao.Properties.Age.gt(start)).list();
    }

    public static List<Father> queryFatherGreaterThanAscOrder(int start) {
        return mFatherDao.queryBuilder().where(FatherDao.Properties.Age.gt(start)).orderAsc(FatherDao.Properties.Age).list();
    }

    //当前开启的线程方可执行查询
    public static List<Father> queryFatherGreaterThanAscOrderMutiThread(int start) {
        final Query<Father> build = mFatherDao.queryBuilder().where(FatherDao.Properties.Age.gt(start)).orderAsc(FatherDao.Properties.Age).build();
        new Thread(new Runnable() {
            @Override
            public void run() {
                build.forCurrentThread().list();
            }
        }).start();
        return null;
    }

    public static void queryOneByOne() {
        List<Son> sons = queryAllSon();

        for (Son son : sons) {
            son.getFather().getName();
        }

    }


}
