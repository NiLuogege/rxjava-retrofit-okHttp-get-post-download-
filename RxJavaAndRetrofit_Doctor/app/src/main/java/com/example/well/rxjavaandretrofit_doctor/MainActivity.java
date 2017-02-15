package com.example.well.rxjavaandretrofit_doctor;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.well.rxjavaandretrofit_doctor.net.entity.api.AppUploadApi;
import com.example.well.rxjavaandretrofit_doctor.net.entity.api.GetServiceInfoApi;
import com.example.well.rxjavaandretrofit_doctor.net.entity.api.SubjectPostApi;
import com.example.well.rxjavaandretrofit_doctor.net.entity.resulte.ServiceInfoResulte;
import com.example.well.rxjavaandretrofit_doctor.net.entity.resulte.SubjectResulte;
import com.example.well.rxjavaandretrofit_doctor.net.entity.resulte.Temp;
import com.example.well.rxjavaandretrofit_doctor.net.rxretrofit.Api.BaseResultEntity;
import com.example.well.rxjavaandretrofit_doctor.net.rxretrofit.http.HttpManager;
import com.example.well.rxjavaandretrofit_doctor.net.rxretrofit.listener.HttpOnNextListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.util.List;

public class MainActivity extends RxAppCompatActivity {

    private TextView tvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMsg = (TextView) findViewById(R.id.textView);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getServerInfo();
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTemp();
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              if (BuildConfig.DEBUG) Log.e("MainActivity", HttpManager.getInstance().toString());
            }
        });
    }

    private void getTemp(){
        AppUploadApi appUploadApi = new AppUploadApi(mListener,this);
        appUploadApi.setCellphone("18729440250");
        appUploadApi.setBeginTime(1470499200000L);
        appUploadApi.setEndTime(1471881600000L);
        appUploadApi.setUnit("day");
        HttpManager.getInstance().doHttpDeal(appUploadApi);
    }

    HttpOnNextListener mListener = new HttpOnNextListener<List<Temp>>() {
        @Override
        public void onNext(List<Temp> temps) {
            tvMsg.setText("laile：\n" + temps.toString());
    }

        @Override
        public void onCacheNext(String cache) {
            super.onCacheNext(cache);
            Gson gson=new Gson();
            java.lang.reflect.Type type = new TypeToken<BaseResultEntity<List<Temp>>>() {}.getType();
            BaseResultEntity resultEntity= gson.fromJson(cache, type);
            tvMsg.setText("缓存返回：\n"+resultEntity.getResult().toString() );
        }
    };

    private void getServerInfo(){
        GetServiceInfoApi api = new GetServiceInfoApi(mNextListener,this);
        api.setLang("zh-cn");
        api.setProjectName("wen_er_bo_shi");
        HttpManager.getInstance().doHttpDeal(api);
    }

    HttpOnNextListener mNextListener = new HttpOnNextListener<ServiceInfoResulte>() {

        @Override
        public void onNext(ServiceInfoResulte serviceInfoResultes) {
            tvMsg.setText("laile：\n" + serviceInfoResultes.toString());
        }
    };




    //    完美封装简化版
    private void simpleDo() {
        SubjectPostApi postEntity = new SubjectPostApi(simpleOnNextListener,this);//对框架进行初始化
        postEntity.setAll(true); //设置接口所需的参数
        HttpManager manager = HttpManager.getInstance();
        manager.doHttpDeal(postEntity);
    }

    //   回调一一对应
    HttpOnNextListener simpleOnNextListener = new HttpOnNextListener<List<SubjectResulte>>() {
        @Override
        public void onNext(List<SubjectResulte> subjects) {
            tvMsg.setText("网络返回：\n" + subjects.toString());
        }

        @Override
        public void onCacheNext(String cache) {
//            /*缓存回调*/
//            Gson gson=new Gson();
//            java.lang.reflect.Type type = new TypeToken<BaseResultEntity<List<SubjectResulte>>>() {}.getType();
//            BaseResultEntity resultEntity= gson.fromJson(cache, type);
//            tvMsg.setText("缓存返回：\n"+resultEntity.getResult().toString() );
        }

        /*用户主动调用，默认是不需要覆写该方法*/
        @Override
        public void onError(Throwable e) {
            super.onError(e);
            tvMsg.setText("失败：\n" + e.toString());
        }

        /*用户主动调用，默认是不需要覆写该方法*/
        @Override
        public void onCancel() {
            super.onCancel();
            tvMsg.setText("取消請求");
        }
    };

}
