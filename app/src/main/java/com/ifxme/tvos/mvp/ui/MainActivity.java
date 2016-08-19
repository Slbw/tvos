package com.ifxme.tvos.mvp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ifxme.tvos.ApiService;
import com.ifxme.tvos.GetIpInfoResponse;
import com.ifxme.tvos.R;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ip.taobao.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        apiService.getIpInfo("63.223.108.42").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GetIpInfoResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.e("MainActivity", "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("MainActivity", "onError");
                    }

                    @Override
                    public void onNext(GetIpInfoResponse getIpInfoResponse) {
                        Log.e("MainActivity", getIpInfoResponse.getData().getCountry());
                    }
                });

    }
}
