package com.bawei.jingdongdemo1.Net;

import com.bawei.jingdongdemo1.Class_.beans.Addsuccess;
import com.bawei.jingdongdemo1.Class_.beans.Xiangbean;
import com.bawei.jingdongdemo1.Class_.beans.proudshopbean;
import com.bawei.jingdongdemo1.Class_.beans.rightbean;
import com.bawei.jingdongdemo1.Home.ui.Beans.Imgbean;
import com.bawei.jingdongdemo1.Home.ui.Beans.rvClassbeans;
import com.bawei.jingdongdemo1.login.beans.UserB;
import com.bawei.jingdongdemo1.login.beans.UserC;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


/**
 * Created by 王利博 on 2018/5/10.
 */

public interface GetRequest {
    @GET("ad/getAd")
    Call<Imgbean> getDame();

    @GET("product/getCatagory")
    Call<rvClassbeans> getrvClass();

   //https://www.zhaoapi.cn/product/getCatagory
    @GET("product/getCatagory")
    Call<rvClassbeans> getrvleft();

    @GET("product/getProductCatagory")
    Call<rightbean> getDame(@Query("cid") String cid);

    //https://www.zhaoapi.cn/product/getProducts?pscid=1
    @GET("product/getProducts")
    Call<proudshopbean> getShop(@Query("pscid") String pscid);
        //https://www.zhaoapi.cn/product/getProductDetail?pid=1&source=android
        @GET("product/getProductDetail")
        Call<Xiangbean> getxiang(@Query("pid") String pid);

        //https://www.zhaoapi.cn/product/addCart 添加到购物车
        @POST("product/addCart")
        @FormUrlEncoded
        // @GET("user/login")
        Call<Addsuccess> addcar(@FieldMap Map<String,String> map);

    //https://www.zhaoapi.cn/user/login
    @POST("user/login")
    @FormUrlEncoded
   // @GET("user/login")
    Call<UserB> getlogin(@FieldMap Map<String,String> map);
    @POST("/user/reg")
    @FormUrlEncoded
        // @GET("user/login")
    Call<UserC> getreg(@FieldMap Map<String,String> map);
}
