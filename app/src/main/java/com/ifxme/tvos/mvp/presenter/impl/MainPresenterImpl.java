package com.ifxme.tvos.mvp.presenter.impl;

import com.ifxme.tvos.mvp.api.APIManager;
import com.ifxme.tvos.mvp.api.ApiService;
import com.ifxme.tvos.mvp.api.response.GetUserResponse;
import com.ifxme.tvos.mvp.presenter.MainPresenter;
import com.ifxme.tvos.mvp.ui.view.MainView;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Slbw on 2016/8/19.
 */
public class MainPresenterImpl extends BasePresenterImpl implements MainPresenter{

    private MainView mMainView;

    public MainPresenterImpl(MainView mainView) {
        mMainView = mainView;
    }

    @Override
    public void getIpInfo() {
        mSubscriptions.add(APIManager.getInstance().getApi(ApiService.class,"http://www.ifxme.com:8080")
                .getUser(mMainView.getUserId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GetUserResponse>() {
                    @Override
                    public void onCompleted() {
                        mMainView.hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mMainView.hideProgress();
                    }

                    @Override
                    public void onNext(GetUserResponse getUserResponse) {
                        mMainView.showData(getUserResponse.getData().name);
                    }
                }));
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {

    }
}
