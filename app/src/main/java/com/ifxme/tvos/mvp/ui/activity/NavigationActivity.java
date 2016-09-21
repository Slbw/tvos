package com.ifxme.tvos.mvp.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ifxme.tvos.R;
import com.ifxme.tvos.mvp.ui.activity.contact.ContactActivity;
import com.ifxme.tvos.mvp.ui.activity.task.TaskActivity;

public class NavigationActivity extends AppCompatActivity {

    private Button btnContact;
    private Button btnTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        initView();
        initData();
        initListener();
    }

    private void initView()
    {
        btnContact=(Button)findViewById(R.id.btnContact);
        btnTask=(Button)findViewById(R.id.btnTask);
    }

    private void initData()
    {

    }

    private void initListener()
    {
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NavigationActivity.this,ContactActivity.class));
            }
        });

        btnTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NavigationActivity.this,TaskActivity.class));
            }
        });
    }

}
