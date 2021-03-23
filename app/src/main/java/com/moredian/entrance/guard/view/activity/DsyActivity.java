package com.moredian.entrance.guard.view.activity;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.android.tu.loadingdialog.LoadingDailog;
import com.blankj.utilcode.util.SPUtils;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;
import com.moredian.entrance.guard.R;
import com.moredian.entrance.guard.constant.Constants;
import com.moredian.entrance.guard.entity.GetDevicePattern;
import com.moredian.entrance.guard.entity.MoredianExpense;
import com.moredian.entrance.guard.entity.MoredianExpenseRequest;
import com.moredian.entrance.guard.face.CameraUtil;
import com.moredian.entrance.guard.face.CameraView;
import com.moredian.entrance.guard.face.drawface.DrawerSurfaceView;
import com.moredian.entrance.guard.http.Api;
import com.moredian.entrance.guard.utils.AudioUtils;
import com.moredian.entrance.guard.utils.ToastHelper;
import com.moredian.entrance.guard.view.designview.ComonDialog;
import com.moredian.entrance.guard.view.designview.PayDialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2019/9/16 17:43
 */
public class DsyActivity extends BaseActivity {

    private static final String TAG = "DsyActivity";

    @BindView(R.id.camera_view)
    CameraView mRgbCameraView;
    @BindView(R.id.nir_camera)
    CameraView mNirCameraView;
    @BindView(R.id.faceView)
    DrawerSurfaceView mDrawFaceView;
    @BindView(R.id.nir_tips)
    ImageView mNirTipsView;
    @BindView(R.id.detect_tips_tv)
    TextView mDetectResultView;
    @BindView(R.id.iv_rgb)
    ImageView mRgbFaceView;
    @BindView(R.id.iv_nir)
    ImageView mNirFaceView;
    @BindView(R.id.tv_pattern_title)
    TextView tvPatternTitle;
    @BindView(R.id.tv_pattern)
    TextView tvPattern;
    @BindView(R.id.tv_money)
    EditText tvMoney;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.tv_balance)
    TextView tvBalance;
    @BindView(R.id.tv_paycount)
    TextView tvPaycount;
    @BindView(R.id.rl_data)
    RelativeLayout rlData;
    @BindView(R.id.meal_viewpager)
    ViewPager mealViewpager;
    @BindView(R.id.dsy_refresh)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.dsy_switch)
    Switch able_switch;
    @BindView(R.id.main_menu)
    Button mainMenu;
    private boolean ableTag = true;
    private byte[] rgb_data;
    private String memberId;
    private static boolean mShowCallbackFace = false;
    private static int mCheckRgbCameraOpenCount = 0;

    private MyReceiver mReceiver = new MyReceiver();
    private String username;
    private LoadingDailog dialog;


    public static Intent getDsyActivityIntent(Context context) {
        Intent intent = new Intent(context, DsyActivity.class);
        return intent;
    }

    @Override
    public int layoutView() {
        return R.layout.activity_dsy;
    }


    @Override
    public void initView() {
        //是否可支付switch
        able_switch.setChecked(true);
        able_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ableTag = true;
                } else {
                    ableTag = false;
                }
            }
        });
        //下拉刷新重新获取消费模式和自动消费金额
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //使用机器前请设置好机器号
                        api.getDevicePattern(Integer.parseInt(deviceId), token);
                        refreshLayout.setRefreshing(false);
                    }
                }, 1000);
            }
        });
    }

    @Override
    public void initData() {
        SpeechUtility.createUtility(getApplicationContext(), SpeechConstant.APPID + "=12345678");
        AudioUtils.getInstance().init(getApplicationContext());
        initReceiver();
        initRequest();
        initCamera();
        LoadingDailog.Builder loadBuilder = new LoadingDailog.Builder(this)
                .setMessage("初始化...")
                .setCancelable(true)
                .setCancelOutside(true);
        dialog = loadBuilder.create();
        dialog.show();
    }

    /**
     * descirption: 初始化广播
     */
    private void initReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(Constants.DETECT_RESULT_ACTION);
        filter.addAction(Constants.NIR_RESULT_ACTION);
        filter.addAction(Constants.OFFLINE_RECOGNIZE_ACTION);
        filter.addAction(Constants.ONLINE_RECOGNIZE_ACTION);
        registerReceiver(mReceiver, filter);
    }

    /**
     * descirption: 初始化相机
     */
    private void initCamera() {
        int display_degree = CameraUtil.getRotation(DsyActivity.this);
        if (mRgbCameraView != null) {
            mRgbCameraView.init(CameraUtil.getBackCameraId(), display_degree, previewCallback, faceDetectionListener);
            mRgbCameraView.requestLayout();
            mRgbCameraView.start();
        }
        if (mNirCameraView != null) {
            mNirCameraView.init(CameraUtil.getFrontCameraId(), display_degree, nirPreviewCallback, null);
            mNirCameraView.requestLayout();
            mNirCameraView.start();
        }
    }


    /**
     * descirption: 初始化请求返回
     */
    private void initRequest() {
        api.setGetResponseListener(new Api.GetResponseListener() {
            @Override
            public void onRespnse(Object o) {
                if (o instanceof MoredianExpense) {//人脸消费
                    AudioUtils.getInstance().speakText("支付" + ((MoredianExpense) o).getContent().getExpenseDetail().getAmount() + "元");
                    startActivity(ConsumeResultActivity.getFaceConsumeSuccessActivityIntent(DsyActivity.this, ((MoredianExpense) o).getContent()));
                } else if (o instanceof GetDevicePattern) {//重新获取消费模式和自动金额
                    int devicePattern = ((GetDevicePattern) o).getContent().getPattern();
                    if (devicePattern == 1) {

                    } else if (devicePattern == 2) {
                        SPUtils.getInstance().put(Constants.AUTO_AMOUNT, ((GetDevicePattern) o).getContent().getAutoAmount(), true);
                    } else if (devicePattern == 3) {

                    }
                    SPUtils.getInstance().put(Constants.DEVICE_PATTERN, devicePattern);
                    pattern = devicePattern;
                    if (pattern == 2) {
                        tvMoney.setText(SPUtils.getInstance().getFloat(Constants.AUTO_AMOUNT) + "");
                    }
                }
            }

            @Override
            public void onFail(String err) {
                ToastHelper.showToast(err);
                startActivity(ConsumeResultActivity.getConsumeFailActivityIntent(DsyActivity.this));
            }
        });
    }

    /**
     * descirption: 人脸消费
     */
    private void faceConsume() {
        if (!TextUtils.isEmpty(memberId)) {
            if (ableTag) {
                String money = tvMoney.getText().toString();
                if (Double.parseDouble(money) > 0) {
                    if (pattern == 2) {
                        initDialog(money);
                    } else {
                        ToastHelper.showToast("请切换为自动消费模式");
                    }
                } else {
                    ToastHelper.showToast("金额必须大于零才能消费");
                }
            } else {
                ToastHelper.showToast("请先打开消费开关");
            }
        } else {
            ToastHelper.showToast("memberId为空");
        }
    }

    /**
     * descirption: 确认支付弹窗
     */
    private ComonDialog comonDialog;
    private boolean consumeing = false;

    private void initDialog(String money) {
        if (comonDialog != null || consumeing) {
            return;
        }
        consumeing = true;
        AudioUtils.getInstance().speakText("请确认支付金额");
        comonDialog = new ComonDialog(DsyActivity.this);
        comonDialog.setMessage("请确认支付：自动消费" + money + "元。");
        comonDialog.setTitle("支付提示")
                .setSingle(false).setOnClickBottomListener(new ComonDialog.OnClickBottomListener() {
            @Override
            public void onPositiveClick() {
                comonDialog.dismiss();
                if (isKeyEnable == true) {
                    createPayDialog(money);
                } else {
                    //TODO
                    MoredianExpenseRequest postFaceExpenseBody = new MoredianExpenseRequest(Double.parseDouble(money), 2, 1, "", memberId);
                    api.postFaceExpense(Integer.parseInt(conpanyCode), Integer.parseInt(deviceId), postFaceExpenseBody, token);
                }
                comonDialog = null;
            }

            @Override
            public void onNegtiveClick() {
                comonDialog.dismiss();
                comonDialog = null;
                consumeing = false;
            }
        }).show();
    }

    /**
     * descirption: 密码框
     */
    PayDialog payDialog = null;

    public void createPayDialog(String money) {
        if (payDialog == null) {
            payDialog = new PayDialog(this);
            payDialog.setPasswordCallback(new PayDialog.PasswordCallback() {
                @Override
                public void callback(String password) {
                    MoredianExpenseRequest postFaceExpenseBody = new MoredianExpenseRequest(Double.parseDouble(money), 2, 0, password, memberId);
                    api.postFaceExpense(Integer.parseInt(conpanyCode), Integer.parseInt(deviceId), postFaceExpenseBody, token);
                    payDialog.dismiss();
                }
            });
        }
        payDialog.clearPasswordText();
        payDialog.setMoney(tvMoney.getText().toString().trim());
        payDialog.show();
        payDialog.setCancelable(false);
        payDialog.setCanceledOnTouchOutside(false);
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Constants.KEY_CLEAR:
                    tvUsername.setText("");
                    tvUsername.setHint("请先识别");
                    tvBalance.setText("");
                    tvBalance.setHint("请先识别");
                    tvMoney.setText("");
                    tvMoney.setHint("刷脸支付");
                    break;
                case Constants.KEY_SET_TEXT:
                    String name = msg.getData().getString("name");
                    double balance = msg.getData().getDouble("balance");
                    tvUsername.setText(name.substring(0, 10));
                    tvBalance.setText(balance + "元");
                    break;
                //如果人脸识别已打开，红外生物识别获取焦点，如果没打开则延迟重来
                case Constants.KEY_OPEN_NIR_CAMERA:
                    if (mRgbCameraView != null) {
                        if (mRgbCameraView.hasOpened()) {
                            mNirCameraView.onResume();
                            mHandler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    dialog.dismiss();
                                }
                            }, 2000);
                        } else {
                            mCheckRgbCameraOpenCount++;
                            mHandler.sendEmptyMessageDelayed(Constants.KEY_OPEN_NIR_CAMERA, Constants.OPEN_MIR_CAMERA_DELAY + mCheckRgbCameraOpenCount * 1000);
                        }
                    }
                    break;
                //隐藏显示的文字
                case Constants.KEY_DETECT_HIDE:
                    mHandler.removeMessages(Constants.KEY_DETECT_HIDE);
                    Log.e(TAG, "hide detect result");
                    if (mDetectResultView.getVisibility() != View.GONE) {
                        mDetectResultView.setVisibility(View.GONE);
                    }
                    break;
                //靠近一点提醒，后隐藏
                case Constants.KEY_DETECT_FACE_SIZE_ERROR:
                    mHandler.removeMessages(Constants.KEY_DETECT_FACE_SIZE_ERROR);
                    Log.e(TAG, "face size incorrect");
                    if (!Constants.SIZE_INCORRECT_TIPS.equals(mDetectResultView.getText())) {
                        mDetectResultView.setText(Constants.SIZE_INCORRECT_TIPS);
                    }
                    if (mDetectResultView.getVisibility() != View.VISIBLE) {
                        mDetectResultView.setVisibility(View.VISIBLE);
                    }
                    mHandler.sendEmptyMessageDelayed(Constants.KEY_DETECT_HIDE, 2000);
                    break;
                //摆正提醒，后隐藏
                case Constants.KEY_DETECT_FACE_ANGLE_ERROR:
                    mHandler.removeMessages(Constants.KEY_DETECT_FACE_ANGLE_ERROR);
                    Log.e(TAG, "face angle incorrect");
                    if (!Constants.ANGLE_INCORRECT_TIPS.equals(mDetectResultView.getText())) {
                        mDetectResultView.setText(Constants.ANGLE_INCORRECT_TIPS);
                    }
                    if (mDetectResultView.getVisibility() != View.VISIBLE) {
                        mDetectResultView.setVisibility(View.VISIBLE);
                    }
                    mHandler.sendEmptyMessageDelayed(Constants.KEY_DETECT_HIDE, 2000);
                    break;
                //提醒保持静止提醒，后隐藏
                case Constants.KEY_DETECT_FACE_QUALITY_ERROR:
                    mHandler.removeMessages(Constants.KEY_DETECT_FACE_QUALITY_ERROR);
                    Log.e(TAG, "face quality incorrect");
                    if (!Constants.QUALITY_INCORRECT_TIPS.equals(mDetectResultView.getText())) {
                        mDetectResultView.setText(Constants.QUALITY_INCORRECT_TIPS);
                    }
                    if (mDetectResultView.getVisibility() != View.VISIBLE) {
                        mDetectResultView.setVisibility(View.VISIBLE);
                    }
                    mHandler.sendEmptyMessageDelayed(Constants.KEY_DETECT_HIDE, 2000);
                    break;
                //显示识别获取的名字后隐藏
                case Constants.KEY_DETECT_USER_NAME:
                    mHandler.removeMessages(Constants.KEY_DETECT_USER_NAME);
                    String username = msg.getData().getString(Constants.USER_NAME);
                    if (!username.equals(mDetectResultView.getText())) {
                        mDetectResultView.setText(username);
                    }
                    if (mDetectResultView.getVisibility() != View.VISIBLE) {
                        mDetectResultView.setVisibility(View.VISIBLE);
                    }
                    mHandler.sendEmptyMessageDelayed(Constants.KEY_DETECT_HIDE, 2000);
                    faceConsume();
                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }
    };

    public class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            //判断是否有信息
            if (action != null && !action.equals("")) {
                boolean status = intent.getBooleanExtra(Constants.CHECK_STATUS, false);
                rgb_data = intent.getByteArrayExtra(Constants.RGB_DATA);
                // 彩色摄像头抓到的人脸
                if (rgb_data != null && rgb_data.length > 0) {
                    Bitmap rgbBitmap = BitmapFactory.decodeByteArray(rgb_data, 0, rgb_data.length);
                    mRgbFaceView.setImageBitmap(rgbBitmap);
                    if (mShowCallbackFace) {
                        mRgbFaceView.setVisibility(View.VISIBLE);
                    }
                }
                //红外摄像头抓到的人脸
                byte[] nir_data = intent.getByteArrayExtra(Constants.NIR_DATA);
                if (nir_data != null && nir_data.length > 0) {
                    Bitmap rgbBitmap = BitmapFactory.decodeByteArray(nir_data, 0, nir_data.length);
                    mNirFaceView.setImageBitmap(rgbBitmap);
                    if (mShowCallbackFace) {
                        mNirFaceView.setVisibility(View.VISIBLE);
                    }
                }
                //如果获取失败则做相应的处理
                String reason = "";
                if (!status) {
                    reason = intent.getStringExtra(Constants.CHECK_FAIL_REASON);
                    Log.d(TAG, "receive:" + action + ",status:  " + status + ",reason  :" + reason);
                    //人脸质量不合格
                    if (action.equals(Constants.DETECT_RESULT_ACTION)) {
                        if (reason.contains(Constants.DETECT_FAIL_REASON_FACE_SIZE_INCORRECT)) {
                            mHandler.sendEmptyMessage(Constants.KEY_DETECT_FACE_SIZE_ERROR);
                        } else if (reason.contains(Constants.DETECT_FAIL_REASON_NOFACE)) {
                            mNirTipsView.setBackground(getResources().getDrawable(R.drawable.shap_nir_tip_default));
                        } else if (reason.contains(Constants.DETECT_FAIL_REASON_FACE_ANGLE_INCORRECT)) {
                            mHandler.sendEmptyMessage(Constants.KEY_DETECT_FACE_ANGLE_ERROR);
                        } else if (reason.contains(Constants.DETECT_FAIL_REASON_FACE_QUALITY_TOO_LOW)) {
                            mHandler.sendEmptyMessage(Constants.KEY_DETECT_FACE_QUALITY_ERROR);
                        }
                        //是否是活体
                    } else if (action.equals(Constants.NIR_RESULT_ACTION)) {
                        mNirTipsView.setBackground(getResources().getDrawable(R.drawable.shap_nir_tip_fail));
                    }
                } else {
                    //人脸质量合格
                    if (action.equals(Constants.DETECT_RESULT_ACTION)) {
                        int facecount = intent.getIntExtra(Constants.FACE_COUNT, 0);
                        String trackids = "";
                        long trackid = 01;
                        if (facecount > 0) {
                            for (int i = 0; i < facecount; i++) {
                                trackid = intent.getLongExtra(Constants.TRACK_ID + i, 0l);
                                trackids = trackids + "," + trackid;
                            }
                        }
                        Log.d("ascb", "DETECT_RESULT_ACTION: " + trackids);
                    } else if (action.equals(Constants.NIR_RESULT_ACTION)) {
                        long trackid = intent.getLongExtra(Constants.TRACK_ID, 0l);
                        mNirTipsView.setBackground(getResources().getDrawable(R.drawable.shap_nir_tip_succ));
                        Log.d("ascb", "NIR_RESULT_ACTION: " + trackid);
                    } else if (action.equals(Constants.OFFLINE_RECOGNIZE_ACTION) || action.equals(Constants.ONLINE_RECOGNIZE_ACTION)) {
                        long trackid = intent.getLongExtra(Constants.TRACK_ID, 0l);
                        Log.d("ascb", "OFFLINE_RECOGNIZE_ACTION: " + trackid);
                        username = intent.getStringExtra(Constants.USER_NAME);
                        memberId = intent.getStringExtra(Constants.PERSON_ID);
                        Log.d("ascb", "OFFLINE_RECOGNIZE_ACTION: " + memberId);
                        Message msg = new Message();
                        msg.what = Constants.KEY_DETECT_USER_NAME;
                        Bundle b = new Bundle();
                        b.putString(Constants.USER_NAME, username);
                        msg.setData(b);
                        mHandler.sendMessage(msg);
                    }
                }
            }
        }
    }

    @OnClick({R.id.main_menu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_menu:
                startActivity(MainActivity.getMainActivityIntent(DsyActivity.this));
                finish();
                break;
        }
    }

    private boolean leftTop = false;
    private boolean rightTop = false;
    private boolean rightBottom = false;
    private boolean leftBpttom = false;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        if (x < 200 && y < 200) {
            leftTop = true;
            Log.d(TAG, "leftTop" + x + "，" + y);
        } else if (x > 520 && y < 200) {
            rightTop = true;
            Log.d(TAG, "rightTop" + x + "，" + y);
        } else if (x > 520 && y > 1080) {
            rightBottom = true;
            Log.d(TAG, "rightBottom" + x + "，" + y);
        } else if (x < 200 && y > 1080) {
            leftBpttom = true;
            Log.d(TAG, "leftBpttom" + x + "，" + y);
        }
        if (leftTop && leftBpttom && rightBottom && rightTop) {
            //MainApplication.getSerialPortUtils().closeSerialPort();
            finish();
        }
        return super.onTouchEvent(event);
    }

    private Camera.PreviewCallback previewCallback = new Camera.PreviewCallback() {
        @Override
        public void onPreviewFrame(byte[] data, Camera camera) {
        }
    };

    private Camera.FaceDetectionListener faceDetectionListener = new Camera.FaceDetectionListener() {
        @Override
        public void onFaceDetection(final Camera.Face[] faces, Camera camera) {
            if (mDrawFaceView != null) {
                mDrawFaceView.setFaces(faces);
            }
        }
    };

    private Camera.PreviewCallback nirPreviewCallback = new Camera.PreviewCallback() {
        @Override
        public void onPreviewFrame(byte[] data, Camera camera) {
        }
    };

    /**
     * descirption: 先开启mRgbCameraView ，后开启mNirCameraView，如果后者不成功则不断请求开启
     */
    @Override
    protected void onResume() {
        super.onResume();
        //自动消费显示消费金额
        if (pattern == 2) {
            tvMoney.setText(SPUtils.getInstance().getFloat(Constants.AUTO_AMOUNT) + "");
            consumeing = false;
        } else {
            ToastHelper.showToast("请切换为自动消费模式");
        }
        if (mRgbCameraView != null) {
            mRgbCameraView.onResume();
        }
        if (mNirCameraView != null) {
            if (mRgbCameraView.hasOpened()) {
                mNirCameraView.onResume();
            } else {
                mHandler.sendEmptyMessageDelayed(Constants.KEY_OPEN_NIR_CAMERA, Constants.OPEN_MIR_CAMERA_DELAY);
            }
        }
        leftTop = false;
        rightTop = false;
        rightBottom = false;
        leftBpttom = false;
    }

    /**
     * descirption: mNirTipsView恢复默认 ，两个Cameraview 暂停
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
        if (mNirTipsView != null) {
            mNirTipsView.setBackground(getResources().getDrawable(R.drawable.shap_nir_tip_default));
        }
        if (mRgbCameraView != null) {
            mRgbCameraView.onPause();
        }
        if (mNirCameraView != null) {
            mNirCameraView.onPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    /**
     * descirption: 恢复初始，解绑广播,关闭串口
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
        if (mRgbCameraView != null) {
            mRgbCameraView.stop();
            mRgbCameraView = null;
        }
        if (mNirCameraView != null) {
            mNirCameraView.stop();
            mNirCameraView = null;
        }
        try {
            unregisterReceiver(mReceiver);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        mHandler.removeCallbacksAndMessages(null);
        if (dialog != null) {
            dialog.cancel();
        }
        ableTag = true;
    }

}
