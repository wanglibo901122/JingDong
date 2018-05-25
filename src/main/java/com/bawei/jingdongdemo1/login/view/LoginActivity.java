package com.bawei.jingdongdemo1.login.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.bawei.jingdongdemo1.R;
import com.bawei.jingdongdemo1.login.beans.UserB;
import com.bawei.jingdongdemo1.login.p.PPer;
import com.bawei.jingdongdemo1.reg.view.view.ZhuActivity;

import de.greenrobot.event.EventBus;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener ,RegView {

    private ImageButton mImgbtn;
    /**
     * 请输入将要注册的账号
     */
    private EditText mName;
    /**
     * 请输入密码
     */
    private EditText mPass;
    /**
     * REG
     */
    private Button mRegbtn;
    /**
     * LOGIN
     */
    private Button mLoginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        mImgbtn = (ImageButton) findViewById(R.id.imgbtn);
        mImgbtn.setOnClickListener(this);
        mName = (EditText) findViewById(R.id.name);
        mPass = (EditText) findViewById(R.id.pass);
        mRegbtn = (Button) findViewById(R.id.regbtn);
        mRegbtn.setOnClickListener(this);
        mLoginbtn = (Button) findViewById(R.id.loginbtn);
        mLoginbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.imgbtn:
                Log.e("Test__","点击的是 返回按钮");
                break;
            case R.id.regbtn:
               //跳转注册
                Intent intent = new Intent(LoginActivity.this, ZhuActivity.class);
               startActivity(intent);
                break;
            case R.id.loginbtn:
                //登录按钮
                new PPer(this).login();
                break;
        }
    }
//账号
    @Override
    public String getname() {
        return mName.getText().toString();
    }
//密码
    @Override
    public String getpass() {
        return mPass.getText().toString();
    }

    @Override
    public void getSuccess(UserB body) {
        String msg = body.getMsg();
      //  Log.e("test____",msg);
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
        if (body.getCode().equals("0")){
            //把token值存进去
         /*   SharedPreferences sp=getSharedPreferences("user",MODE_PRIVATE);
            SharedPreferences.Editor edit = sp.edit();
            edit.putString("token",body.getData().getToken());
            edit.commit();*/

        }
    }
}
