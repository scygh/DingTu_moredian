package com.moredian.entrance.guard.task;

import com.moredian.entrance.guard.BuildConfig;

public class UpdateConfig {


    private static final String TAG = "Update";
    public static final String APK_PACKAGENAME = "com.lianxi.dingtu.newsnfc";

    public static int getVerCode() {
        int verCode = BuildConfig.VERSION_CODE;
        return verCode;
    }

    public static String getVerName() {
        String VerName = BuildConfig.VERSION_NAME;
        return VerName;

    }

}
