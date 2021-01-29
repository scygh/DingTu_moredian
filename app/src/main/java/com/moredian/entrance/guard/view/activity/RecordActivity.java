package com.moredian.entrance.guard.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.moredian.entrance.guard.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecordActivity extends BaseActivity {

    @BindView(R.id.record_tv_voucher)
    TextView recordTvVoucher;
    @BindView(R.id.record_tv_consume)
    TextView recordTvConsume;
    @BindView(R.id.record_tv_sevendays)
    TextView recordTvSevendays;

    @Override
    public int layoutView() {
        return R.layout.activity_record;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.record_tv_voucher, R.id.record_tv_consume, R.id.record_tv_sevendays})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.record_tv_voucher:
                startActivity(DepositRecordActivity.getDepositRecordActivityIntent(this));
                break;
            case R.id.record_tv_consume:
                startActivity(ConsumeRecordActivity.getConsumeRecordActivityIntent(this));
                break;
            case R.id.record_tv_sevendays:
                startActivity(ChartActivity.getChartActivityIntent(this));
                break;
        }
    }
}
