package com.bawei.jingdongdemo1.reg.view.p;

import com.bawei.jingdongdemo1.reg.view.m.Mod;
import com.bawei.jingdongdemo1.reg.view.view.LoginView1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 王利博 on 2018/5/24.
 */

public class PPPer implements PPPerIm {
    private LoginView1 loginView1;
    private Mod modl;

    public PPPer(LoginView1 loginView1) {
        this.loginView1 = loginView1;
        modl=new Mod(loginView1);
    }

    @Override
    public void login() {
        Map<String ,String> map=new HashMap<>();
        map.put("mobile",loginView1.getname());
        map.put("password",loginView1.getpass());
        modl.login(map);

    }
}
