package com.ifxme.tvos.mvp.api;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Slbw on 2016/8/19.
 */
public interface ApiService {
    @GET("RestfulAPI/api/user/getUser")
   public Observable<GetUserResponse> getUser(@Query("userId") String userId);
}
