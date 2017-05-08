package com.example.r.xutilsdemo;

import android.app.Application;

import org.xutils.x;

/**
 * Created by r on 2017/5/8.
 */

public class IApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
       x.Ext.init(this);
    }
}
