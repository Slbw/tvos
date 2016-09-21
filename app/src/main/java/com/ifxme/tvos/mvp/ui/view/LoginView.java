package com.ifxme.tvos.mvp.ui.view;

import com.ifxme.tvos.mvp.model.User;

/**
 * Created by Slbw on 2016/9/21.
 */

public interface LoginView extends BaseView{

    void showProgress();
    void hideProgress();
    String getPhone();
    String getPassword();

    /**
     * 用户登录成功
     */
    void loginSuccess(User user);

    /**
     * 用户登录失败
     * @param errInfo
     */
    void loginFaild(String errInfo);
}
