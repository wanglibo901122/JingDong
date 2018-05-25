package com.bawei.jingdongdemo1;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.bawei.jingdongdemo1.Class_.ui.ClassFragMent;
import com.bawei.jingdongdemo1.Find.FindFragMent;
import com.bawei.jingdongdemo1.GoodCart.view.GoodCartFragMent;
import com.bawei.jingdongdemo1.Home.ui.ui.HomeFragMent;
import com.bawei.jingdongdemo1.Me.MeFragMent;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup mRg;
    private FrameLayout mFlContent;
    //fragment  5个页面
    private HomeFragMent homeFragMent;
    private ClassFragMent classFragMent;
    private FindFragMent findFragMent;
    private GoodCartFragMent goodCartFragMent;
    private MeFragMent meFragMent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //对象
        homeFragMent= new HomeFragMent();
        classFragMent= new ClassFragMent();
        findFragMent=new FindFragMent();
        meFragMent=new MeFragMent();
        goodCartFragMent = new GoodCartFragMent();
        initView();
        //默认显示
        getSupportFragmentManager().beginTransaction().add(R.id.flContent,homeFragMent).commit();

        boolean godcar = getIntent().getBooleanExtra("godcar", false);
        int godcarid = getIntent().getIntExtra("godcarid", 3);
        if(godcar&&godcarid==4){
            getSupportFragmentManager().beginTransaction().replace(R.id.flContent,goodCartFragMent).commit();
        }


    }

    private void initView() {
        mRg = (RadioGroup) findViewById(R.id.rg);
        mFlContent = (FrameLayout) findViewById(R.id.flContent);
        mRg.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            case R.id.rbHomepage:
                //点击首页面切换
                //  Toast.makeText(this,"111",Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.flContent,homeFragMent ).commit();
                break;
            case R.id.rbClass:
                getSupportFragmentManager().beginTransaction().replace(R.id.flContent,classFragMent ).commit();
                break;
            case R.id.rbFind:
                getSupportFragmentManager().beginTransaction().replace(R.id.flContent,findFragMent ).commit();
                break;
            case R.id.rbMine:
                getSupportFragmentManager().beginTransaction().replace(R.id.flContent,meFragMent ).commit();
                break;
            case R.id.rbShopCar:
                getSupportFragmentManager().beginTransaction().replace(R.id.flContent,goodCartFragMent ).commit();
                break;

        }
    }
}
