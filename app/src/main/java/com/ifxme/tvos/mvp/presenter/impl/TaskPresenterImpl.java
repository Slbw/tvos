package com.ifxme.tvos.mvp.presenter.impl;

import com.ifxme.tvos.mvp.api.APIManager;
import com.ifxme.tvos.mvp.api.ApiService;
import com.ifxme.tvos.mvp.api.response.GetTaskListResponse;
import com.ifxme.tvos.mvp.api.response.GetUserListResponse;
import com.ifxme.tvos.mvp.presenter.TaskPresenter;
import com.ifxme.tvos.mvp.ui.view.AddTaskView;
import com.ifxme.tvos.mvp.ui.view.TaskView;
import com.ifxme.tvos.mvp.util.Constant;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Slbw on 2016/9/18.
 */
public class TaskPresenterImpl extends BasePresenterImpl implements TaskPresenter{

    private TaskView taskView;

    public TaskPresenterImpl(TaskView taskView) {
        this.taskView = taskView;
    }


    @Override
    public void requestUserList() {

    }

    @Override
    public void addTask() {

    }

    @Override
    public void getTaskList() {
        mSubscriptions.add(APIManager.getInstance().getApi(ApiService.class, Constant.host)
                .getTaskList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GetTaskListResponse>() {
                    @Override
                    public void onCompleted() {
                        taskView.hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        taskView.hideProgress();
                    }

                    @Override
                    public void onNext(GetTaskListResponse getTaskListResponse) {
                        taskView.showTaskList(getTaskListResponse.data);
                    }
                }));
    }

    @Override
    public void getTaskListById(int userId) {

    }
}
