package com.ifxme.tvos.mvp.api;



import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Slbw on 2016/8/19.
 */
public class APIManager {

    private static class APIManagerHolder {
        private static final APIManager INSTANCE = new APIManager();
    }

    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

    private APIManager() {
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    public static final APIManager getInstance() {
        return APIManagerHolder.INSTANCE;
    }





    Interceptor interceptor = new Interceptor() {
        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request()
                    .newBuilder()
                    .addHeader("Content-Type", "charset=UTF-8")
                    .addHeader("Connection", "keep-alive")
                    .build();
            Response response=chain.proceed(request);
            //TODO something
            return response;
        }
    };


    OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(logging)
            .addInterceptor(interceptor)
            .build();

    /**
     * 获取api接口实例
     *
     * @param url
     * @param <T>
     * @return
     */
    public <T> T getApi(Class<T> t, String url) {
        T service = null;//后期考虑将其添加到map中重复利用
        if (service == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
            service =retrofit.create(t);
            return service;
        }
        return service;
    }

}
