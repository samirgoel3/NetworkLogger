package com.samir.networklogger;

import android.app.Application;

import com.samir.nlogger.NLogger;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NLogger.startInit(this)
                .setEnable(true)
                .setEndpoints("some endpoint goes here accordingly")
                .init();
    }
}
