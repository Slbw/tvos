package com.ifxme.tvos.mvp.api.response;

import com.ifxme.tvos.mvp.api.BaseResponse;
import com.ifxme.tvos.mvp.model.Task;
import com.ifxme.tvos.mvp.model.User;

import java.util.List;

/**
 * Created by Slbw on 2016/9/21.
 */

public class GetTaskListResponse extends BaseResponse{
    public List<Task> data;
}
