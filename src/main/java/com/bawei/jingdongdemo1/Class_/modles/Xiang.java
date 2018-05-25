package com.bawei.jingdongdemo1.Class_.modles;

import android.util.Log;

import com.bawei.jingdongdemo1.Class_.beans.Addsuccess;
import com.bawei.jingdongdemo1.Class_.beans.Xiangbean;
import com.bawei.jingdongdemo1.Class_.ui.XiangView;
import com.bawei.jingdongdemo1.Net.Api;
import com.bawei.jingdongdemo1.Net.OkhttpUntils;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 王利博 on 2018/5/18.
 */

public class Xiang implements XiangIm {
    private XiangView xiangView;

    public Xiang(XiangView xiangView) {
        this.xiangView = xiangView;
    }

    @Override
    public void getdata(String string) {
        OkhttpUntils.getmInstance().getRequestInterface(Api.URL_).getxiang(string).enqueue(new Callback<Xiangbean>() {
            @Override
            public void onResponse(Call<Xiangbean> call, Response<Xiangbean> response) {
             //   Log.e("eaeee",response.body().getCode()+response.body().getData().getImages());
                xiangView.getsuccess( response.body() );
            }

            @Override
            public void onFailure(Call<Xiangbean> call, Throwable t) {

            }
        });
    }

    @Override
    public void addcar(Map<String, String> map) {
        OkhttpUntils.getmInstance().getRequestInterface(Api.URL_).addcar(map).enqueue(new Callback<Addsuccess>() {
            @Override
            public void onResponse(Call<Addsuccess> call, Response<Addsuccess> response) {
                Addsuccess body = response.body();
                xiangView.addsucess(body);
            }

            @Override
            public void onFailure(Call<Addsuccess> call, Throwable t) {

            }
        });
    }
}
