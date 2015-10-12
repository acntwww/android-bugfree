package com.acnt.bugfree.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.acnt.bugfree.BugFreeApplication;

/**
 * Preference 的工具类
 * Created by NiuKY on 10/12.
 */
public class PreferenceUtil {

    private static final String TAG = "PreferenceUtil";
    private static final String PREFERENCE_FILE = "bugfree.xml";



    private static final String KEY_API_HOST = "";

    public static String getHost() {
        return  getSharePreference().getString(KEY_API_HOST, null);
    }

    public static void saveAPIHost(String apiHost) {
        getSharePreferenceEditor().putString(KEY_API_HOST, apiHost).apply();
    }

    private static SharedPreferences.Editor getSharePreferenceEditor() {
        return getSharePreference().edit();

    }
    private static SharedPreferences getSharePreference() {
        return  BugFreeApplication.getGlobalContext().getSharedPreferences(PREFERENCE_FILE, Context.MODE_PRIVATE);
    }


}
