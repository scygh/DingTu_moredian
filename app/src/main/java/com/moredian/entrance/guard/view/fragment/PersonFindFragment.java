package com.moredian.entrance.guard.view.fragment;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.moredian.entrance.guard.R;
import com.moredian.entrance.guard.entity.GetListByPage;
import com.moredian.entrance.guard.http.Api;
import com.moredian.entrance.guard.view.activity.PersonDetailActivity;
import com.moredian.entrance.guard.view.adapter.PersonFindRvAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2019/8/20 09:27
 */
public class PersonFindFragment extends BaseFragment {

    private static final String TAG = "PersonFindFragment";
    @BindView(R.id.person_manage_recyclerview)
    RecyclerView personManageRecyclerview;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    @BindView(R.id.loading)
    ProgressBar loading;
    @BindView(R.id.loading_tv)
    TextView loadingTv;
    @BindView(R.id.loading_ll)
    RelativeLayout loadingLl;
    @BindView(R.id.fpf_find_et)
    EditText fpfFindEt;
    @BindView(R.id.fpf_find_clear)
    ImageView fpfFindClear;
    private PersonFindRvAdapter adapter;
    List<GetListByPage.ContentBean.RowsBean> findData = new ArrayList<>();
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (adapter == null) {
                initRecyclerview();
            } else {
                adapter.notifyDataSetChanged();
            }
        }
    };

    @Override
    public int initView() {
        return R.layout.fragment_person_find;
    }

    @Override
    public void initViewController() {
        swipeRefresh.setColorSchemeColors(getResources().getColor(R.color.icon));
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
                swipeRefresh.setRefreshing(false);
            }
        });
        fpfFindClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fpfFindEt.setText("");
                if (findData != null) {
                    findData.clear();
                }
                handler.post(runnable);
            }
        });
        fpfFindEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0) {
                    fpfFindClear.setVisibility(View.INVISIBLE);
                    findData.clear();
                    handler.post(runnable);
                } else {
                    fpfFindClear.setVisibility(View.VISIBLE);
                }
                refresh();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                refresh();
            }
        });
    }

    @Override
    public void initData() {
        api.setOnResponse(new Api.OnResponse<GetListByPage.ContentBean.RowsBean>() {
            @Override
            public void onResponse(List<GetListByPage.ContentBean.RowsBean> rowsBeans) {
                if (findData != null && findData.size() > 0) {
                    findData.clear();
                }
                findData.addAll(rowsBeans);
                handler.post(runnable);
            }

            @Override
            public void onResponseMore(List<GetListByPage.ContentBean.RowsBean> rowsBeans) {

            }

            @Override
            public void onFailed() {

            }
        });
    }

    /**
     * descirption: 刷新一次
     */
    private void refresh() {
        if (TextUtils.isEmpty(fpfFindEt.getText().toString())) {
            return;
        }
        api.getListByPage(1, 20, fpfFindEt.getText().toString());
    }

    /**
     * descirption: 初始化列表数据
     */
    private void initRecyclerview() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        personManageRecyclerview.setLayoutManager(linearLayoutManager);
        personManageRecyclerview.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
        adapter = new PersonFindRvAdapter(mContext, findData);
        personManageRecyclerview.setAdapter(adapter);
        adapter.setMyItemClickListener(new PersonFindRvAdapter.OnMyItemClickListener() {
            @Override
            public void onItemClick(String userid) {
                startActivity(PersonDetailActivity.getPersonDetailActivityIntent(mContext, userid));
            }
        });
    }

}
