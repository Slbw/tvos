package com.ifxme.tvos.mvp.api;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by Slbw on 2016/8/19.
 */
public class APIManager {

    private static class APIManagerHolder {
        private static final APIManager INSTANCE = new APIManager();
    }

    private APIManager() {
    }

    public static final APIManager getInstance() {
        return APIManagerHolder.INSTANCE;
    }

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
                    .build();
            service =retrofit.create(t);
            return service;
        }
        return service;
    }

}
