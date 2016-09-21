package com.ifxme.tvos.mvp.api;

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
