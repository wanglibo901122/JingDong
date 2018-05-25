package com.bawei.jingdongdemo1.reg.view.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.bawei.jingdongdemo1.R;
import com.bawei.jingdongdemo1.login.beans.UserC;
import com.bawei.jingdongdemo1.login.view.LoginActivity;
import com.bawei.jingdongdemo1.login.view.RegView;
import com.bawei.jingdongdemo1.reg.view.p.PPPer;

public class ZhuActivity extends AppCompatActivity implements View.OnClickListener,LoginView1 {

    private ImageButton mImgbtn;
    /**
     * 请输入账号
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu);
        initView();
    }

    private void initView() {
        mImgbtn = (ImageButton) findViewById(R.id.imgbtn);
        mImgbtn.setOnClickListener(this);
        mName = (EditText) findViewById(R.id.name);
        mPass = (EditText) findViewById(R.id.pass);
        mRegbtn = (Button) findViewById(R.id.regbtn);
        mRegbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.imgbtn:
                //返回按钮跳转登录界面
                Intent intent=new Intent(ZhuActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.regbtn:
                new PPPer(this).login();
                break;
        }
    }

    @Override
    public String getname() {
        return mName.getText().toString();
    }

    @Override
    public String getpass() {
        return mPass.getText().toString();
    }

    @Override
    public void getSuccess(UserC body) {
        //吐司提示
        Toast.makeText(this,body.getMsg(),Toast.LENGTH_SHORT).show();
    }
}
