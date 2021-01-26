package com.moredian.entrance.guard.http.retrofit;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2019/7/31 11:32
 */
public interface GetUser {

    @GET("Api/User/Get")
    Observable<com.moredian.entrance.guard.entity.ApiUserGet> getUser(@Header("AccessToken") String token, @Query("UserId") String UserId, @Query("IsGetFaceInfo") boolean IsGetFaceInfo);
}
