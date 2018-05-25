package com.bawei.jingdongdemo1.Class_.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.jingdongdemo1.Class_.beans.Addsuccess;
import com.bawei.jingdongdemo1.Class_.beans.Xiangbean;
import com.bawei.jingdongdemo1.Class_.modles.Xiang;
import com.bawei.jingdongdemo1.Home.ui.Untils.GlideImageLoader;
import com.bawei.jingdongdemo1.MainActivity;
import com.bawei.jingdongdemo1.R;
import com.bawei.jingdongdemo1.login.view.LoginActivity;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMWeb;
import com.youth.banner.Banner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;


public class XiangActivity extends AppCompatActivity implements XiangView, View.OnClickListener {

    private Banner mBanner;
    private TextView mTvTitle;
    private TextView mTvPrice;
    private TextView mTvVipPrice;
    /**
     * 购物车
     */
    private TextView mTvShopCard;
    /**
     * 加入购物车
     */
    private TextView mTvAddCard;
    private List<String> imglist;
    private ImageView mIvShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang);
        initView();
        //获取pid
        String pid = getIntent().getStringExtra("pid");
        //请求数据
        new Xiang(this).getdata(pid);

    }

    private void initView() {
        mBanner = (Banner) findViewById(R.id.banner);
        mTvTitle = (TextView) findViewById(R.id.tvTitle);
        mTvPrice = (TextView) findViewById(R.id.tvPrice);
        mTvVipPrice = (TextView) findViewById(R.id.tvVipPrice);
        mTvShopCard = (TextView) findViewById(R.id.tvShopCard);
        mTvAddCard = (TextView) findViewById(R.id.tvAddCard);
        mIvShare = (ImageView) findViewById(R.id.ivShare);
        mTvAddCard.setOnClickListener(this);
        mTvShopCard.setOnClickListener(this);
        mIvShare.setOnClickListener(this);
    }

    @Override
    public void getsuccess(Xiangbean data) {
        double price = data.getData().getPrice();
        String title = data.getData().getTitle();
        double bargainPrice = data.getData().getBargainPrice();
        String[] split = data.getData().getImages().split("\\|");
        imglist = Arrays.asList(split);
        mBanner.setImageLoader(new GlideImageLoader());
        mBanner.setImages(imglist);
        mBanner.start();

        mTvPrice.setText(bargainPrice + "");
        //删除线
        mTvPrice.setPaintFlags(mTvPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        mTvTitle.setText(title);
        mTvVipPrice.setText(price + "");
    }

    @Override
    public void addsucess(Addsuccess body) {
        //提示信息
        Toast.makeText(XiangActivity.this,body.getMsg(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();
        //结束轮播
        mBanner.stopAutoPlay();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvAddCard:
                Log.e("tttt", "添加购物车");
                  //获取信息添加到购物车
                Map<String,String> map=new HashMap<>();
                map.put("uid","72");
                map.put("pid",getIntent().getStringExtra("pid"));
                new Xiang(this).addcar(map);

              //  addcar();
                break;
            case R.id.tvShopCard:
                Log.e("tttt", "展示购物车");
               gtogood();
                break;
            case R.id.ivShare:
                Log.e("tttt","分享模块");
                UMWeb umWeb = new UMWeb("http://home.firefoxchina.cn/?from=worldindex");
                new ShareAction(XiangActivity.this).withMedia(umWeb)
                        .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                        .setCallback(shareListener).open();
                break;
        }
    }
//添加购物车
    private void addcar() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ERROR：");
        builder.setMessage("当前没有进行登录-是否进行登录操作？");
        builder.setIcon(R.mipmap.ic_launcher_round);
        //点击对话框以外的区域是否让对话框消失
        builder.setCancelable(true);
        //设置正面按钮
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               //Toast.makeText(context, "你点击了是的", Toast.LENGTH_SHORT).show();
               dialog.dismiss();
                Intent intent=new Intent(XiangActivity.this, LoginActivity.class);
                    startActivity(intent);
            }
        });
        //设置反面按钮
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               // Toast.makeText(context, "你点击了不是", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
     /*   //设置中立按钮
        builder.setNeutralButton("保密", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "你选择了保密", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });*/
        AlertDialog dialog = builder.create();
        //对话框显示的监听事件
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                Log.e("ASAS","对话框显示了");
            }
        });
        //对话框消失的监听事件
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                Log.e("ASAS","对话框消失了");
            }
        });
        //显示对话框
        dialog.show();

    }

    private void gtogood() {
        Intent intent = new Intent(XiangActivity.this, MainActivity.class);
        intent.putExtra("godcarid",4);
        intent.putExtra("godcar",true);
        startActivity(intent);
    }

    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {
        }
        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(XiangActivity.this,"成功了",Toast.LENGTH_LONG).show();
        }
        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(XiangActivity.this,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }
        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(XiangActivity.this,"取消了",Toast.LENGTH_LONG).show();
        }
    };
}
