package com.ifxme.tvos.mvp.ui.activity.task;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ifxme.tvos.R;
import com.ifxme.tvos.mvp.model.Task;
import com.ifxme.tvos.mvp.model.User;
import com.ifxme.tvos.mvp.presenter.TaskPresenter;
import com.ifxme.tvos.mvp.presenter.UserPresenter;
import com.ifxme.tvos.mvp.presenter.impl.TaskPresenterImpl;
import com.ifxme.tvos.mvp.presenter.impl.UserPresenterImpl;
import com.ifxme.tvos.mvp.ui.activity.BaseActivity;
import com.ifxme.tvos.mvp.ui.adapter.TaskListAdapter;
import com.ifxme.tvos.mvp.ui.adapter.UserListAdapter;
import com.ifxme.tvos.mvp.ui.view.AddTaskView;
import com.ifxme.tvos.mvp.ui.view.TaskView;

import java.util.ArrayList;
import java.util.List;

public class TaskActivity extends BaseActivity implements TaskView {

    private RecyclerView rvTask;
    private TaskPresenter mTaskPresenter;
    private List<Task> tasks;
    private TaskListAdapter adapter;
    private Toolbar toolbar;
    private FloatingActionButton fabAddTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        initView();
        initData();
        initListener();
    }

    private void initView() {
        rvTask = (RecyclerView) findViewById(R.id.rvTask);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvTask.setLayoutManager(mLayoutManager);
        rvTask.setItemAnimator(new DefaultItemAnimator());
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        fabAddTask=(FloatingActionButton)findViewById(R.id.fabAddTask);
        setSupportActionBar(toolbar);
    }

    private void initData() {
        tasks = new ArrayList<Task>();
        mTaskPresenter = new TaskPresenterImpl(this);
        mTaskPresenter.getTaskList();
        adapter = new TaskListAdapter(this, tasks);
        rvTask.setAdapter(adapter);
    }

    private void initListener() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        fabAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 添加任务
            }
        });
    }


    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showTaskList(List<Task> data) {
        tasks.clear();
        tasks.addAll(data);
        adapter.notifyDataSetChanged();
    }
}
