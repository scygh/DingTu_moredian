package com.moredian.entrance.guard.http.retrofit;

import com.moredian.entrance.guard.entity.GetTokenRes;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2021/1/25 10:31
 */
public interface GetTokenService {

    @GET("Api/Token/GetToken")
    Observable<GetTokenRes> getToken(@Query("account") String account, @Query("password") String password);
}
