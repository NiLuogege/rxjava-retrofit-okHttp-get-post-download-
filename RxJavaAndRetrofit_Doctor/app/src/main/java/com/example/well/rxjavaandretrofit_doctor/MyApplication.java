package com.example.well.rxjavaandretrofit_doctor;

import android.app.Application;
import android.content.Context;

import com.example.well.rxjavaandretrofit_doctor.net.rxretrofit.RxRetrofitApp;


public class MyApplication extends Application{
    public static Context app;

    @Override
    public void onCreate() {
        super.onCreate();
        app=getApplicationContext();
        RxRetrofitApp.init(this);
    }
}
