package com.ifxme.tvos.mvp.ui.activity.contact;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ifxme.tvos.R;
import com.ifxme.tvos.mvp.model.User;
import com.ifxme.tvos.mvp.presenter.UserPresenter;
import com.ifxme.tvos.mvp.presenter.impl.UserPresenterImpl;
import com.ifxme.tvos.mvp.ui.activity.BaseActivity;
import com.ifxme.tvos.mvp.ui.adapter.UserListAdapter;
import com.ifxme.tvos.mvp.ui.view.UserView;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends BaseActivity implements UserView {

    private RecyclerView rvPeople;
    private UserPresenter mUserPresenter;
    private List<User> users;
    private UserListAdapter adapter;
    private FloatingActionButton fabAddContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    }

    @Override
    protected void initView() {
        super.initView();
        rvPeople = (RecyclerView) findViewById(R.id.rvPeople);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvPeople.setLayoutManager(mLayoutManager);
        rvPeople.setItemAnimator(new DefaultItemAnimator());
        fabAddContact=(FloatingActionButton)findViewById(R.id.fabAddContact);
    }

    @Override
    protected void initData() {
        super.initData();
        users = new ArrayList<User>();
        mUserPresenter = new UserPresenterImpl(this);
        mUserPresenter.getUserList();
        adapter = new UserListAdapter(this, users);
        rvPeople.setAdapter(adapter);
    }

    @Override
    protected void initListener() {
        super.initListener();

        fabAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 添加人员
            }
        });
    }


    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }


    @Override
    public void showUserList(List<User> data) {
        users.clear();
        users.addAll(data);
        adapter.notifyDataSetChanged();
    }
}
