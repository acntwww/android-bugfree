package com.acnt.bugfree.util;

import com.acnt.bugfree.core.entity.TaskInfo;
import com.acnt.bugfree.core.entity.UiTask;

/**
 * 任务调度的工具类
 * Created by NiuKY on 10/13.
 */
public class TaskUtil {

    public static TaskInfo convertFromUITask(UiTask task) {

        TaskInfo taskInfo = new TaskInfo();
        taskInfo.setAPIUrl(task.getAPIUrl());
        taskInfo.setLevel(task.getLevel());
        taskInfo.setParameters(task.getParameters());
        taskInfo.setTaskLabel(task.getLabel());

        taskInfo.setStatus(TaskInfo.STATUS_NOT_START);

        taskInfo.setCreateAt(System.currentTimeMillis());
        taskInfo.setCreateAt(System.currentTimeMillis());


        return taskInfo;
    }
}
