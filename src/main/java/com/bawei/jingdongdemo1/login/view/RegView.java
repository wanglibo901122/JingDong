package com.bawei.jingdongdemo1.login.view;

import com.bawei.jingdongdemo1.login.beans.UserB;

/**
 * Created by 王利博 on 2018/5/24.
 */

public interface RegView {
    String getname();
    String getpass();
    void getSuccess(UserB body );
}
