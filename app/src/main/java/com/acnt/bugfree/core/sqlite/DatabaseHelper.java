package com.acnt.bugfree.core.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.acnt.bugfree.BugFreeApplication;
import com.acnt.bugfree.core.entity.TaskInfo;
import com.acnt.bugfree.core.entity.TaskParameter;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import trikita.log.Log;

import java.sql.SQLException;
import java.util.List;

/**
 * SQLite的工具类的封装
 * Created by NiuKY on 10/9.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    @SuppressWarnings("unused")
    private static final String TAG = "DatabaseHelper";
    private static final String DB_NAME = "bugfree.db";
    private static final int DB_VERSION = 1;

    private static final DatabaseHelper INSTANCE = new DatabaseHelper();


    protected DatabaseHelper() {
        super(BugFreeApplication.getGlobalContext(), DB_NAME, null, DB_VERSION);
    }


    public static DatabaseHelper getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, TaskInfo.class);
            TableUtils.createTable(connectionSource, TaskParameter.class);
        } catch (SQLException e) {
            Log.w("onCreate:", e);

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, TaskInfo.class,false);
            TableUtils.dropTable(connectionSource, TaskParameter.class,false);
        } catch (SQLException ex) {
            Log.w("onCreate:", ex);
        }
    }



    public void saveTaskInfo(TaskInfo task) throws SQLException {
        Dao<TaskInfo, Integer> dao = getDao(TaskInfo.class);
        //getEmptyForeignCollection
        List<TaskParameter> parameters = task.getParameters();
        Log.d("saveTaskInfo: ","before", parameters);
        dao.assignEmptyForeignCollection(task,"task_prams");
        parameters = task.getParameters();
        Log.d("saveTaskInfo: ","after", parameters);
    }


}
