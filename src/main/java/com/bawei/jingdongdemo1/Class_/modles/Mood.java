package com.bawei.jingdongdemo1.Class_.modles;

import com.bawei.jingdongdemo1.Class_.beans.proudshopbean;
import com.bawei.jingdongdemo1.Class_.modles.ModImm;
import com.bawei.jingdongdemo1.Class_.ui.DataView;
import com.bawei.jingdongdemo1.Net.Api;
import com.bawei.jingdongdemo1.Net.OkhttpUntils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 王利博 on 2018/5/18.
 */

public class Mood implements ModImm {
    private DataView dataView;

    public Mood(DataView dataView) {
        this.dataView = dataView;
    }

    @Override
    public void getpscid(String string) {
        OkhttpUntils.getmInstance().getRequestInterface(Api.URL_).getShop(string).enqueue(new Callback<proudshopbean>() {
            @Override
            public void onResponse(Call<proudshopbean> call, Response<proudshopbean> response) {
                proudshopbean body = response.body();
                //调方法 传值

                 dataView.getSuccess(body);

            }

            @Override
            public void onFailure(Call<proudshopbean> call, Throwable t) {

            }
        });
    }
}
