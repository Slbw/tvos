package com.ifxme.tvos.mvp.ui.view;

import com.ifxme.tvos.mvp.model.Task;
import com.ifxme.tvos.mvp.model.User;

import java.util.List;

/**
 * Created by Slbw on 2016/9/21.
 */

public interface TaskView extends BaseView{

    void showProgress();
    void hideProgress();
    void showTaskList(List<Task> data);

}
