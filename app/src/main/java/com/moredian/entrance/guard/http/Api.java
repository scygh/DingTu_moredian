package com.moredian.entrance.guard.http;

import com.blankj.utilcode.util.SPUtils;

import com.moredian.entrance.guard.constant.Constants;
import com.moredian.entrance.guard.entity.ApiUserGet;
import com.moredian.entrance.guard.entity.GetCardPassword;
import com.moredian.entrance.guard.entity.GetCardTypeList;
import com.moredian.entrance.guard.entity.GetChannel;
import com.moredian.entrance.guard.entity.GetDepartmentList;
import com.moredian.entrance.guard.entity.GetDepositPage;
import com.moredian.entrance.guard.entity.GetDeviceNumList;
import com.moredian.entrance.guard.entity.GetDevicePattern;
import com.moredian.entrance.guard.entity.GetExpensePage;
import com.moredian.entrance.guard.entity.GetListByPage;
import com.moredian.entrance.guard.entity.GetMealList;
import com.moredian.entrance.guard.entity.GetSubsidyLevel;
import com.moredian.entrance.guard.entity.GetTokenRes;
import com.moredian.entrance.guard.entity.GetUserByUserID;
import com.moredian.entrance.guard.entity.MemberCreateReq;
import com.moredian.entrance.guard.entity.PostResponse;
import com.moredian.entrance.guard.entity.MemberDeleteReq;
import com.moredian.entrance.guard.entity.MemberUpdateReq;
import com.moredian.entrance.guard.entity.MoredianExpense;
import com.moredian.entrance.guard.entity.MoredianExpenseRequest;
import com.moredian.entrance.guard.entity.PostDepositBody;
import com.moredian.entrance.guard.entity.PostDeregister;
import com.moredian.entrance.guard.entity.PostRegister;
import com.moredian.entrance.guard.entity.PostResponseNoContent;
import com.moredian.entrance.guard.entity.PostUpdateDevice;
import com.moredian.entrance.guard.entity.ReisterResponse;
import com.moredian.entrance.guard.utils.AudioUtils;
import com.moredian.entrance.guard.utils.ToastHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2019/7/31 13:58
 */
public class Api {

    List<GetListByPage.ContentBean.RowsBean> rowsBeans;
    /**
     * descirption:回调list状态接口
     */
    private OnResponse onResponse;

    public interface OnResponse<T> {
        void onResponse(List<T> rowsBeans);

        void onResponseMore(List<T> rowsBeans);

        void onFailed();
    }

    public void setOnResponse(OnResponse onResponse) {
        this.onResponse = onResponse;
    }

    /**
     * descirption: 收到信息通知回调
     */
    private GetResponseListener getResponseListener;

    public void setGetResponseListener(GetResponseListener getResponseListener) {
        this.getResponseListener = getResponseListener;
    }

    public interface GetResponseListener<T> {
        void onRespnse(T t);

        void onFail(String err);
    }

    private OnCreate onCreate;

    public void setOnCreate(OnCreate onCreate) {
        this.onCreate = onCreate;
    }

    public interface OnCreate {
        void created();
    }

    /**
     * descirption: 获取登录者的信息
     */
    public void getToken(String account, String password) {
        ApiUtils.getTokenService().getToken(account, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetTokenRes>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetTokenRes getTokenRes) {
                        if (getTokenRes != null) {
                            if (getTokenRes.getStatusCode() == 200) {
                                SPUtils.getInstance().put(Constants.ISLOGIN, true);
                                SPUtils.getInstance().put(Constants.ACCESSTOKEN, getTokenRes.getContent().getAccessToken());
                                SPUtils.getInstance().put(Constants.USERID, getTokenRes.getContent().getUserId());
                                SPUtils.getInstance().put(Constants.ACCOUNT, getTokenRes.getContent().getAccount());
                                SPUtils.getInstance().put(Constants.COMPANY_CODE, getTokenRes.getContent().getCompanyCode());
                                if (onCreate != null) {
                                    onCreate.created();
                                }
                            } else {
                                ToastHelper.showToast(getTokenRes.getMessage());
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorExecute(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    /**
     * descirption: 获取消费者列表
     */
    public void getListByPage(int pageIndex, int pageSize, String name) {
        String token = SPUtils.getInstance().getString(Constants.ACCESSTOKEN);
        ApiUtils.getListByPageService().getListByPage(token, name, pageIndex, pageSize, true)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetListByPage>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetListByPage getListByPage) {
                        if (getListByPage != null && getListByPage.getStatusCode() == 200) {
                            rowsBeans = getListByPage.getContent().getRows();
                            if (onResponse != null) {
                                if (pageIndex > 1) {
                                    onResponse.onResponseMore(rowsBeans);
                                } else {
                                    onResponse.onResponse(rowsBeans);
                                }
                            }
                        } else {
                            ToastHelper.showToast(getListByPage.getMessage());
                            if (onResponse != null) {
                                onResponse.onFailed();
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorExecute(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void errorExecute(Throwable e) {
        if (e instanceof HttpException) {
            if (((HttpException) e).code() == 401) {
                String name = SPUtils.getInstance().getString(Constants.ACCOUNT);
                String password = SPUtils.getInstance().getString(Constants.PASSWORD);
                getToken(name, password);
                ToastHelper.showToast("登录信息失效，以为您重新登录，请重新打开此页面");
            } else {
                ResponseBody body = ((HttpException) e).response().errorBody();
                try {
                    JSONObject jsonObject = new JSONObject(body.string());
                    String error = jsonObject.getString("Message");
                    ToastHelper.showToast(error);
                } catch (JSONException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    /**
     * descirption: 创建人员
     */
    public void postCreate(MemberCreateReq memberCreateReq, String token, String modiantoken) {
        ApiUtils.postCreateService().createTask(memberCreateReq, token, modiantoken)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PostResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PostResponse postResponse) {
                        if (postResponse != null && postResponse.getStatusCode() == 200) {
                            if (onCreate != null) {
                                onCreate.created();
                            }
                        } else {
                            ToastHelper.showToast(postResponse.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorExecute(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * descirption: 更新人员
     */
    public void postUpdate(MemberUpdateReq postRequestBody, String token, String modiantoken) {
        ApiUtils.postUpdateService().createTask(postRequestBody, token, modiantoken)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PostResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PostResponse postResponse) {
                        if (postResponse != null && postResponse.getStatusCode() == 200) {
                            ToastHelper.showToast("添加人脸成功");
                        } else {
                            ToastHelper.showToast(postResponse.getMessage());
                            if (getResponseListener != null) {
                                getResponseListener.onFail(postResponse.getMessage());
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorExecute(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * descirption: 删除人员
     */
    public void postDelete(MemberDeleteReq postRequestBody, String token, String modiantoken) {
        Observable<PostResponse> observable = ApiUtils.postDeleteService().createTask(postRequestBody, token, modiantoken);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PostResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PostResponse postResponse) {
                        if (postResponse != null && postResponse.getStatusCode() == 200) {
                            ToastHelper.showToast("删除成功");
                            if (getResponseListener != null) {
                                getResponseListener.onRespnse(postResponse);
                            }
                        } else {
                            ToastHelper.showToast("未添加人脸");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorExecute(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    /**
     * descirption: 人脸支付
     */
    public void postFaceExpense(int companyCode, int deviceId, MoredianExpenseRequest moredianExpenseRequest, String token) {
        ApiUtils.postFaceExpenseService().createFaceExpense(companyCode, deviceId, moredianExpenseRequest, token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MoredianExpense>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MoredianExpense expense) {
                        if (expense != null && expense.getStatusCode() == 200) {
                            if (getResponseListener != null) {
                                getResponseListener.onRespnse(expense);
                            }
                        } else {
                            ToastHelper.showToast(expense.getMessage());
                            if (getResponseListener != null) {
                                getResponseListener.onFail(expense.getMessage());
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorExecute(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    /**
     * descirption: 按userID查询消费者
     */
    public void getUserByuserID(String userID, String token) {
        ApiUtils.getUserByUserIdService().GetByUserID(userID, token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetUserByUserID>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetUserByUserID user) {
                        if (user != null && user.getStatusCode() == 200) {
                            ToastHelper.showToast("查询成功");
                            if (getResponseListener != null) {
                                getResponseListener.onRespnse(user);
                            }
                        } else {
                            ToastHelper.showToast(user.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorExecute(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * descirption: 开户
     */
    public void postRegister(PostRegister body, String token) {
        ApiUtils.postRegisterService().register(body, token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PostResponseNoContent>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PostResponseNoContent postResponseNoContent) {
                        if (postResponseNoContent != null && postResponseNoContent.getStatusCode() == 200) {
                            ToastHelper.showToast("开户成功");
                            if (getResponseListener != null) {
                                getResponseListener.onRespnse(postResponseNoContent);
                            }
                        } else {
                            ToastHelper.showToast(postResponseNoContent.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorExecute(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * descirption: 销户
     */
    public void postDeRegister(PostDeregister body, String token) {
        ApiUtils.postDeRegisterService().deregister(body, token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PostResponseNoContent>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PostResponseNoContent postResponseNoContent) {
                        if (postResponseNoContent != null && postResponseNoContent.getStatusCode() == 200) {
                            AudioUtils.getInstance().speakText("注销成功");
                        } else {
                            ToastHelper.showToast(postResponseNoContent.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorExecute(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * descirption: 获取下一个卡内码
     */
    public void getNextCardNumber(String token) {
        ApiUtils.getNextNumberService().getNextNumberService(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ReisterResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ReisterResponse postResponse) {
                        if (postResponse != null && postResponse.getStatusCode() == 200) {
                            ToastHelper.showToast("获取下一个卡内码成功");
                            if (getResponseListener != null) {
                                getResponseListener.onRespnse(postResponse);
                            }
                        } else {
                            ToastHelper.showToast(postResponse.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorExecute(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * descirption: 获取部门列表
     */
    public void getDepartmentList(String token) {
        ApiUtils.getDepartmentListService().getDepartmentList(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetDepartmentList>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetDepartmentList departmentList) {
                        if (departmentList != null && departmentList.getStatusCode() == 200) {
                            ToastHelper.showToast("获取部门列表成功");
                            if (getResponseListener != null) {
                                getResponseListener.onRespnse(departmentList);
                            }
                        } else {
                            ToastHelper.showToast(departmentList.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorExecute(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * descirption: 获取卡片类型列表
     */
    public void getCardTypeList(String token) {
        ApiUtils.getCardTypeListService().getCardTypeListService(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetCardTypeList>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetCardTypeList cardTypeList) {
                        if (cardTypeList != null && cardTypeList.getStatusCode() == 200) {
                            ToastHelper.showToast("获取卡片类型列表成功");
                            if (getResponseListener != null) {
                                getResponseListener.onRespnse(cardTypeList);
                            }
                        } else {
                            ToastHelper.showToast(cardTypeList.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorExecute(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * descirption: 获取补贴等级列表
     */
    public void getSubsidyLevel(String token) {
        ApiUtils.getSubsidyLevelService().getSubsidyLevelService(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetSubsidyLevel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetSubsidyLevel getSubsidyLevel) {
                        if (getSubsidyLevel != null && getSubsidyLevel.getStatusCode() == 200) {
                            ToastHelper.showToast("获取补贴等级成功");
                            if (getResponseListener != null) {
                                getResponseListener.onRespnse(getSubsidyLevel);
                            }
                        } else {
                            ToastHelper.showToast(getSubsidyLevel.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorExecute(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * descirption: 按卡号获取用户
     */
    public void getUser(String token, String userid) {
        ApiUtils.getUser().getUser(token, userid, true)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApiUserGet>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ApiUserGet user) {
                        if (user != null && user.getStatusCode() == 200) {
                            if (getResponseListener != null) {
                                getResponseListener.onRespnse(user);
                            }
                        } else {
                            ToastHelper.showToast(user.getMessage());
                            if (user.getMessage().equals("Parameter error: number ")) {
                                ToastHelper.showToast("卡号错误");
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorExecute(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * descirption: 充值渠道
     */
    public void getChannel(String token) {
        ApiUtils.getChannel().getChannle(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetChannel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetChannel channel) {
                        if (channel != null && channel.getStatusCode() == 200) {
                            ToastHelper.showToast("获取充值渠道成功");
                            if (getResponseListener != null) {
                                getResponseListener.onRespnse(channel);
                            }
                        } else {
                            ToastHelper.showToast(channel.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorExecute(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * descirption: 充值
     */
    public void postDeposit(String token, PostDepositBody postDepositBody) {
        ApiUtils.postDeposit().deposit(postDepositBody, token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PostResponseNoContent>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PostResponseNoContent postResponseNoContent) {
                        if (postResponseNoContent != null && postResponseNoContent.getStatusCode() == 200) {
                            AudioUtils.getInstance().speakText("充值成功");
                            if (getResponseListener != null) {
                                getResponseListener.onRespnse(postResponseNoContent);
                            }
                        } else {
                            ToastHelper.showToast(postResponseNoContent.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorExecute(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * descirption: 退款
     */
    public void postRefund(String token, PostDepositBody postDepositBody) {
        ApiUtils.postRefund().postRefund(postDepositBody, token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PostResponseNoContent>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PostResponseNoContent postResponseNoContent) {
                        if (postResponseNoContent != null && postResponseNoContent.getStatusCode() == 200) {
                            ToastHelper.showToast("退款成功");
                        } else {
                            ToastHelper.showToast(postResponseNoContent.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorExecute(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * descirption: 获取充值报表
     */
    public void getDepositPage(String token, int pageIndex, int pagesize, String startTime, String endTime) {
        ApiUtils.getDepositPage().getDepositPage(pageIndex, pagesize, startTime, endTime, "TradeDateTime", "Desc", token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetDepositPage>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetDepositPage getDepositPage) {
                        if (getDepositPage != null && getDepositPage.getStatusCode() == 200) {
                            ToastHelper.showToast("查询充值记录成功");
                            if (onResponse != null) {
                                if (pageIndex > 1) {
                                    onResponse.onResponseMore(getDepositPage.getContent().getRows());
                                } else {
                                    onResponse.onResponse(getDepositPage.getContent().getRows());
                                }
                            }
                            if (getResponseListener != null) {
                                getResponseListener.onRespnse(getDepositPage);
                            }
                        } else {
                            ToastHelper.showToast(getDepositPage.getMessage());
                            if (onResponse != null) {
                                onResponse.onFailed();
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorExecute(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * descirption: 获取消费记录报表
     */
    public void getExpensePage(String token, int pageIndex, int pagesize, String startTime, String endTime) {
        ApiUtils.getExpensePage().getExpensePage(pageIndex, pagesize, startTime, endTime, "TradeDateTime", "Desc", token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetExpensePage>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetExpensePage getExpensePage) {
                        if (getExpensePage != null && getExpensePage.getStatusCode() == 200) {
                            ToastHelper.showToast("查询消费记录成功");
                            if (onResponse != null) {
                                if (pageIndex > 1) {
                                    onResponse.onResponseMore(getExpensePage.getContent().getRows());
                                } else {
                                    onResponse.onResponse(getExpensePage.getContent().getRows());
                                }
                            }
                            if (getResponseListener != null) {
                                getResponseListener.onRespnse(getExpensePage);
                            }
                        } else {
                            ToastHelper.showToast(getExpensePage.getMessage());
                            if (onResponse != null) {
                                onResponse.onFailed();
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorExecute(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * descirption: 获取每一个餐段的消费名称
     */
    public void getMealList(String token) {
        ApiUtils.getMealList().getMealList(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetMealList>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetMealList getMealList) {
                        if (getMealList != null && getMealList.getStatusCode() == 200) {
                            if (getResponseListener != null) {
                                getResponseListener.onRespnse(getMealList);
                            }
                        } else {
                            ToastHelper.showToast(getMealList.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorExecute(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * descirption: 获取设备号列表
     */
    public void getDeviceNumList(String token) {
        ApiUtils.getDeviceNumList().getDeviceNumList(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetDeviceNumList>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetDeviceNumList list) {
                        if (list != null && list.getStatusCode() == 200) {
                            ToastHelper.showToast("获取设备号列表成功");
                            if (getResponseListener != null) {
                                getResponseListener.onRespnse(list);
                            }
                        } else {
                            ToastHelper.showToast(list.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorExecute(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * descirption: 获取设备号对应的餐段
     */
    public void getDevicePattern(Integer id, String token) {
        ApiUtils.getDevicePattern().getDevicePattern(id, token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetDevicePattern>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetDevicePattern pattern) {
                        if (pattern != null && pattern.getStatusCode() == 200) {
                            ToastHelper.showToast("获取消费模式成功");
                            if (getResponseListener != null) {
                                getResponseListener.onRespnse(pattern);
                            }
                        } else {
                            ToastHelper.showToast(pattern.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorExecute(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * descirption: 获取设备号对应的餐段
     */
    public void setDevicePattern(Integer id, String pattern, String token) {
        PostUpdateDevice postUpdateDevice = new PostUpdateDevice();
        postUpdateDevice.setId(id);
        postUpdateDevice.setPattern(pattern);
        ApiUtils.setDevicePattern().postSetDevicePattern(postUpdateDevice, token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PostResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PostResponse response) {
                        if (response != null && response.getStatusCode() == 200) {
                            ToastHelper.showToast("设置成功");
                        } else {
                            ToastHelper.showToast(response.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorExecute(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * descirption: 获取卡的密码 商户密码
     */
    public void getCardPassword(String token) {
        ApiUtils.getCardPassword().getCardPassword(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetCardPassword>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetCardPassword getCardPassword) {
                        if (getCardPassword != null && getCardPassword.getStatusCode() == 200) {
                            ToastHelper.showToast("获取卡密码成功");
                            if (getResponseListener != null) {
                                getResponseListener.onRespnse(getCardPassword);
                            }
                        } else {
                            ToastHelper.showToast(getCardPassword.getMessage());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorExecute(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
