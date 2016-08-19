package com.ifxme.tvos.mvp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ifxme.tvos.mvp.api.ApiService;
import com.ifxme.tvos.mvp.api.GetIpInfoResponse;
import com.ifxme.tvos.R;
import com.ifxme.tvos.mvp.presenter.MainPresenter;
import com.ifxme.tvos.mvp.presenter.impl.MainPresenterImpl;
import com.ifxme.tvos.mvp.ui.view.MainView;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;



public class MainActivity extends AppCompatActivity implements MainView{


    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainPresenter=new MainPresenterImpl(this);
        mMainPresenter.getIpInfo();

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://ip.taobao.com")
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();
//
//        ApiService apiService = retrofit.create(ApiService.class);
//
//        apiService.getIpInfo("63.223.108.42").subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<GetIpInfoResponse>() {
//                    @Override
//                    public void onCompleted() {
//                        Log.e("MainActivity", "onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e("MainActivity", "onError");
//                    }
//
//                    @Override
//                    public void onNext(GetIpInfoResponse getIpInfoResponse) {
//                        Log.e("MainActivity", getIpInfoResponse.getData().getCountry());
//                    }
//                });

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
