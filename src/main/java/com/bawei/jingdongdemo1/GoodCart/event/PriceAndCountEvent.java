package com.bawei.jingdongdemo1.GoodCart.event;

/**
 * Created by 王利博 on 2018/5/23.
 */

public class PriceAndCountEvent {
    private int price;
    private int count;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}