package com.ifxme.tvos;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Slbw on 2016/8/19.
 */
public interface ApiService {
    @GET("service/getIpInfo.php")
    Observable<GetIpInfoResponse> getIpInfo(@Query("ip") String ip);
}
