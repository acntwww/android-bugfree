package com.acnt.bugfree.core.entity;

import java.util.ArrayList;
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

    public UiTask(String host, List<TaskParameter> parameters, String label, int level) {
        mAPIUrl = host;
        mParameters = parameters;
        addDefaultParams();
        mLabel = label;
        mLevel = level;
    }


    public UiTask(String host,String api, String label, int level) {
        mAPIUrl = host;
        mParameters = new ArrayList<TaskParameter>();
        mParameters.add(new TaskParameter("mode", api));
        addDefaultParams();
        mLabel = label;
        mLevel = level;
    }

    private void addDefaultParams() {
        TaskParameter p = new TaskParameter();
        p.setKey("format");
        p.setValue("json");
        mParameters.add(p);

        p = new TaskParameter();
        p.setKey("charset");
        p.setValue("utf8");
        mParameters.add(p);
    }



    public String getAPIUrl() {
        return mAPIUrl;
    }

    public List<TaskParameter> getParameters() {
        return mParameters;
    }

    public String getLabel() {
        return mLabel;
    }

    public int getLevel() {
        return mLevel;
    }
}
