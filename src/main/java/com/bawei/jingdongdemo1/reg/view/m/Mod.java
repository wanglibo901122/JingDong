package com.bawei.jingdongdemo1.reg.view.m;

import com.bawei.jingdongdemo1.Net.Api;
import com.bawei.jingdongdemo1.Net.OkhttpUntils;
import com.bawei.jingdongdemo1.login.beans.UserC;
import com.bawei.jingdongdemo1.reg.view.view.LoginView1;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 王利博 on 2018/5/24.
 */

public class Mod implements ModIm {
    private LoginView1 loginView1;

    public Mod(LoginView1 loginView1) {
        this.loginView1 = loginView1;
    }

    @Override
    public void login(Map<String, String> map) {
        OkhttpUntils.getmInstance().getRequestInterface(Api.URL_).getreg(map).enqueue(new Callback<UserC>() {
            @Override
            public void onResponse(Call<UserC> call, Response<UserC> response) {
                UserC body = response.body();
                loginView1.getSuccess(body);
            }

            @Override
            public void onFailure(Call<UserC> call, Throwable t) {

            }
        });
    }
}
