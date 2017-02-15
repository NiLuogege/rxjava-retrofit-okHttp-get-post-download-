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

public class GetServiceInfoApi extends BaseApi {
    private String projectName;
    private String lang;



    public GetServiceInfoApi(HttpOnNextListener listener, RxAppCompatActivity rxAppCompatActivity) {
        super(listener, rxAppCompatActivity);
        setShowProgress(true);
        setCancel(true);
        setCache(true);
        setMothed("AppFiftyToneGraph/videoLink");
        setCookieNetWorkTime(60);
        setCookieNoNetWorkTime(24*60*60);
    }



    @Override
    public Observable getObservable(Retrofit retrofit) {
        HttpPostService httpPostService = retrofit.create(HttpPostService.class);
        return httpPostService.getServeiceInfo(getProjectName(),getLang());
    }


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
