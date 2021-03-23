package com.moredian.entrance.guard.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.SPUtils;
import com.moredian.entrance.guard.R;
import com.moredian.entrance.guard.constant.Constants;
import com.moredian.entrance.guard.task.MainTask;
import com.moredian.entrance.guard.task.TaskParams;
import com.moredian.entrance.guard.utils.CleanDataUtils;
import com.moredian.entrance.guard.utils.ToastHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PersonalSettingActivity extends BaseActivity {

    @BindView(R.id.cache_tv)
    TextView cacheTv;

    /**
     * descirption: 获取当前activity 的Intent对象
     */
    public static Intent getPersonalSettingActivityIntent(Context context) {
        Intent intent = new Intent(context, PersonalSettingActivity.class);
        return intent;
    }

    @Override
    public int layoutView() {
        return R.layout.activity_personal_setting;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        clearCache();
    }

    private void clearCache() {
        try {
            String cache = CleanDataUtils.getTotalCacheSize(this);
            cacheTv.setText(cache);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClick({R.id.aps_about, R.id.aps_checkforupdate, R.id.aps_clearcahce, R.id.aps_logout, R.id.aps_machinesetting, R.id.aps_netsetting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.aps_about:
                ToastHelper.showToast("我是一个支付的机器");
                break;
            case R.id.aps_clearcahce:
                //清除缓存
                CleanDataUtils.clearAllCache(this);
                clearCache();
                break;
            case R.id.aps_logout:
                startActivity(LoginActivity.getLoginActivityIntent(this));
                SPUtils.getInstance().put(Constants.ISLOGIN, false);
                finish();
                break;
            case R.id.aps_machinesetting:
                startActivity(MachinesettingActivity.getMachinesettingActivityIntent(this));
                break;
            case R.id.aps_netsetting:
                startActivity(NetSettingActivity.getNetSettingActivityIntent(this));
                break;
            case R.id.aps_checkforupdate:
                TaskParams params = new TaskParams();
                MainTask.UpdateTask dbTask = new MainTask.UpdateTask(this, false);
                dbTask.execute(params);
                break;
        }
    }

}
