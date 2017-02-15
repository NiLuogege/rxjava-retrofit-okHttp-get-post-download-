package com.example.well.rxjavaandretrofit_doctor.net.entity.api;

import com.example.well.rxjavaandretrofit_doctor.net.rxretrofit.service.HttpPostService;
import com.example.well.rxjavaandretrofit_doctor.net.rxretrofit.Api.BaseApi;
import com.example.well.rxjavaandretrofit_doctor.net.rxretrofit.listener.HttpOnNextListener;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by Well on 2017/2/15.
 */

public class AppUploadApi extends BaseApi {
    private String cellphone;
    private long beginTime;
    private long endTime;
    private String unit;



    public AppUploadApi(HttpOnNextListener listener, RxAppCompatActivity rxAppCompatActivity) {
        super(listener, rxAppCompatActivity);
setBaseUrl("http://192.168.121.250:8080/");
    }

    @Override
    public Observable getObservable(Retrofit retrofit) {
        HttpPostService httpPostService = retrofit.create(HttpPostService.class);
        return  httpPostService.getTemp(getCellphone(),getBeginTime(),getEndTime(), getUnit());
    }


    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(long beginTime) {
        this.beginTime = beginTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
