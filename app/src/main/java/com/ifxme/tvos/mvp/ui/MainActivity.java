package com.ifxme.tvos.mvp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ifxme.tvos.R;
import com.ifxme.tvos.mvp.presenter.MainPresenter;
import com.ifxme.tvos.mvp.presenter.impl.MainPresenterImpl;
import com.ifxme.tvos.mvp.ui.view.MainView;



public class MainActivity extends AppCompatActivity implements MainView{


    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainPresenter=new MainPresenterImpl(this);
        mMainPresenter.getIpInfo();

    }

    @Override
    public void showProgress() {
        Log.e("MainActivity","showProgress");
    }

    @Override
    public void hideProgress() {
        Log.e("MainActivity","hideProgress");
    }

    @Override
    public String getIpText() {
        return "63.223.108.42";
    }

    @Override
    public void showData(String data) {
        Log.e("MainActivity","data:"+data);
    }


}
