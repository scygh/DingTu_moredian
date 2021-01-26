package com.moredian.entrance.guard.view.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.blankj.utilcode.util.SPUtils;
import com.moredian.entrance.guard.R;
import com.moredian.entrance.guard.constant.Constants;
import com.moredian.entrance.guard.entity.GetDeviceNumList;
import com.moredian.entrance.guard.entity.GetDevicePattern;
import com.moredian.entrance.guard.entity.PostsetDevicePattern;
import com.moredian.entrance.guard.http.Api;
import com.moredian.entrance.guard.view.adapter.SpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MachinesettingActivity extends BaseActivity {

    @BindView(R.id.machinesetting_machine_number)
    Spinner machinesettingMachineNumber;
    @BindView(R.id.machinesetting_port)
    Spinner machinesettingPort;
    @BindView(R.id.machinesetting_baudrate)
    EditText machinesettingBaudrate;
    @BindView(R.id.persondetail_sure)
    Button persondetailSure;
    @BindView(R.id.machinesetting_device_pattern)
    Spinner machinesettingDevicePattern;
    private List<String> deviceNums = new ArrayList<>();

    public static Intent getMachinesettingActivityIntent(Context context) {
        Intent intent = new Intent(context, MachinesettingActivity.class);
        return intent;
    }

    @Override
    public int layoutView() {
        return R.layout.activity_machinesetting;
    }

    @Override
    public void initView() {
        //消费模式
        String[] devicePattern = getResources().getStringArray(R.array.devicepattern);
        machinesettingDevicePattern.setAdapter(new SpinnerAdapter(this, devicePattern));
        String pattern = SPUtils.getInstance().getString(Constants.DEVICE_PATTERN);
        for (int k = 0; k < devicePattern.length; k++) {
            if (devicePattern[k].equals(pattern)) {
                machinesettingDevicePattern.setSelection(k);
                break;
            }
        }
    }

    @Override
    public void initData() {
        api.getDeviceNumList(token);
        api.setGetResponseListener(new Api.GetResponseListener() {
            @Override
            public void onRespnse(Object o) {
                if (o instanceof GetDeviceNumList) {
                    deviceNums.clear();
                    for (int i = 0; i < ((GetDeviceNumList) o).getContent().size(); i++) {
                        deviceNums.add(((GetDeviceNumList) o).getContent().get(i).getId() + "");
                    }
                    String[] arr = deviceNums.toArray(new String[((GetDeviceNumList) o).getContent().size()]);
                    machinesettingMachineNumber.setAdapter(new SpinnerAdapter(MachinesettingActivity.this, arr));
                    String devicenum = SPUtils.getInstance().getString(Constants.MACHINE_NUMBER, "1");
                    for (int j = 0; j < deviceNums.size(); j++) {
                        if (deviceNums.get(j).equals(devicenum)) {
                            machinesettingMachineNumber.setSelection(j);
                        }
                    }
                } else if (o instanceof GetDevicePattern) {
                    SPUtils.getInstance().put(Constants.AUTO_AMOUNT, ((GetDevicePattern) o).getContent().getAutoAmount(), true);
                    SPUtils.getInstance().put(Constants.KEY_ENABLE, ((GetDevicePattern) o).getContent().isKeyEnabled(), true);
                }
            }

            @Override
            public void onFail(String err) {

            }
        });
        machinesettingMachineNumber.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (deviceNums.size() > 0) {
                    api.getDevicePattern(Integer.parseInt(deviceNums.get(position)), token);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    @OnClick({R.id.persondetail_sure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.persondetail_sure:
                break;
        }
    }

    @Override
    protected void onStop() {
        String machineNumber = (String) machinesettingMachineNumber.getSelectedItem();
        String devicepattern = (String) machinesettingDevicePattern.getSelectedItem();
        SPUtils.getInstance().put(Constants.MACHINE_NUMBER, machineNumber);

        SPUtils.getInstance().put(Constants.DEVICE_PATTERN, devicepattern);
        String pattern = "";
        if (devicepattern.equals("手动消费")) {
            pattern = "1";
        } else if (devicepattern.equals("自动消费")) {
            pattern = "2";
        } else if (devicepattern.equals("定值消费")) {
            pattern = "3";
        }
        PostsetDevicePattern postsetDevicePattern = new PostsetDevicePattern(SPUtils.getInstance().getFloat(Constants.AUTO_AMOUNT) + "", pattern);
        if (machineNumber != null) {
            api.setDevicePattern(Integer.parseInt(machineNumber), pattern, token);
        }
        super.onStop();
    }
}
