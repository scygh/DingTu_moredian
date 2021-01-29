package com.moredian.entrance.guard.http.retrofit;

import com.moredian.entrance.guard.entity.BaseResponseAddisOK;
import com.moredian.entrance.guard.entity.PostRechargeReq;
import com.moredian.entrance.guard.entity.PostRechargeRes;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2021/1/27 15:13
 */
public interface PostRecharge {

    @POST("IoTHubGateway/EM/HTTPv1/{companyCode}/{deviceId}/Trade/Recharge")
    Observable<BaseResponseAddisOK<PostRechargeRes>> recharge(@Path("companyCode") int qrCodeCompanyCode, @Path("deviceId") int deviceID, @Body PostRechargeReq param, @Header("AccessToken") String token);
}
