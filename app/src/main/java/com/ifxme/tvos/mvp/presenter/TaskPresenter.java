package com.ifxme.tvos.mvp.presenter;

import com.ifxme.tvos.mvp.presenter.impl.BasePresenterImpl;

/**
 * Created by Slbw on 2016/9/18.
 */
public interface TaskPresenter extends BasePresenter{

    /**
     * 获取工作人员列表
     */
    public void requestUserList();

    /**
     * 添加任务
     */
    public void addTask();

}
