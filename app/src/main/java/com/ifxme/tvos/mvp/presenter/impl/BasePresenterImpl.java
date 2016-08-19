package com.ifxme.tvos.mvp.presenter.impl;

import com.ifxme.tvos.mvp.presenter.BasePresenter;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by Slbw on 2016/8/19.
 */
public class BasePresenterImpl implements BasePresenter {

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
        if (mSubscriptions != null) {
            mSubscriptions.unsubscribe();
        }
    }
}
