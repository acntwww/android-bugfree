package com.acnt.bugfree.core.task;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.acnt.bugfree.core.entity.TaskInfo;
import com.acnt.bugfree.core.entity.UiTask;
import com.acnt.bugfree.core.sqlite.DatabaseHelper;
import com.acnt.bugfree.util.EventBusUtil;
import com.acnt.bugfree.util.TaskUtil;
import trikita.log.Log;

import java.sql.SQLException;

public class TaskExeService extends Service {

    @SuppressWarnings("unused")
    private static final String TAG = "TaskExeService";

    public TaskExeService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //开始的时候注册
        EventBusUtil.register(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(".....onStartCommand.......");
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //应用被销毁的时候,进行反注册
        EventBusUtil.unRegister(this);

    }


    /**
     * 用来接收引用成上的消息
     * @param task UI如任务的封装
     */
    @SuppressWarnings("unused")
    public void onEventBackgroundThread(UiTask task) {
        TaskInfo taskInfo = TaskUtil.convertFromUITask(task);
        try {
            DatabaseHelper.getInstance().saveTaskInfo(taskInfo);
        } catch (SQLException e) {
            Log.w("onEventBackgroundThread: receive: ", task, e);

        }
    }



}
