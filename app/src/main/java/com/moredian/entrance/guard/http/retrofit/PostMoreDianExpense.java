package com.moredian.entrance.guard.http.retrofit;

import com.moredian.entrance.guard.entity.MoredianExpense;
import com.moredian.entrance.guard.entity.MoredianExpenseRequest;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2021/1/25 10:16
 */
public interface PostMoreDianExpense {

    @POST("IoTHubGateway/EM/HTTPv1/{companyCode}/{deviceId}/Trade/MoreDianFaceExpense")
    Observable<MoredianExpense> createFaceExpense(@Path("companyCode") int qrCodeCompanyCode, @Path("deviceId") int deviceID, @Body MoredianExpenseRequest param,@Header("AccessToken") String token);
}
