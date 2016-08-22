package com.ifxme.tvos.mvp.presenter.impl;

import com.ifxme.tvos.mvp.presenter.BasePresenter;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by Slbw on 2016/8/19.
 */
public class BasePresenterImpl implements BasePresenter {

    //使用CompositeSubscription来持有所有的Subscriptions
    protected CompositeSubscription mSubscriptions = new CompositeSubscription();

    @Override
    public void onCreate() {

        if (mSubscriptions == null || mSubscriptions.isUnsubscribed()) {
            mSubscriptions = new CompositeSubscription();
        }
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {
        //关闭界面时取消所有订阅，防止内存泄漏
        if (mSubscriptions != null) {
            mSubscriptions.unsubscribe();
        }
    }
}
