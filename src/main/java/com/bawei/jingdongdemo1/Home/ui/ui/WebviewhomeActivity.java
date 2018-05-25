package com.bawei.jingdongdemo1.Home.ui.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.bawei.jingdongdemo1.R;

public class WebviewhomeActivity extends AppCompatActivity {

    private WebView mWv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webviewhome);
        initView();
    }

    private void initView() {
        mWv = (WebView) findViewById(R.id.wv);
        String url = getIntent().getStringExtra("url");
        mWv.loadUrl(url);
    }
}
