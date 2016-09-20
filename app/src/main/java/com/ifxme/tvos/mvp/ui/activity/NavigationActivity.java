package com.ifxme.tvos.mvp.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ifxme.tvos.R;

public class NavigationActivity extends AppCompatActivity {

    private Button btnContact;

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
    }

}
