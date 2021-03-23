package com.moredian.entrance.guard.view.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.moredian.entrance.guard.R;
import com.moredian.entrance.guard.constant.Constants;
import com.moredian.entrance.guard.entity.ApiUserGet;
import com.moredian.entrance.guard.entity.GetListByPage;
import com.moredian.entrance.guard.entity.GetUserByUserID;
import com.moredian.entrance.guard.entity.MemberCreateReq;
import com.moredian.entrance.guard.entity.MemberDeleteReq;
import com.moredian.entrance.guard.entity.MemberUpdateReq;
import com.moredian.entrance.guard.entity.PostDeregister;
import com.moredian.entrance.guard.entity.PostResponse;
import com.moredian.entrance.guard.http.Api;
import com.moredian.entrance.guard.utils.Base64BitmapUtil;
import com.moredian.entrance.guard.utils.DrawableUtils;
import com.moredian.entrance.guard.utils.ToastHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogRecord;

import butterknife.BindView;
import butterknife.OnClick;
import me.samlss.broccoli.Broccoli;
import me.samlss.broccoli.PlaceholderParameter;

public class PersonDetailActivity extends BaseActivity {

    private static final String TAG = "PersonDetailActivity";
    @BindView(R.id.persondetail_name)
    TextView persondetailName;
    @BindView(R.id.persondetail_stunum)
    TextView persondetailStunum;
    @BindView(R.id.persondetail_telephone)
    TextView persondetailTelephone;
    @BindView(R.id.persondetail_camera)
    ImageView persondetailCamera;
    @BindView(R.id.personDetail_createupdate)
    TextView personDetailCreateUpdate;
    @BindView(R.id.personDetail_delete)
    TextView personDetailDelete;

    private Bitmap bitmap;
    private Intent dataIntent;
    //当前的memberID
    //获取的page
    List<GetListByPage.ContentBean.RowsBean> arowsBeans = new ArrayList<>();
    //查询传入
    ApiUserGet.ContentBean findbean;
    String userid;
    String memberId;
    private Broccoli mBroccoli;

    @SuppressLint("handlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    setData(findbean);
                    break;
                case 2:
                    persondetailCamera.setImageResource(R.mipmap.icon_camera);
                    break;

            }
            super.handleMessage(msg);
        }
    };


    /**
     * descirption: 得到详情界面需要的intent
     */
    public static Intent getPersonDetailActivityIntent(Context context, String userid) {
        Intent intent = new Intent(context, PersonDetailActivity.class);
        intent.putExtra(Constants.INTENT_ROWSBEAN_BEAN, userid);
        return intent;
    }

    /**
     * descirption: 初始化占位图
     */
    private void initPlaceholders() {
        int placeholderColor = Color.parseColor("#DDDDDD");
        mBroccoli = new Broccoli();
        mBroccoli.addPlaceholders(
                new PlaceholderParameter.Builder()
                        .setView(persondetailName)
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeholderColor, 2))
                        .build(),
                new PlaceholderParameter.Builder()
                        .setView(persondetailStunum)
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeholderColor, 2))
                        .build(),
                new PlaceholderParameter.Builder()
                        .setView(persondetailTelephone)
                        .setDrawable(DrawableUtils.createRectangleDrawable(placeholderColor, 2))
                        .build()
        );
        mBroccoli.show();
    }

    @Override
    public int layoutView() {
        return R.layout.activity_person_detail_2;
    }

    @Override
    public void initView() {
        initPlaceholders();
    }

    @Override
    public void initData() {
        //根据Intent userID 查询用户信息。
        dataIntent = getIntent();
        userid = dataIntent.getStringExtra(Constants.INTENT_ROWSBEAN_BEAN);
        api.getUser(token, userid);
        api.setGetResponseListener(new Api.GetResponseListener() {
            @Override
            public void onRespnse(Object o) {
                if (o instanceof PostResponse) {
                    //如果是删除人脸成功了，就清空ExitMemberId,删除 照片
                    handler.sendEmptyMessage(2);
                } else if (o instanceof ApiUserGet) {//根据userid查询成功了则去设置信息
                    findbean = ((ApiUserGet) o).getContent();
                    handler.sendEmptyMessage(1);
                }
            }

            @Override
            public void onFail(String err) {
                ToastHelper.showToast(err);
            }
        });
        api.setOnCreate(new Api.OnCreate() {
            @Override
            public void created() {
                personDetailCreateUpdate.setText("添加人脸");
            }
        });
    }


    /**
     * descirption: 查询后设置数据,保存已存在人脸的id
     */
    private void setData(ApiUserGet.ContentBean findbean) {
        mBroccoli.removeAllPlaceholders();
        if (findbean.getUserFace() != null) {
            personDetailCreateUpdate.setText("添加人脸");
        } else {
            personDetailCreateUpdate.setText("创建人员");
        }
        persondetailName.setText(findbean.getUser().getName());
        persondetailStunum.setText(findbean.getUser().getCreateTime());
        persondetailTelephone.setText(findbean.getUser().getPhone());
        if (findbean.getUserFace() != null) {
            if (!TextUtils.isEmpty(findbean.getUserFace().getMemberBase64())) {
                bitmap = Base64BitmapUtil.base64ToBitmap(findbean.getUserFace().getMemberBase64());
                GlideIn();
            }
        }
    }

    @OnClick({R.id.persondetail_camera, R.id.personDetail_createupdate, R.id.personDetail_delete, R.id.personDetail_chongzhi, R.id.personDetail_xiaohu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.persondetail_camera:
                break;
            case R.id.personDetail_createupdate:
                if (personDetailCreateUpdate.getText().equals("添加人脸")) {
                    startActivityForResult(FaceInputActivity.getFaceInputActivityIntent(PersonDetailActivity.this), Constants.FACE_INPUT_REQUESTCODE);
                } else if (personDetailCreateUpdate.getText().equals("创建人员")) {
                    createPerson();
                }
                break;
            case R.id.personDetail_delete:
                deletePerson();
                break;
            case R.id.personDetail_chongzhi:
                startActivity(VoucherCenterActivity.getVoucherCenterActivityIntent(this, userid));
                break;
            case R.id.personDetail_xiaohu:
                showDialog();
                break;
        }
    }

    /**
     * descirption: 显示提示
     */
    private void showDialog() {
        new AlertDialog.Builder(PersonDetailActivity.this).setTitle("提示")
                .setMessage("您确定注销此用户？")
                //  取消选项
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                //  确认选项
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        deletePerson();//删除魔点人员
                        PostDeregister postDeregister = new PostDeregister();
                        postDeregister.setCost(findbean.getCard().getCost());
                        postDeregister.setMoney(findbean.getFinances().get(0).getBalance());
                        postDeregister.setUserID(findbean.getUser().getId());
                        api.postDeRegister(postDeregister, token);
                    }
                })
                .setCancelable(true)
                .show();
    }

    /**
     * descirption: 删除创建
     */
    private void deletePerson() {
        if (findbean != null) {
            MemberDeleteReq postRequestBody = new MemberDeleteReq(findbean.getUser().getId());
            api.postDelete(postRequestBody, token, Constants.MODIAN_TOKEN);
        }
    }

    /**
     * descirption: 创建人员
     */
    private synchronized void createPerson() {
        MemberCreateReq postRequestBody = new MemberCreateReq(findbean.getUser().getId(), findbean.getUser().getName(),
                findbean.getUser().getPhone());
        api.postCreate(postRequestBody, SPUtils.getInstance().getString(Constants.ACCESSTOKEN), Constants.MODIAN_TOKEN);
    }

    /**
     * descirption: 更新人脸
     */
    private synchronized void updatePerson() {
        Log.d("imageCheck", "updatePerson: " + bitmap.getHeight() + ":" + bitmap.getWidth());
        String base64 = Base64BitmapUtil.bitmapToBase64(bitmap);
        if (!TextUtils.isEmpty(userid)) {
            MemberUpdateReq postRequestBody = new MemberUpdateReq(findbean.getUser().getId(), base64);
            api.postUpdate(postRequestBody, SPUtils.getInstance().getString(Constants.ACCESSTOKEN), Constants.MODIAN_TOKEN);
        } else {
            ToastUtils.showShort("userid 为空");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == Constants.FACE_INPUT_REQUESTCODE && resultCode == Constants.FACE_INPUT_RESULTCODE) {
            byte[] image = data.getByteArrayExtra(Constants.INTENT_FACEINPUT_RGBDATA);
            memberId = data.getStringExtra(Constants.INTENT_FACEINPUT_MEMBERID);
            if (!TextUtils.isEmpty(memberId)) {//已经录入过的人脸识别到了memberid
                Log.d("faceinfo", "memberId" + memberId);
                ToastHelper.showToast("你已经录入过人脸了!");
            } else {//没录入的就去设置头像，创建人员
                setImage(image);
                updatePerson();
            }
        }
    }

    private void setImage(byte[] image) {
        if (image != null && image.length > 0) {
            bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
            GlideIn();
        }
    }

    /**
     * descirption: 设置头像
     */
    private void GlideIn() {
        RoundedCorners roundedCorners = new RoundedCorners(30);
        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(300, 300);
        Glide.with(this).load(bitmap).apply(options).into(persondetailCamera);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (arowsBeans != null) {
            arowsBeans.clear();
        }
        if (bitmap != null) {
            bitmap = null;
        }
        userid = null;
        handler.removeCallbacksAndMessages(null);
    }

}
