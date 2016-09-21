package com.ifxme.tvos.mvp.presenter.impl;

import com.ifxme.tvos.mvp.api.APIManager;
import com.ifxme.tvos.mvp.api.ApiService;
import com.ifxme.tvos.mvp.api.BaseResponse;
import com.ifxme.tvos.mvp.api.response.GetLoginResponse;
import com.ifxme.tvos.mvp.api.response.GetTaskListResponse;
import com.ifxme.tvos.mvp.presenter.LoginPresenter;
import com.ifxme.tvos.mvp.ui.view.LoginView;
import com.ifxme.tvos.mvp.ui.view.TaskView;
import com.ifxme.tvos.mvp.util.Constant;
import com.ifxme.tvos.mvp.util.MD5Util;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Slbw on 2016/9/21.
 */

public class LoginPresenterImpl extends BasePresenterImpl implements LoginPresenter {

    private LoginView loginView;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void doLogin() {
        mSubscriptions.add(APIManager.getInstance().getApi(ApiService.class, Constant.host)
                .login(loginView.getPhone(), MD5Util.Md5(loginView.getPassword()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GetLoginResponse>() {
                    @Override
                    public void onCompleted() {
                        loginView.hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        loginView.hideProgress();
                        loginView.loginFaild(e.getMessage());
                    }

                    @Override
                    public void onNext(GetLoginResponse getLoginResponse) {
                        if(getLoginResponse.code== BaseResponse.CODE_SUCCESS) {
                            loginView.loginSuccess(getLoginResponse.data);
                        }
                        else
                        {
                            loginView.loginFaild(getLoginResponse.msg);
                        }
                    }
                }));
    }
}
