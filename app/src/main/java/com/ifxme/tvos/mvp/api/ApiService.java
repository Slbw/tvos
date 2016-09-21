package com.ifxme.tvos.mvp.api;

import com.ifxme.tvos.mvp.api.response.GetLoginResponse;
import com.ifxme.tvos.mvp.api.response.GetTaskListResponse;
import com.ifxme.tvos.mvp.api.response.GetUserListResponse;
import com.ifxme.tvos.mvp.api.response.GetUserResponse;
import com.ifxme.tvos.mvp.api.response.MsgResponse;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Slbw on 2016/8/19.
 */
public interface ApiService {


    /**
     * 用户登录
     * @param phone
     * @param password
     * @return
     */
    @GET("RestfulAPI/api/user/login")
    public Observable<GetLoginResponse> login(@Query("phone") String phone,@Query("password") String password);

    /**
     * 通过id 查找用户
     *
     * @param userId
     * @return
     */
    @GET("RestfulAPI/api/user/getUser")
    public Observable<GetUserResponse> getUser(@Query("userId") String userId);

    /**
     * 获取用户列表
     *
     * @return
     */
    @GET("RestfulAPI/api/user/list")
    public Observable<GetUserListResponse> getUserList();


    /**
     * 获取任务列表
     *
     * @return
     */
    @GET("RestfulAPI/api/task/list")
    public Observable<GetTaskListResponse> getTaskList();


    /**
     * 获取我的任务列表
     * @param userId
     * @return
     */
    @GET("RestfulAPI/api/task/myList")
    public Observable<GetTaskListResponse> getMyTaskList(@Query("userId") int userId);


    /**
     * 保存任务列表
     * @param createrId
     * @param taskName
     * @param taskDesc
     * @param beginTime
     * @param type
     * @param taskRemark
     * @param staffId
     * @return
     */
    @GET("RestfulAPI/api/task/insert")
    public Observable<MsgResponse> saveTask(@Query("createrId") int createrId, @Query("taskName") String taskName, @Query("taskDesc") String taskDesc,
                                            @Query("beginTime") long beginTime, @Query("type") int type, @Query("taskRemark") String taskRemark, @Query("staffId") int staffId);
}
