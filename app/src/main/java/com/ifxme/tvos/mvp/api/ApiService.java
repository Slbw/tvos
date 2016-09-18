package com.ifxme.tvos.mvp.api;

import com.ifxme.tvos.mvp.api.response.GetUserListResponse;
import com.ifxme.tvos.mvp.api.response.GetUserResponse;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Slbw on 2016/8/19.
 */
public interface ApiService {
    /**
     * 通过id 查找用户
     * @param userId
     * @return
     */
    @GET("RestfulAPI/api/user/getUser")
   public Observable<GetUserResponse> getUser(@Query("userId") String userId);

    /**
     * 获取用户列表
     * @return
     */
    @GET("RestfulAPI/api/user/list")
    public Observable<GetUserListResponse> getUserList();
}
