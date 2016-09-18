package com.ifxme.tvos.mvp.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ifxme.tvos.R;
import com.ifxme.tvos.mvp.ui.BaseActivity;

public class AddTaskActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
    }

}
