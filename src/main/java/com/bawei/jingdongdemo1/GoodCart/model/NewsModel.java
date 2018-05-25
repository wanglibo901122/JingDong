package com.bawei.jingdongdemo1.GoodCart.model;

import com.bawei.jingdongdemo1.GoodCart.Beans.DatasBean;
import com.bawei.jingdongdemo1.GoodCart.Beans.MessageBean;
import com.bawei.jingdongdemo1.GoodCart.presenter.NewsPresenter;
import com.bawei.jingdongdemo1.GoodCart.untils.RetrofitUtils;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by 王利博 on 2018/5/23.
 */

public class NewsModel  implements IModel{
    private NewsPresenter presenter;

    public NewsModel(NewsPresenter presenter){
        this.presenter = (NewsPresenter) presenter;

    }
    @Override
    public void getData(String uid,String pid) {
        Flowable<MessageBean<List<DatasBean>>> flowable = RetrofitUtils.getInstance().getApiService().getDatas(uid);
        presenter.getNews(flowable);

    }
}