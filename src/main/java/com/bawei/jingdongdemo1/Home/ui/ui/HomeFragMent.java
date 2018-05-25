package com.bawei.jingdongdemo1.Home.ui.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.jingdongdemo1.Home.ui.Beans.Imgbean;
import com.bawei.jingdongdemo1.Home.ui.Beans.rvClassbeans;
import com.bawei.jingdongdemo1.Home.ui.Untils.GlideImageLoader;
import com.bawei.jingdongdemo1.Home.ui.adapter.MiaoshaAdapter;
import com.bawei.jingdongdemo1.Home.ui.adapter.RvRecommendAdapter;
import com.bawei.jingdongdemo1.Home.ui.adapter.rvClassAdapter;
import com.bawei.jingdongdemo1.Home.ui.p.PerIm;
import com.bawei.jingdongdemo1.R;
import com.sunfusheng.marqueeview.MarqueeView;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王利博 on 2018/4/28.
 */

public class HomeFragMent extends Fragment implements HomePage {
    private View view;
    private Banner mBanner;
    private RecyclerView mRvClass;
    private PerIm perIm = new PerIm(this);
    private MarqueeView mMarqueeView;
    private RecyclerView mRvSecKill;
    private RecyclerView MRvRecommend;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        perIm.login();
        perIm.getclass();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, RecyclerView.HORIZONTAL, false);
        mRvClass.setLayoutManager(gridLayoutManager);
        //设置布局管理器
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(getContext(), 1, RecyclerView.HORIZONTAL, false);
        mRvSecKill.setLayoutManager(gridLayoutManager1);
        //设置布局管理器

        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false);
        MRvRecommend.setLayoutManager(gridLayoutManager2);
        return view;

    }

    private void initView(View view) {
        mBanner = (Banner) view.findViewById(R.id.banner);
        //设置图片轮播
        mBanner.setImageLoader(new GlideImageLoader());


        mRvClass = (RecyclerView) view.findViewById(R.id.rvClass);

        mMarqueeView = (MarqueeView) view.findViewById(R.id.marqueeView);
        getdata();
        mRvSecKill = (RecyclerView) view.findViewById(R.id.rvSecKill);
        MRvRecommend = (RecyclerView) view.findViewById(R.id.rvRecommend);
    }

    private void getdata() {
        List<String> info = new ArrayList<>();
        info.add("Hey, slow it down");
        info.add("What do you want from me");
        info.add("There might have been a time");
        info.add("I would give myself away");
        info.add("Ooh once upon a time");
        info.add("I didn't give a damn");
        info.add("But now here we are");
        info.add("So what do you want from me");
        info.add("What do you want from me");
        info.add("Just don't give up");
        info.add("...");
        mMarqueeView.startWithList(info);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //结束轮播
        mBanner.stopAutoPlay();
    }

    @Override
    public void getSuccess(Imgbean imgbean) {
        final List<Imgbean.DataBean> imgb = imgbean.getData();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < imgb.size(); i++) {
            list.add(imgb.get(i).getIcon());
        }
        //设置图片集合
      //  Log.d("-------", list.size() + "");
        mBanner.setImages(list);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
        //设置监听
        mBanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                String url = imgb.get(position).getUrl();
                if(url!=null){
                    Intent intent = new Intent(getActivity(), WebviewhomeActivity.class);
                    intent.putExtra("url",url);
                    startActivity(intent);
                }
            }
        });
        //秒杀
        List<Imgbean.MiaoshaBean.ListBeanX> miaoshaolist = imgbean.getMiaosha().getList();
        MiaoshaAdapter miaoshaAdapter = new MiaoshaAdapter(miaoshaolist, getContext());
        mRvSecKill.setAdapter(miaoshaAdapter);
        //推荐
        List<Imgbean.TuijianBean.ListBean> tuijianlist = imgbean.getTuijian().getList();
        RvRecommendAdapter rvRecommendAdapter = new RvRecommendAdapter(getContext(), tuijianlist);
        MRvRecommend.setAdapter(rvRecommendAdapter);
    }

    @Override
    public void getrvClass(rvClassbeans rvClassbeans) {
        List<rvClassbeans.DataBean> data = rvClassbeans.getData();
        rvClassAdapter rvClassAdapter = new rvClassAdapter(data, getActivity());
       // Log.d("哈哈", data.size() + "");
        mRvClass.setAdapter(rvClassAdapter);
    }


}
