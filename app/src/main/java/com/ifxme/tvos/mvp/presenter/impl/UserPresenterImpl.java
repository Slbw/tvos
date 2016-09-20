package com.ifxme.tvos.mvp.presenter.impl;

import com.ifxme.tvos.mvp.api.APIManager;
import com.ifxme.tvos.mvp.api.ApiService;
import com.ifxme.tvos.mvp.api.response.GetUserListResponse;
import com.ifxme.tvos.mvp.api.response.GetUserResponse;
import com.ifxme.tvos.mvp.presenter.UserPresenter;
import com.ifxme.tvos.mvp.ui.view.UserView;
import com.ifxme.tvos.mvp.util.Constant;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Slbw on 2016/8/19.
 */
public class UserPresenterImpl extends BasePresenterImpl implements UserPresenter {

    private UserView mUserView;

    public UserPresenterImpl(UserView userView) {
        mUserView = userView;
    }

    @Override
    public void getUserList() {
        mSubscriptions.add(APIManager.getInstance().getApi(ApiService.class, Constant.host)
                .getUserList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GetUserListResponse>() {
                    @Override
                    public void onCompleted() {
                        mUserView.hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mUserView.hideProgress();
                    }

                    @Override
                    public void onNext(GetUserListResponse getUserListResponse) {
                        mUserView.showData(getUserListResponse.data);
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
