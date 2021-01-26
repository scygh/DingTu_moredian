package com.moredian.entrance.guard.task;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface UpdateCenterService {

    String DOMAIN_NAME = "Domain-Name";
    String DOMAIN_NAME_HEADER = DOMAIN_NAME + ": ";
    String UPDATECENTER_NAME = "UpdateCenter";

    @Headers({DOMAIN_NAME_HEADER + UPDATECENTER_NAME})
    @GET("/Api/UpdateCenter/GetUpdateInfo")
    Call<UpdateInfo> syncUpdate(@Query("softwareKey") String softwareKey);
}
