package com.moredian.entrance.guard.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.moredian.entrance.guard.R;
import com.moredian.entrance.guard.entity.ApiUserGet;
import com.moredian.entrance.guard.entity.GetChannel;
import com.moredian.entrance.guard.entity.GetUser;
import com.moredian.entrance.guard.entity.GetUserByUserID;
import com.moredian.entrance.guard.entity.PostDepositBody;
import com.moredian.entrance.guard.entity.PostRechargeReq;
import com.moredian.entrance.guard.entity.PostResponseNoContent;
import com.moredian.entrance.guard.http.Api;
import com.moredian.entrance.guard.utils.ToastHelper;
import com.moredian.entrance.guard.view.adapter.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VoucherCenterActivity extends BaseActivity {

    @BindView(R.id.avc_name)
    TextView avcName;
    @BindView(R.id.avc_balance)
    TextView avcBalance;
    @BindView(R.id.fpa_cash_et)
    TextInputEditText fpaCashEt;
    @BindView(R.id.fpa_donate_et)
    TextInputEditText fpaDonateEt;
    @BindView(R.id.deposit)
    Button deposit;
    String userId;
    @BindView(R.id.spinner_channel)
    Spinner spinnerChannel;
    @BindView(R.id.donate_tv)
    TextView donateTv;
    @BindView(R.id.subsidy_tv)
    TextView subsidyTv;
    @BindView(R.id.card_type)
    TextView cardType;
    @BindView(R.id.DepartmentName)
    TextView DepartmentName;
    @BindView(R.id.SubsidyLevelName)
    TextView SubsidyLevelName;
    @BindView(R.id.ll_amount)
    LinearLayout llAmount;
    @BindView(R.id.ll_donate)
    LinearLayout llDonate;
    @BindView(R.id.fpa_money_et)
    TextInputEditText fpaMoneyEt;
    private int cardTypenum;

    public static Intent getVoucherCenterActivityIntent(Context context, String userId) {
        Intent intent = new Intent(context, VoucherCenterActivity.class);
        intent.putExtra("userid", userId);
        return intent;
    }

    @Override
    public int layoutView() {
        return R.layout.activity_voucher_center;
    }

    @Override
    public void initView() {
    }

    @Override
    public void initData() {
        api.getChannel(token);
        userId = getIntent().getStringExtra("userid");
        api.getUser(token, userId);
        api.setGetResponseListener(new Api.GetResponseListener<Object>() {
            @Override
            public void onRespnse(Object o) {
                if (o instanceof GetChannel) {
                    List<String> channel = new ArrayList<>();
                    for (int i = 0; i < ((GetChannel) o).getContent().size(); i++) {
                        channel.add(((GetChannel) o).getContent().get(i).getText());
                    }
                    spinnerChannel.setAdapter(new SpinnerAdapter(VoucherCenterActivity.this, channel.toArray(new String[channel.size()])));
                } else if (o instanceof ApiUserGet) {
                    cardType.setText(((ApiUserGet) o).getContent().getCard().getType() + "");
                    cardTypenum = ((ApiUserGet) o).getContent().getCard().getType();
                    DepartmentName.setText(((ApiUserGet) o).getContent().getUser().getDepartmentId() + "");
                    SubsidyLevelName.setText(((ApiUserGet) o).getContent().getCard().getLevel() + "");
                    showData(((ApiUserGet) o).getContent().getUser().getName(), ((ApiUserGet) o).getContent().getFinances().get(0).getBalance() + ((ApiUserGet) o).getContent().getFinances().get(1).getBalance()
                            + ((ApiUserGet) o).getContent().getFinances().get(3).getBalance(), ((ApiUserGet) o).getContent().getFinances().get(1).getBalance(), ((ApiUserGet) o).getContent().getFinances().get(3).getBalance());
                } else if (o instanceof PostResponseNoContent) {
                    refreshData();
                }
            }

            @Override
            public void onFail(String err) {
                ToastHelper.showToast("数据加载失败");
            }
        });
    }

    private void showData(String name, double balance, double subsidy, double donate) {
        avcName.setText(name);
        avcBalance.setText(balance + "");
        donateTv.setText(donate + "元");
        subsidyTv.setText(subsidy + "元");
    }

    @OnClick({R.id.deposit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.deposit:
                String deposit = fpaCashEt.getText().toString();
                String donate = fpaDonateEt.getText().toString();
                String money = fpaMoneyEt.getText().toString();
                String channel = (String) spinnerChannel.getSelectedItem();
                int c = 0;
                if (channel.equals("线上")) {
                    c = 0;
                } else if (channel.equals("支付宝转账")) {
                    c = 101;
                } else if (channel.equals("微信转账")) {
                    c = 102;
                } else if (channel.equals("银行卡转账")) {
                    c = 103;
                } else if (channel.equals("其他转账")) {
                    c = 104;
                }
                PostRechargeReq body = null;
                if (!TextUtils.isEmpty(money)) {
                    if (TextUtils.isEmpty(deposit)) {
                        ToastHelper.showToast("请输入充值金额");
                    } else {
                        body = new PostRechargeReq(1, 1, 1, 1, "", 1);
                        api.postDeposit(Integer.parseInt(conpanyCode), Integer.parseInt(deviceId), body, token);
                    }
                } else {
                    ToastHelper.showToast("请输入现金收取");
                }
                break;
        }
    }

    private void refreshData() {
        api.getUser(token, userId);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
