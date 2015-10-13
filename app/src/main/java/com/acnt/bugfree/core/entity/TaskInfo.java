package com.acnt.bugfree.core.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.List;

/**
 * 任务的详情
 * Created by NiuKY on 9/30.
 */
@DatabaseTable(tableName = "task_info")
public class TaskInfo  {

    /**
     * 任务还没有开始
     */
    public static final int STATUS_NOT_START = 1;

    /**
     * 任务正在执行
     */
    public static final int STATUS_RUNING = 2;

    /**
     * 任务被取消
     */
    public static final int STATUS_CANCELED = 3;

    /**
     * 任务执行成功
     */
    public static final int STATUS_SUCCESS = 0;

    //对应的错误代码都是小于0的,方便进行统计
    /**
     * 由于网络失败导致的失败,
     */
    public static final int STATUS_FAILED_NETWORK = -1;

    /**
     * 其他的失败情况
     */
    public static final int STATUS_FAILED_OTHER = -2;

    //定义任务的级别,级别数值越大,级别越低,给值设置成为间断的值,方便之后做扩展

    /**
     * 表示要立即执行该任务,不管当前是否有任务执行
     */
    public static final  int LEVEL_FORCE = 1;

    /**
     * 如果当前有任务执行,则在执行完当前任务后开始执行该任务,当前没有任务的话,就执行该任务
     */
    public static final  int LEVEL_PENDDING = 100;
    public static final  int LEVEL_COMMON = 10000;


    /**
     * 表示当前的任务是提交表单的任务
     */
    public static final  int TASK_FORM = 1;

    /**
     * 任务的ID
     */
    @DatabaseField(generatedId = true, columnName = "task_id")
    private int mTaskId;

    /**
     * 任务的级别
     */
    @DatabaseField(columnName = "level")
    private int mLevel;

    /**
     * 任务的状态
     */
    @DatabaseField(columnName = "status")
    private int mStatus;

    /**
     * 任务的类型
     */
    @DatabaseField(columnName = "task_type")
    private int mType = TASK_FORM;

    /**
     * 调用API地址
     */
    @DatabaseField(columnName = "api_url")
    private String mAPIUrl;


    /**
     * 任务的显示标识
     */
    @DatabaseField(columnName = "task_label")
    private String mTaskLabel;

    /**
     * 任务的参数
     */
    @ForeignCollectionField(eager = false, columnName = "task_prams")
    private List<TaskParameter> mParameters;

    /**
     * 执行结果的文本描述,在失败的情况下可以给日志信息填写进来
     */
    @DatabaseField(columnName = "result_info")
    private String mResultInfo;


    /**
     * 任务的创建时间
     */
    @DatabaseField(columnName = "careate_at")
    private long mCreateAt;

    /**
     * 任务的最后更新时间
     */
    @DatabaseField(columnName = "update_at")
    private long mUpdateAt;


    public int getTaskId() {
        return mTaskId;
    }

    public void setTaskId(int taskId) {
        mTaskId = taskId;
    }

    public int getLevel() {
        return mLevel;
    }

    public void setLevel(int level) {
        mLevel = level;
    }

    public int getStatus() {
        return mStatus;
    }

    public void setStatus(int status) {
        mStatus = status;
    }

    public int getType() {
        return mType;
    }

    public void setType(int type) {
        mType = type;
    }

    public String getAPIUrl() {
        return mAPIUrl;
    }

    public void setAPIUrl(String APIUrl) {
        mAPIUrl = APIUrl;
    }

    public String getTaskLabel() {
        return mTaskLabel;
    }

    public void setTaskLabel(String taskLabel) {
        mTaskLabel = taskLabel;
    }

    public List<TaskParameter> getParameters() {
        return mParameters;
    }

    public void setParameters(List<TaskParameter> parameters) {
        mParameters = parameters;
    }

    public long getCreateAt() {
        return mCreateAt;
    }

    public void setCreateAt(long createAt) {
        mCreateAt = createAt;
    }

    public long getUpdateAt() {
        return mUpdateAt;
    }

    public void setUpdateAt(long updateAt) {
        mUpdateAt = updateAt;
    }

    public String getResultInfo() {
        return mResultInfo;
    }

    public void setResultInfo(String resultInfo) {
        mResultInfo = resultInfo;
    }

    @Override
    public String toString() {
        return "TaskInfo{" +
                "mTaskId=" + mTaskId +
                ", mLevel=" + mLevel +
                ", mStatus=" + mStatus +
                ", mType=" + mType +
                ", mAPIUrl='" + mAPIUrl + '\'' +
                ", mTaskLabel='" + mTaskLabel + '\'' +
                ", mParameters=" + mParameters +
                ", mResultInfo='" + mResultInfo + '\'' +
                ", mCreateAt=" + mCreateAt +
                ", mUpdateAt=" + mUpdateAt +
                '}';
    }
}
