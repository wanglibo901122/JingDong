package com.bawei.jingdongdemo1.login.m;

import com.bawei.jingdongdemo1.Net.Api;
import com.bawei.jingdongdemo1.Net.OkhttpUntils;
import com.bawei.jingdongdemo1.login.beans.UserB;
import com.bawei.jingdongdemo1.login.beans.UserC;
import com.bawei.jingdongdemo1.login.view.RegView;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 王利博 on 2018/5/24.
 */

public class MMod implements MModIm {
    RegView regView;

    public MMod(RegView regView) {
        this.regView = regView;
    }

    @Override
    public void login(Map<String, String> map) {
        OkhttpUntils.getmInstance().getRequestInterface(Api.URL_).getlogin(map).enqueue(new Callback<UserB>() {
            @Override
            public void onResponse(Call<UserB> call, Response<UserB> response) {
                UserB body = response.body();
                regView.getSuccess(body);
            }

            @Override
            public void onFailure(Call<UserB> call, Throwable t) {

            }
        });
    }

}
