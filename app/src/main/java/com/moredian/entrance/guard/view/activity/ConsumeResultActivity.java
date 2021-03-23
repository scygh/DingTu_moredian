package com.moredian.entrance.guard.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.moredian.entrance.guard.R;
import com.moredian.entrance.guard.constant.Constants;
import com.moredian.entrance.guard.entity.DefiniteExpense;
import com.moredian.entrance.guard.entity.FaceExpense;
import com.moredian.entrance.guard.entity.MoredianExpense;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

public class ConsumeResultActivity extends BaseActivity {

    @BindView(R.id.cs_amount_big)
    TextView csAmountBig;
    @BindView(R.id.cs_consume_kind)
    TextView csConsumeKind;
    @BindView(R.id.cs_balance)
    TextView csBalance;
    @BindView(R.id.cs_amount_small)
    TextView csAmountSmall;
    @BindView(R.id.cs_date)
    TextView csDate;
    @BindView(R.id.cs_consume_pattern)
    TextView csConsumePattern;
    @BindView(R.id.cs_consume_result)
    TextView csConsumeResult;
    @BindView(R.id.cs_amount_big_ll)
    LinearLayout csAmountBigLl;
    @BindView(R.id.cs_balance_rl)
    RelativeLayout csBalanceRl;
    @BindView(R.id.cs_ll_detail)
    LinearLayout csLlDetail;
    @BindView(R.id.continue_consume)
    TextView continueConsume;
    @BindView(R.id.time_to_consume)
    TextView timeToConsume;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Date date;
    private MyTime myTime;

    public static Intent getFaceConsumeSuccessActivityIntent(Context context, MoredianExpense.ContentBean contentBean) {
        Intent intent = new Intent(context, ConsumeResultActivity.class);
        intent.putExtra(Constants.INTENT_CONSUME_FACESUCCESS, contentBean);
        return intent;
    }

    public static Intent getConsumeFailActivityIntent(Context context) {
        Intent intent = new Intent(context, ConsumeResultActivity.class);
        return intent;
    }

    @Override
    public int layoutView() {
        return R.layout.activity_consume_success;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        MoredianExpense.ContentBean facecontentbean = getIntent().getParcelableExtra(Constants.INTENT_CONSUME_FACESUCCESS);
        date = new Date();
        String time = dateFormat.format(date);
        if (facecontentbean != null) {
            csConsumeResult.setText("支付成功");
            csAmountBig.setText(facecontentbean.getExpenseDetail().getAmount() + "");
            csAmountSmall.setText(facecontentbean.getExpenseDetail().getAmount() + "");
            csBalance.setText(facecontentbean.getExpenseDetail().getBalance() + "元");
            csDate.setText(time);
            csConsumeKind.setText("人脸支付");
            csConsumePattern.setText("自动消费");
        } else {
            csConsumeResult.setText("支付失败");
            csConsumeResult.setTextColor(getResources().getColor(R.color.red));
            csAmountBigLl.setVisibility(View.GONE);
            csLlDetail.setVisibility(View.GONE);
        }
        myTime = new MyTime(60000, 1000);
        myTime.start();
    }

    @OnClick({R.id.continue_consume})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.continue_consume:
                finish();
                break;
        }
    }


    class MyTime extends CountDownTimer {
        public MyTime(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            timeToConsume.setText(millisUntilFinished / 1000 + "");
        }

        @Override
        public void onFinish() {
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (myTime != null) {
            myTime.cancel();
            myTime = null;
        }
    }
}
