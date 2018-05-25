package com.bawei.jingdongdemo1.Class_.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bawei.jingdongdemo1.Class_.adaoter.Listadapter;
import com.bawei.jingdongdemo1.Class_.beans.proudshopbean;
import com.bawei.jingdongdemo1.Class_.beans.rightbean;
import com.bawei.jingdongdemo1.Class_.modles.Mood;
import com.bawei.jingdongdemo1.Home.ui.Beans.rvClassbeans;
import com.bawei.jingdongdemo1.Net.OnItemClickListener;
import com.bawei.jingdongdemo1.R;

import java.util.List;

public class ShowlistActivity extends AppCompatActivity implements  DataView {

    private RecyclerView mRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showlist);
        String pscid = getIntent().getStringExtra("pscid");
        initView();
        new Mood(this).getpscid(pscid);

    mRv.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initView() {
        mRv = (RecyclerView) findViewById(R.id.rv);
    }

    @Override
    public void getSuccess(proudshopbean body) {
        List<proudshopbean.DataBean> data = body.getData();
        //shiepi

        Log.e("asdasd",body.getData().size()+"");
        Listadapter listadapter = new Listadapter(data, this);
        mRv.setAdapter(listadapter);
        listadapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position, String pid) {
                //Log.e("tttttttt", pid);
                //跳转
                Intent intent = new Intent(ShowlistActivity.this, XiangActivity.class);
                intent.putExtra("pid",pid);
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(int position) {

            }
        });
    }


}
