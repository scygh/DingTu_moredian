package com.moredian.entrance.guard.http.retrofit;

import com.moredian.entrance.guard.entity.MemberCreateReq;
import com.moredian.entrance.guard.entity.PostResponse;
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
public interface PostCreate {

    @POST("Api/MoreDian/Member/Create")
    Observable<PostResponse> createTask(@Body MemberCreateReq postRequestBody, @Header("AccessToken") String token, @Header("moredianToken") String modiantoken);
}
