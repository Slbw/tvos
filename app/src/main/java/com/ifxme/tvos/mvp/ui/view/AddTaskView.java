package com.ifxme.tvos.mvp.ui.view;

import com.ifxme.tvos.mvp.model.User;

import java.util.List;

/**
 * Created by Slbw on 2016/9/18.
 */
public interface AddTaskView extends BaseView{

    void showProgress();
    void hideProgress();

    /**
     * 获取负责人
     * @return
     */
    User getStaff();

    /**
     * 获取任务开始时间
     * @return
     */
    long getBeginTime();

}
