package com.ifxme.tvos.mvp.api.response;

import com.ifxme.tvos.mvp.api.BaseResponse;
import com.ifxme.tvos.mvp.model.User;

import java.util.List;

/**
 * Created by Slbw on 2016/9/18.
 */
public class GetUserListResponse extends BaseResponse {

    public List<User> data;

}
