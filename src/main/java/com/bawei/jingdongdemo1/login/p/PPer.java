package com.bawei.jingdongdemo1.login.p;

import com.bawei.jingdongdemo1.login.m.MMod;
import com.bawei.jingdongdemo1.login.view.RegView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 王利博 on 2018/5/24.
 */

public class PPer implements PPerIm {
    private RegView regView;
    private MMod mMod;

    public PPer(RegView regView) {
        this.regView = regView;
        mMod=new MMod(regView);
    }

    @Override
    public void login() {
        String getname = regView.getname();
        String getpass = regView.getpass();
        Map<String,String> map= new HashMap<>();
        map.put("mobile",getname);
        map.put("password",getpass);

        mMod.login(map);
    }
}
