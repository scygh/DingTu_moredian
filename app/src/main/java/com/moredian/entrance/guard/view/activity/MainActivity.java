package com.moredian.entrance.guard.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.moredian.entrance.guard.R;
import com.moredian.entrance.guard.app.MainApplication;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.main_ll1)
    LinearLayout mainLl1;
    @BindView(R.id.main_ll2)
    LinearLayout mainLl2;
    @BindView(R.id.main_ll3)
    LinearLayout mainLl3;
    @BindView(R.id.main_ll4)
    LinearLayout mainLl4;

    public static Intent getMainActivityIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
    }

    @Override
    public int layoutView() {
        return R.layout.activity_main;
    }


    /**
     * descirption: 自动会finish
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(DsyActivity.getDsyActivityIntent(this));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @OnClick({R.id.main_ll1, R.id.main_ll2, R.id.main_ll3, R.id.main_ll4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_ll1:
                startActivity(PersonsAddActivity.getPersonAddActivityIntent(this));
                break;
            case R.id.main_ll2:
                startActivity(PersonsManageActivity.getPersonsManageActivityIntent(this));
                break;
            case R.id.main_ll3:
                startActivity(new Intent(MainActivity.this, RecordActivity.class));
                break;
            case R.id.main_ll4:
                startActivity(PersonalSettingActivity.getPersonalSettingActivityIntent(this));
                break;
        }
    }
}
