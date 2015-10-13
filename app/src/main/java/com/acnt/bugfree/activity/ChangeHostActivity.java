package com.acnt.bugfree.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.acnt.bugfree.R;
import com.acnt.bugfree.activity.base.BaseActivity;
import com.acnt.bugfree.config.API;
import com.acnt.bugfree.core.entity.TaskInfo;
import com.acnt.bugfree.core.entity.TaskResult;
import com.acnt.bugfree.core.entity.UiTask;
import com.acnt.bugfree.util.EventBusUtil;
import trikita.log.Log;

import java.awt.font.TextAttribute;

import static com.acnt.bugfree.R.id.et_host;

public class ChangeHostActivity extends BaseActivity {

    private TextInputLayout mTextInputLayout;
    private EditText mEtHostInfo;
    private Button mBtnTest;
    private Button mBtnSave;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_change_host);
        initViews();
        initActions();
    }



    private void initViews() {
        mBtnTest = (Button) findViewById(R.id.btn_test_host);
        mBtnSave = (Button) findViewById(R.id.btn_save_host);
        mEtHostInfo = (EditText) findViewById(et_host);
        mTextInputLayout = (TextInputLayout) findViewById(R.id.tiyt_host);

    }

    private void initActions() {
        mBtnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String host = mEtHostInfo.getText().toString();
                if (validateInput(host)) {
                    mTextInputLayout.setError("现在还没有实现");
                }


            }
        });

        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String host = mEtHostInfo.getText().toString();
                if (validateInput(host)) {
                    mTextInputLayout.setError("现在还没有实现143251");
                }
            }
        });
    }

    private UiTask getTestHostUITask() {
        String host = mEtHostInfo.getText().toString();
        host = "http://115.29.161.131:8090/bugfree3.0.4/api3.php";
        UiTask task = new UiTask(host, API.GET_SID, getTestHostTaskLabel(), TaskInfo.LEVEL_FORCE);
        return task;
    }

    private String getTestHostTaskLabel() {
        return "测试连接";
    }

    private boolean validateInput(String text) {
        if (TextUtils.isEmpty(text)) {
            mTextInputLayout.setError("服务器地址不能为空");
            return false;
        }
        return true;
    }

    public void onEventMainThread(TaskResult result) {
        Log.d("onEventMainThread: ", result);
    }

}
