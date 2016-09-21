package com.ifxme.tvos.mvp.presenter;

/**
 * Created by Slbw on 2016/8/19.
 */
public interface UserPresenter extends BasePresenter{

    /**
     * 获取所有人员的列表
     */
    void getUserList();

    /**
     * 通过用户id获取相关的人员列表
     * @param userId
     */
    void getUserListById(int userId);

}
