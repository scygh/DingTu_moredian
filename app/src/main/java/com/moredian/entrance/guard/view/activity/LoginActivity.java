package com.moredian.entrance.guard.view.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import com.blankj.utilcode.util.SPUtils;
import com.moredian.entrance.guard.constant.Constants;
import com.moredian.entrance.guard.R;
import com.moredian.entrance.guard.entity.GetDevicePattern;
import com.moredian.entrance.guard.http.Api;
import com.moredian.entrance.guard.utils.ToastHelper;


import butterknife.BindView;
import butterknife.OnClick;


public class LoginActivity extends BaseActivity {

    @BindView(R.id.username_et)
    EditText usernameTv;
    @BindView(R.id.passsword_tv)
    EditText passswordTv;
    @BindView(R.id.remenberpassword_rb)
    CheckBox remenberpasswordRb;
    @BindView(R.id.login_btn)
    Button loginBtn;

    public static Intent getLoginActivityIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }

    @Override
    public int layoutView() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
    }

    @Override
    public void initData() {
        //显示保存的用户名和密码
        String existsUsername = SPUtils.getInstance().getString(Constants.USRTNAME, "");
        String existsPassword = SPUtils.getInstance().getString(Constants.PASSWORD, "");
        if (!TextUtils.isEmpty(existsUsername) && !TextUtils.isEmpty(existsPassword)) {
            usernameTv.setText(existsUsername);
            passswordTv.setText(existsPassword);
        }
        api.setOnCreate(new Api.OnCreate() {
            @Override
            public void created() {
                //第一次打开未登录，没有查询结果，所以重复查一次。
                token = SPUtils.getInstance().getString(Constants.ACCESSTOKEN);
                deviceId = SPUtils.getInstance().getString(Constants.MACHINE_NUMBER, "1");
                api.getDevicePattern(Integer.parseInt(deviceId), token);
            }
        });
        api.setGetResponseListener(new Api.GetResponseListener() {
            @Override
            public void onRespnse(Object o) {
                if (o instanceof GetDevicePattern) {
                    int devicePattern = ((GetDevicePattern) o).getContent().getPattern();
                    String pattern = "";
                    if (devicePattern == 1) {
                        pattern = "手动消费";
                    } else if (devicePattern == 2) {
                        pattern = "自动消费";
                        SPUtils.getInstance().put(Constants.AUTO_AMOUNT, ((GetDevicePattern) o).getContent().getAutoAmount(),true);
                    } else if (devicePattern == 3) {
                        pattern = "定值消费";
                    }
                    SPUtils.getInstance().put(Constants.DEVICE_PATTERN, pattern);
                    startActivity(DsyActivity.getDsyActivityIntent(LoginActivity.this));
                    finish();
                }
            }

            @Override
            public void onFail(String err) {
                ToastHelper.showToast(err);
            }
        });

    }

    @OnClick({R.id.login_btn, R.id.iv_come_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //先获取token,再去拿设备消费模式
            case R.id.login_btn:
                if (remenberpasswordRb.isChecked()) {//保存用户名密码
                    SPUtils.getInstance().put(Constants.USRTNAME, usernameTv.getText().toString().trim());
                    SPUtils.getInstance().put(Constants.PASSWORD, passswordTv.getText().toString().trim());
                } else {
                    SPUtils.getInstance().put(Constants.USRTNAME, "");
                    SPUtils.getInstance().put(Constants.PASSWORD, "");
                }
                String name = usernameTv.getText().toString().trim();
                String password = passswordTv.getText().toString().trim();
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password)) {
                    api.getToken(name, password);
                } else {
                    ToastHelper.showToast("用户名或者密码不能为空！");
                }
                break;
            case R.id.iv_come_back:
                finish();
                break;
        }
    }
}
