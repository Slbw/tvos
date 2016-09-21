package com.ifxme.tvos.mvp.ui.activity.task;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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
    private FloatingActionButton fabAddTask;
    private boolean isShowMyTask = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
    }

    protected void initView() {
        super.initView();
        rvTask = (RecyclerView) findViewById(R.id.rvTask);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvTask.setLayoutManager(mLayoutManager);
        rvTask.setItemAnimator(new DefaultItemAnimator());
        fabAddTask = (FloatingActionButton) findViewById(R.id.fabAddTask);
    }

    protected void initData() {
        super.initData();
        tasks = new ArrayList<Task>();
        mTaskPresenter = new TaskPresenterImpl(this);
        mTaskPresenter.getTaskList();
        adapter = new TaskListAdapter(this, tasks);
        rvTask.setAdapter(adapter);
    }

    protected void initListener() {
        super.initListener();
        fabAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TaskActivity.this, AddTaskActivity.class));
            }
        });

        adapter.setOnItemClickListener(new TaskListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent();
                intent.setClass(TaskActivity.this, TaskDetailActivity.class);
                intent.putExtra(TaskDetailActivity.INTENT_TASK_INFO, tasks.get(position));
                startActivity(intent);
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_task, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_item_task) {
            if (isShowMyTask) {
                mTaskPresenter.getTaskListById(app.getUser().id);
                toolbar.getMenu().getItem(0).setTitle("查看所有");
                toolbar.setTitle("我的任务");
            } else {
                mTaskPresenter.getTaskList();
                toolbar.getMenu().getItem(0).setTitle("查看我的");
                toolbar.setTitle("所有任务");
            }
            isShowMyTask = !isShowMyTask;
        }
        return super.onOptionsItemSelected(item);
    }


}
