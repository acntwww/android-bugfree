package com.acnt.bugfree.activity.base;

import android.support.v7.app.AppCompatActivity;
import com.acnt.bugfree.util.EventBusUtil;

/**
 * 应用的基础类,封装一些基础的方法,方便子类的调用
 * Created by NiuKY on 9/30.
 */
public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onResume() {
        super.onResume();
        EventBusUtil.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBusUtil.unRegister(this);
    }
}
