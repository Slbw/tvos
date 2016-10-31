package com.ifxme.tvos.mvp.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.ifxme.tvos.R;
import com.ifxme.tvos.mvp.ui.activity.contact.ContactActivity;
import com.ifxme.tvos.mvp.ui.activity.task.TaskActivity;

public class NavigationActivity extends BaseActivity {

    private Button btnContact;
    private Button btnTask;
    private Button btnChangePwd;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
    }

    @Override
    protected void initView() {
        super.initView();
        btnContact = (Button) findViewById(R.id.btnContact);
        btnTask = (Button) findViewById(R.id.btnTask);
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initListener() {
        super.initListener();
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NavigationActivity.this, ContactActivity.class));
            }
        });

        btnTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NavigationActivity.this, TaskActivity.class));
            }
        });
        btnChangePwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NavigationActivity.this, ChangePwdActivity.class));
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }

    private void logout() {
        app.setUser(null);
        finish();
        startActivity(new Intent(NavigationActivity.this, LoginActivity.class));
    }

}
