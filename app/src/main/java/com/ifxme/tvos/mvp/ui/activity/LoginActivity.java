package com.ifxme.tvos.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.ifxme.tvos.R;
import com.ifxme.tvos.mvp.model.User;
import com.ifxme.tvos.mvp.presenter.LoginPresenter;
import com.ifxme.tvos.mvp.presenter.impl.LoginPresenterImpl;
import com.ifxme.tvos.mvp.ui.view.LoginView;


public class LoginActivity extends BaseActivity implements LoginView {

    private EditText etPhone;
    private EditText etPassword;
    private ProgressBar mProgressBar;
    private Button btnLogin;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    @Override
    protected void initView() {
        super.initView();
        etPhone = (EditText) findViewById(R.id.etPhone);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPhone = (EditText) findViewById(R.id.etPhone);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        mProgressBar = (ProgressBar) findViewById(R.id.login_progress);
    }

    @Override
    protected void initData() {
        super.initData();
        loginPresenter=new LoginPresenterImpl(this);
    }

    @Override
    protected void initListener() {
        super.initListener();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.doLogin();
            }
        });
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public String getPhone() {
        return etPhone.getText().toString();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }

    @Override
    public void loginSuccess(User user) {
        app.setUser(user);
        showMsg("登录成功");
        startActivity(new Intent(this,NavigationActivity.class));
        finish();
    }

    @Override
    public void loginFaild(String errInfo) {
        showMsg(errInfo);
    }
}

