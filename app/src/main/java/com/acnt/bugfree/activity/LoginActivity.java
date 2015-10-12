package com.acnt.bugfree.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.acnt.bugfree.R;
import com.acnt.bugfree.activity.base.BaseActivity;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_login);
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



