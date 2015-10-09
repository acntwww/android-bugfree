package com.acnt.bugfree.core.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.acnt.bugfree.BugFreeApplication;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;

/**
 * SQLite的工具类的封装
 * Created by NiuKY on 10/9.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DB_NAME = "bugfree.db";
    private static final int DB_VERSION = 1;


    public DatabaseHelper() {
        super(BugFreeApplication.getGlobalContext(), DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {

    }
}
