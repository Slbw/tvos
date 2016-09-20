package com.ifxme.tvos.mvp.ui.view;

import com.ifxme.tvos.mvp.model.User;

import java.util.List;

/**
 * Created by Slbw on 2016/8/19.
 */
public interface UserView extends BaseView{

    void showProgress();
    void hideProgress();
    void showData(List<User> data);

}
