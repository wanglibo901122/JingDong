package com.bawei.jingdongdemo1.Class_.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.jingdongdemo1.Class_.adaoter.Myadapter;
import com.bawei.jingdongdemo1.Class_.adaoter.Myleftadapter;
import com.bawei.jingdongdemo1.Class_.beans.rightbean;
import com.bawei.jingdongdemo1.Class_.modles.Mod;
import com.bawei.jingdongdemo1.Home.ui.Beans.rvClassbeans;
import com.bawei.jingdongdemo1.Net.OnItemClickListener;
import com.bawei.jingdongdemo1.R;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;


/**
 * Created by 王利博 on 2018/4/28.
 */

public class ClassFragMent extends Fragment implements LoginView {

     RecyclerView mRvLeft;
     Myleftadapter myadapter;
     List<rvClassbeans.DataBean> data;
     Mod m = new Mod(this);
     List<rightbean.DataBean> listYou=new ArrayList<>();


    private View view;
    private ImageView mIv;
    private ExpandableListView elv;
    private Myadapter myadapter1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_class, container, false);
        initView(view);

        //设置布局管理器
        m.login();
        mRvLeft.setLayoutManager(new LinearLayoutManager(getContext()));
        mRvLeft.addItemDecoration(new DividerItemDecoration(getContext(), RecyclerView.VERTICAL));

        return view;
    }

    private void initView(View view) {
        mRvLeft = (RecyclerView) view.findViewById(R.id.rvLeft);//左边
        elv = (ExpandableListView) view.findViewById(R.id.elv);//右边
        mIv = (ImageView) view.findViewById(R.id.iv);
        //设置图
        mIv.setBackgroundResource(R.drawable.timg);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void getdata(rvClassbeans body) {
        // Log.d("aaa",body.toString());
        data = body.getData();
        myadapter = new Myleftadapter(data, getContext());
        mRvLeft.setAdapter(myadapter);
        m.getcid(data.get(0).getCid() + "");
        myadapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position, String pid) {
                listYou.clear();
                Toast.makeText(getActivity(), pid, Toast.LENGTH_SHORT);
                m.getcid(pid);

            }

            @Override
            public void onLongItemClick(int position) {

            }
        });

        myadapter1 = new Myadapter(getContext(), listYou);

    }


    @Override
    public void getSuccess(rightbean data) {
        List<rightbean.DataBean> data1 = data.getData();
        String code = data.getCode();
        listYou.addAll(data1);
        if (code.endsWith("0")) {
            elv.setAdapter(myadapter1);
            for (int i = 0; i <myadapter1.getGroupCount() ; i++) {
                elv.expandGroup(i);
            }
        }

    }
}
