package com.acnt.bugfree.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.acnt.bugfree.R;
import com.acnt.bugfree.activity.base.BaseActivity;
import com.acnt.bugfree.config.Configuration;
import trikita.log.Log;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity {

    @SuppressWarnings("unused")
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_login);

        startBackgroundService();
    }

    private void startBackgroundService() {
        Intent intent = new Intent();
        intent.setPackage(getPackageName());
        intent.setAction(Configuration.TASK_EXE_SERVICE);
        startService(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_host) {
            gotoChangeHostActivity();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void gotoChangeHostActivity() {
        Intent intent = new Intent(this, ChangeHostActivity.class);
        startActivity(intent);

    }
}



