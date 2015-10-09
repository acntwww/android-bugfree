package com.acnt.bugfree.core.entity;

import java.util.List;

/**
 * UI上产生的任务,用来给后台任务打交道
 * Created by NiuKY on 9/30.
 */
public class UiTask {

    private String mAPIUrl;
    private List<TaskParameter> mParameters;
    private String mLabel;
    private int mLevel;

    public UiTask(String APIUrl, List<TaskParameter> parameters, String label, int level) {
        mAPIUrl = APIUrl;
        mParameters = parameters;
        mLabel = label;
        mLevel = level;
    }
}
