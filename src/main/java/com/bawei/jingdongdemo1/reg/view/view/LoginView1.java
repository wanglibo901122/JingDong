package com.bawei.jingdongdemo1.reg.view.view;

import com.bawei.jingdongdemo1.login.beans.UserC;

/**
 * Created by 王利博 on 2018/5/24.
 */

public interface LoginView1 {
    String getname();
    String getpass();
    void getSuccess(UserC body );
}
