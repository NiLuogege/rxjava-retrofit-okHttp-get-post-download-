package com.example.well.rxjavaandretrofit_doctor.net.entity.resulte;

import java.util.List;

/**
 * 直接请求返回数据格式
 * Created by WZG on 2016/7/16.
 */
public class RetrofitEntity {
    private int ret;
    private String msg;
    private List<SubjectResulte> data;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<SubjectResulte> getData() {
        return data;
    }

    public void setData(List<SubjectResulte> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RetrofitEntity{" +
                "ret=" + ret +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
