package com.bawei.jingdongdemo1.GoodCart.untils;

import com.bawei.jingdongdemo1.GoodCart.api.ApiService;
import com.bawei.jingdongdemo1.GoodCart.interceptor.LoggingInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 王利博 on 2018/5/23.
 */

public class RetrofitUtils {
    private static volatile RetrofitUtils instance;
    private ApiService apiService;
    private OkHttpClient client = new OkHttpClient
            .Builder()
            .addInterceptor(new LoggingInterceptor())
            .build();
    private RetrofitUtils(){
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://120.27.23.105/")
                .build();
        apiService = retrofit.create(ApiService.class);
    }
    public static RetrofitUtils getInstance(){
        if (null==instance){
            synchronized (RetrofitUtils.class){
                if (instance==null){
                    instance = new RetrofitUtils();
                }
            }
        }
        return instance;
    }
    public ApiService getApiService(){
        return apiService;
    }
}