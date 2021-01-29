package com.moredian.entrance.guard.view.activity;

import android.os.Handler;
import android.text.TextUtils;

import com.blankj.utilcode.util.SPUtils;
import com.moredian.entrance.guard.constant.Constants;
import com.moredian.entrance.guard.R;
import com.moredian.entrance.guard.entity.GetDevicePattern;
import com.moredian.entrance.guard.http.Api;
import com.moredian.entrance.guard.utils.ToastHelper;

public class SplashActivity extends BaseActivity {


    @Override
    public int layoutView() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        //如果登录过了才会在这个界面去请求消费模式，来供识别界面使用。
        if (!TextUtils.isEmpty(token)) {
            api.getDevicePattern(Integer.parseInt(deviceId), token);
        }
        //接收到返回后去保存消费模式，并且保存自动消费的金额到sharedPrefrence。
        api.setGetResponseListener(new Api.GetResponseListener() {
            @Override
            public void onRespnse(Object o) {
                if (o instanceof GetDevicePattern) {
                    int devicePattern = ((GetDevicePattern) o).getContent().getPattern();
                    if (devicePattern == 1) {

                    } else if (devicePattern == 2) {
                        SPUtils.getInstance().put(Constants.AUTO_AMOUNT, ((GetDevicePattern) o).getContent().getAutoAmount(), true);
                    } else if (devicePattern == 3) {

                    }
                    SPUtils.getInstance().put(Constants.DEVICE_PATTERN, devicePattern);
                }
            }

            @Override
            public void onFail(String err) {
                ToastHelper.showToast(err);
            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (SPUtils.getInstance().getBoolean(Constants.ISLOGIN)) {
                    startActivity(DsyActivity.getDsyActivityIntent(SplashActivity.this));
                } else {
                    startActivity(LoginActivity.getLoginActivityIntent(SplashActivity.this));
                }
                finish();
            }
        }, 1500);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
