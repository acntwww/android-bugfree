package com.acnt.bugfree.core.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 任务的参数信息
 * Created by NiuKY on 9/30.
 */
@DatabaseTable(tableName = "task_parameters")
public class TaskParameter {


    /**
     * 说明该参数的值是本地的文件引用,用来进行本地文件的上传
     */
    public static final int LOCAL_FILE = 2;

    @SuppressWarnings("unused")
    @DatabaseField(generatedId = true, columnName = "parameter_id")
    private int parameterId;

    @DatabaseField(columnName = "parameter_key")
    private String key;
    @DatabaseField(columnName = "parameter_value")
    private String value;
    //是否是文件参数
    private boolean isLocalFile;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    @DatabaseField(columnName = "create_at")
    private long createAt;

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    @DatabaseField(columnName = "update_at")
    private long updateAt;


    @DatabaseField(columnName = "task_id", foreign = true, foreignAutoRefresh = true)
    private TaskInfo taskInfo = new TaskInfo();

    //这个狗找函数会被反射调用
    @SuppressWarnings("unused")
    public TaskParameter() {
    }

    public TaskParameter(String key, String value, boolean isLocalFile) {
        this.key = key;
        this.value = value;
        this.isLocalFile = isLocalFile;
        createAt = System.currentTimeMillis();
        updateAt = System.currentTimeMillis();
    }


    public TaskParameter(String key, String value) {
        this.key = key;
        this.value = value;
        this.isLocalFile = false;
        createAt = System.currentTimeMillis();
        updateAt = System.currentTimeMillis();
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isLocalFile() {
        return isLocalFile;
    }

    public void setIsLocalFile(boolean isLocalFile) {
        this.isLocalFile = isLocalFile;
    }

    @Override
    public String toString() {
        return "TaskParameter{" +
                "parameterId=" + parameterId +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", isLocalFile=" + isLocalFile +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", taskInfo=" + taskInfo +
                '}';
    }
}
