package com.bawei.jingdongdemo1.GoodCart.view;

import com.bawei.jingdongdemo1.GoodCart.Beans.MessageBean;

/**
 * Created by 王利博 on 2018/5/23.
 */

public interface Iview {

    void onSuccess(Object o);
    void onFailed(Exception e);
    void delSuccess(MessageBean listMessageBean);
}
