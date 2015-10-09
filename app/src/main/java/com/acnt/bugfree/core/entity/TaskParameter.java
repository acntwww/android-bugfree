package com.acnt.bugfree.core.entity;

/**
 * 任务的参数信息
 * Created by NiuKY on 9/30.
 */
public class TaskParameter {

    /**
     * 说明该参数是表单数据
     */
    public static final int FORM = 1;
    /**
     * 说明该参数的值是本地的文件引用,用来进行本地文件的上传
     */
    public static final int LOCAL_FILE = 2;

    private String key;
    private String value;
    private int paramType;


    public TaskParameter() {
    }

    public TaskParameter(String key, String value, int paramType) {
        this.key = key;
        this.value = value;
        this.paramType = paramType;
    }
}
