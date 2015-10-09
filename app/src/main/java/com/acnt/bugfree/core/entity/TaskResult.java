package com.acnt.bugfree.core.entity;

/**
 * 任务执行的结果
 * Created by NiuKY on 10/9.
 */
public class TaskResult {

    private int mTaskId;
    //可以使用label来进行UI的处理
    private String mLabel;
    private String mResultInfo;


    public TaskResult(int taskId, String label, String resultInfo) {
        mTaskId = taskId;
        mLabel = label;
        mResultInfo = resultInfo;
    }
}
