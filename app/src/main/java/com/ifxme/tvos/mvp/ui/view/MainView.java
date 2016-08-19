package com.ifxme.tvos.mvp.ui.view;

/**
 * Created by Slbw on 2016/8/19.
 */
public interface MainView extends BaseView{

    void showProgress();
    void hideProgress();
    void setIpText(String text);

}
