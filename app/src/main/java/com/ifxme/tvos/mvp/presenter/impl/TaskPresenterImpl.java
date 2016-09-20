package com.ifxme.tvos.mvp.presenter.impl;

import com.ifxme.tvos.mvp.presenter.TaskPresenter;
import com.ifxme.tvos.mvp.ui.view.AddTaskView;

/**
 * Created by Slbw on 2016/9/18.
 */
public class TaskPresenterImpl extends BasePresenterImpl implements TaskPresenter{

    private AddTaskView addTaskView;

    public TaskPresenterImpl(AddTaskView addTaskView) {
        this.addTaskView = addTaskView;
    }


    @Override
    public void requestUserList() {

    }

    @Override
    public void addTask() {

    }
}
