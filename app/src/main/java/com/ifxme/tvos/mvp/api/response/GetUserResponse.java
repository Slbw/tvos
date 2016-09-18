package com.ifxme.tvos.mvp.api.response;

import com.ifxme.tvos.mvp.api.BaseResponse;
import com.ifxme.tvos.mvp.model.User;

/**
 * Created by Slbw on 2016/8/19.
 */
public class GetUserResponse extends BaseResponse {

    private User data;


    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

}