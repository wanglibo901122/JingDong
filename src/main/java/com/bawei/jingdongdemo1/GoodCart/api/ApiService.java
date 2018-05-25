package com.bawei.jingdongdemo1.GoodCart.api;

import com.bawei.jingdongdemo1.GoodCart.Beans.DatasBean;
import com.bawei.jingdongdemo1.GoodCart.Beans.MessageBean;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 王利博 on 2018/5/22.
 */

public interface ApiService {

    @GET("product/getCarts")
    Flowable<MessageBean<List<DatasBean>>> getDatas(@Query("uid") String uid);
    @GET("product/deleteCart")
    Flowable<MessageBean> deleteData(@Query("uid") String uid, @Query("pid") String pid);
}