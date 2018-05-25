package com.bawei.jingdongdemo1.Class_.modles;

import android.util.Log;

import com.bawei.jingdongdemo1.Class_.beans.proudshopbean;
import com.bawei.jingdongdemo1.Class_.beans.rightbean;
import com.bawei.jingdongdemo1.Class_.ui.DataView;
import com.bawei.jingdongdemo1.Class_.ui.LoginView;
import com.bawei.jingdongdemo1.Home.ui.Beans.rvClassbeans;
import com.bawei.jingdongdemo1.Net.Api;
import com.bawei.jingdongdemo1.Net.OkhttpUntils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 王利博 on 2018/5/15.
 */

public class Mod implements ModIm {
    private LoginView loginView;
    private DataView dataView;
    public Mod(LoginView loginView) {
        this.loginView = loginView;
        this.dataView=dataView;
    }

    @Override
    public void login() {
        OkhttpUntils.getmInstance().getRequestInterface(Api.URL_).getrvleft().enqueue(new Callback<rvClassbeans>() {
            @Override
            public void onResponse(Call<rvClassbeans> call, Response<rvClassbeans> response) {
                rvClassbeans body = response.body();
                loginView.getdata(body);
            }

            @Override
            public void onFailure(Call<rvClassbeans> call, Throwable t) {

            }
        });
    }

    @Override
    public void getcid(String string) {
        Log.d("aaaaa", "getcid: "+string);
        OkhttpUntils.getmInstance().getRequestInterface(Api.URL_).getDame(string).enqueue(new Callback<rightbean>() {
            @Override
            public void onResponse(Call<rightbean> call, Response<rightbean> response) {
                rightbean body = response.body();


                loginView.getSuccess(body);
            }

            @Override
            public void onFailure(Call<rightbean> call, Throwable t) {
             Log.d("aaaaaaaaa",t.getMessage());
            }
        });
    }


}
