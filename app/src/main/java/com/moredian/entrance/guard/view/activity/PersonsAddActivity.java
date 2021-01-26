package com.moredian.entrance.guard.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.widget.LinearLayout;

import com.moredian.entrance.guard.R;
import com.moredian.entrance.guard.view.fragment.PersonAddFragment;

import butterknife.BindView;


public class PersonsAddActivity extends BaseActivity {

    @BindView(R.id.fragment_container)
    LinearLayout fragmentContainer;

    public static Intent getPersonAddActivityIntent(Context context) {
        Intent intent = new Intent(context, PersonsAddActivity.class);
        return intent;
    }

    @Override
    public int layoutView() {
        return R.layout.activity_persons_add;
    }

    @Override
    public void initView() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, new PersonAddFragment())
                .commit();
    }

    @Override
    public void initData() {

    }

}
