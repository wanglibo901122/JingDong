package com.bawei.jingdongdemo1.Home.ui.p;

import android.util.Log;

import com.bawei.jingdongdemo1.Home.ui.Beans.Imgbean;
import com.bawei.jingdongdemo1.Home.ui.Beans.rvClassbeans;
import com.bawei.jingdongdemo1.Home.ui.ui.HomePage;
import com.bawei.jingdongdemo1.Net.Api;
import com.bawei.jingdongdemo1.Net.OkhttpUntils;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 王利博 on 2018/5/10.
 */

public class PerIm  implements Per{
  private HomePage homePage;

    public PerIm(HomePage homePage) {
        this.homePage = homePage;

    }
    @Override
    public void login( ) {
            OkhttpUntils.getmInstance().getRequestInterface(Api.URL_).getDame().enqueue(new Callback<Imgbean>() {
                @Override
                public void onResponse(Call<Imgbean> call, Response<Imgbean> response) {
                    Imgbean body = response.body();
                    homePage.getSuccess(body);
                }

                @Override
                public void onFailure(Call<Imgbean> call, Throwable t) {
                    Log.d("-------","onFailure:"+t.getMessage());
                }
            });
    }

    @Override
    public void getclass() {
        OkhttpUntils.getmInstance().getRequestInterface(Api.URL_).getrvClass().enqueue(new Callback<rvClassbeans>() {
            @Override
            public void onResponse(Call<rvClassbeans> call, Response<rvClassbeans> response) {
                rvClassbeans body = response.body();
                homePage.getrvClass(body);

            }

            @Override
            public void onFailure(Call<rvClassbeans> call, Throwable t) {

            }
        });
    }
}
