package com.moredian.entrance.guard.view.fragment;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.moredian.entrance.guard.R;
import com.moredian.entrance.guard.entity.GetListByPage;
import com.moredian.entrance.guard.entity.User;
import com.moredian.entrance.guard.http.Api;
import com.moredian.entrance.guard.utils.Cn2Spell;
import com.moredian.entrance.guard.utils.ToastHelper;
import com.moredian.entrance.guard.view.activity.PersonDetailActivity;
import com.moredian.entrance.guard.view.adapter.PersonManageRvAdapter;
import com.moredian.entrance.guard.view.designview.PersonIndexView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2019/8/20 09:27
 */
public class PersonListFragment extends BaseFragment {

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
    @BindView(R.id.personindexview)
    PersonIndexView personindexview;
    private PersonManageRvAdapter adapter;
    List<GetListByPage.ContentBean.RowsBean> arowsBeans = new ArrayList<>();
    List<User> users = new ArrayList<>();
    boolean isLoading = false;
    private int pageIndex = 1;
    private int position;
    private LinearLayoutManager linearLayoutManager;
    private Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            getData();
        }
    };


    @Override
    public int initView() {
        return R.layout.fragment_person_list;
    }

    @Override
    public void initViewController() {
        api.setOnResponse(new Api.OnResponse<GetListByPage.ContentBean.RowsBean>() {
            @Override
            public void onResponse(List<GetListByPage.ContentBean.RowsBean> rowsBeans) {
                if (arowsBeans.size() > 0) {
                    arowsBeans.clear();
                }
                arowsBeans.addAll(rowsBeans);
                if (arowsBeans.size() > 0 && arowsBeans.size() <= 20) {
                    changeLoading(View.GONE);
                    updateList();
                } else {
                    changeLoading(View.GONE);
                    ToastUtils.showShort("列表为空");
                }
            }

            @Override
            public void onResponseMore(List<GetListByPage.ContentBean.RowsBean> rowsBeans) {
                if (rowsBeans.size() > 0) {
                    arowsBeans.addAll(rowsBeans);
                    adapter.notifyDataSetChanged();
                    isLoading = false;
                    adapter.notifyItemRemoved(adapter.getItemCount());
                } else {
                    ToastUtils.showShort("只有这么多啦！");
                    isLoading = false;
                    adapter.notifyItemRemoved(adapter.getItemCount());
                }
            }

            @Override
            public void onFailed() {
                changeLoading(View.GONE);
            }
        });
        swipeRefresh.setColorSchemeColors(getResources().getColor(R.color.icon));
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
                swipeRefresh.setRefreshing(false);
            }
        });
    }

    /**
     * descirption: 刷新列表
     */
    private void updateList() {
        if (adapter == null) {
            initRecyclerview();
        } else {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void initData() {
    }

    /**
     * descirption: 刷新一次
     */
    private void refresh() {
        api.getListByPage(1, 20, "");
        changeLoading(View.VISIBLE);
        pageIndex = 1;
        if (users.size() > 0) {
            users.clear();
        }
    }

    private void changeLoading(int visible) {
        if (loadingLl != null) {
            loadingLl.setVisibility(visible);
        }
    }

    /**
     * descirption: 下拉加载更多
     */
    private void getData() {
        api.getListByPage(++pageIndex, 20, "");
    }

    /**
     * descirption: 初始化列表数据
     */
    private void initRecyclerview() {
        linearLayoutManager = new LinearLayoutManager(mContext);
        personManageRecyclerview.setLayoutManager(linearLayoutManager);
        personManageRecyclerview.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
        adapter = new PersonManageRvAdapter(mContext, arowsBeans);
        personManageRecyclerview.setAdapter(adapter);
        personManageRecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                if (lastVisibleItemPosition + 1 == adapter.getItemCount()) {
                    if (isLoading) {
                        adapter.notifyItemRemoved(adapter.getItemCount());
                        return;
                    }
                    if (!isLoading) {
                        isLoading = true;
                        handler.postDelayed(runnable, 1000);
                    }
                }
            }
        });

        adapter.setMyItemClickListener(new PersonManageRvAdapter.OnMyItemClickListener() {
            @Override
            public void onItemClick(String userid) {
                startActivity(PersonDetailActivity.getPersonDetailActivityIntent(mContext, userid));
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        refresh();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        pageIndex = 1;
        handler.removeCallbacks(runnable);
        linearLayoutManager = null;
    }
}
