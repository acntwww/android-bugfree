package com.acnt.bugfree;

import android.app.Application;

/**
 * 整个应用程序的主类
 * Created by NiuKY on 10/9.
 */
public class BugFreeApplication extends Application {

    public static Application sApplicationContext;


    @Override
    public void onCreate() {
        super.onCreate();
        sApplicationContext = this;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        sApplicationContext = null;
    }


    public static Application getGlobalContext() {
        return sApplicationContext;
    }
}
