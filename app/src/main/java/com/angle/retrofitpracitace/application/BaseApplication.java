package com.angle.retrofitpracitace.application;

import android.app.Application;

import com.angle.retrofitpracitace.utils.BaseRetrofit;

import org.xutils.x;

/**
 * Created by Administrator on 2016/12/5 0005.
 */

public class BaseApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        BaseRetrofit.init();
        x.Ext.init(this);

    }
}
