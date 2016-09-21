package com.ifxme.tvos.mvp.presenter;

import com.ifxme.tvos.mvp.presenter.impl.BasePresenterImpl;

/**
 * Created by Slbw on 2016/9/18.
 */
public interface TaskPresenter extends BasePresenter{

    /**
     * 获取工作人员列表
     */
     void requestUserList();

    /**
     * 添加任务
     */
     void addTask();

    /**
     * 获取所有任务列表
     */
     void getTaskList();

    /**
     * 获取我的任务列表
     * @param userId
     */
     void getTaskListById(int userId);

}
