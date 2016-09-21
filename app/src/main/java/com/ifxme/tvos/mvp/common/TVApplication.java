package com.ifxme.tvos.mvp.common;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.ifxme.tvos.mvp.model.User;

/**
 * Created by Slbw on 2016/8/22.
 */
public class TVApplication extends Application {

    /**
     * 当前登录用户对象
     */
    private User user;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
