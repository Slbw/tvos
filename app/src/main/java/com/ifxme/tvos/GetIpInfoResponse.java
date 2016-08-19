package com.ifxme.tvos;

import com.ifxme.tvos.mvp.model.IpInfo;

/**
 * Created by Slbw on 2016/8/19.
 */
public class GetIpInfoResponse extends BaseResponse {
    private IpInfo data;

    public IpInfo getData() {
        return data;
    }

    public void setData(IpInfo data) {
        this.data = data;
    }
}