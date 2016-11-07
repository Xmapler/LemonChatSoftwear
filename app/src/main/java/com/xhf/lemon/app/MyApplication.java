package com.xhf.lemon.app;

import android.app.Application;

import io.rong.imkit.RongIM;

/**
 * Created by asus on 2016/11/7.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * 初始化融云
         */
        RongIM.init(this);
    }
}
