package com.moredian.entrance.guard.http.retrofit;

import com.moredian.entrance.guard.entity.PostResponse;
import com.moredian.entrance.guard.entity.MemberUpdateReq;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2019/8/1 15:59
 */
public interface PostUpdate {

    @POST("Api/MoreDian/Member/Update")
    Observable<PostResponse> createTask(@Body MemberUpdateReq postRequestBody, @Header("AccessToken") String token, @Header("moredianToken") String modiantoken);
}
