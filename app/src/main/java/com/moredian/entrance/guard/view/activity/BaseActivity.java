package com.moredian.entrance.guard.view.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import com.blankj.utilcode.util.SPUtils;
import com.moredian.entrance.guard.constant.Constants;
import com.moredian.entrance.guard.http.Api;
import com.moredian.entrance.guard.utils.NetUtil;
import com.moredian.entrance.guard.utils.ToastHelper;

import butterknife.ButterKnife;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2019/8/19 14:08
 */
public abstract class BaseActivity extends AppCompatActivity {

    public int pattern;//消费模式
    public String token;
    public Api api;
    public String deviceId;
    public String conpanyCode;
    public boolean isKeyEnable;

    public abstract int layoutView();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutView());
        ButterKnife.bind(this);
        pattern = SPUtils.getInstance().getInt(Constants.DEVICE_PATTERN);
        token = SPUtils.getInstance().getString(Constants.ACCESSTOKEN);
        api = new Api();
        deviceId = SPUtils.getInstance().getString(Constants.MACHINE_NUMBER, "1");
        conpanyCode = SPUtils.getInstance().getInt(Constants.COMPANY_CODE) + "";
        isKeyEnable = SPUtils.getInstance().getBoolean(Constants.KEY_ENABLE, false);

        if (!NetUtil.isNetWorkConnected(this)) {
            ToastHelper.showToast("当前网络不可用！");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        initView();
        initData();
    }

    public abstract void initView();

    public abstract void initData();

    /**
     * Android 6.0 以上设置状态栏颜色
     */
    private void setLightMode() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // 设置状态栏底色白色
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(Color.WHITE);
            // 设置状态栏字体黑色
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }
}
