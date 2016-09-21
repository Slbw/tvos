package com.ifxme.tvos.mvp.ui.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.ifxme.tvos.R;
import com.ifxme.tvos.mvp.common.TVApplication;

/**
 * Created by Slbw on 2016/9/18.
 */
public class BaseActivity extends AppCompatActivity{

    protected Toolbar toolbar;
    protected TVApplication app;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        initView();
        initData();
        initListener();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app= (TVApplication) getApplication();
    }

    protected void initView()
    {
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        if(toolbar!=null)
        setSupportActionBar(toolbar);
    }

    protected void initData()
    {

    }

    protected void initListener()
    {
        if(toolbar!=null)
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    /**
     * 短toast
     * @param msg
     */
    protected void showMsg(String msg)
    {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }



}
