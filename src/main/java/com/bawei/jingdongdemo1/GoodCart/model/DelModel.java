package com.bawei.jingdongdemo1.GoodCart.model;

import com.bawei.jingdongdemo1.GoodCart.Beans.MessageBean;
import com.bawei.jingdongdemo1.GoodCart.presenter.DelPresenter;
import com.bawei.jingdongdemo1.GoodCart.untils.RetrofitUtils;

import io.reactivex.Flowable;

/**
 * Created by 王利博 on 2018/5/23.
 */


public class DelModel implements IModel {
    private DelPresenter presenter;

    public DelModel(DelPresenter presenter){
        this.presenter =  presenter;

    }
    @Override
    public void getData(String uid,String pid) {

        Flowable<MessageBean> delFlowable = RetrofitUtils.getInstance().getApiService().deleteData(uid,pid);
        presenter.delData(delFlowable);
    }
}