package com.bawei.jingdongdemo1.Class_.adaoter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.bawei.jingdongdemo1.Class_.beans.rightbean;
import com.bawei.jingdongdemo1.Class_.ui.ShowlistActivity;
import com.bawei.jingdongdemo1.Net.OnItemClickListener;
import com.bawei.jingdongdemo1.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王利博 on 2018/5/18.
 */

public class Myadapter extends BaseExpandableListAdapter {
    private final List<rightbean.DataBean> list;
    private  Context context;

    public Myadapter(Context context,List<rightbean.DataBean> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override
    public Object getGroup(int i) {
        return list.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return list.get(i).getList().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        FuViewHodel fuViewHodel;
        if (view==null){
             fuViewHodel=new FuViewHodel();
            view=LayoutInflater.from(context).inflate(R.layout.right_itme,null);

            //找到控件
            fuViewHodel.text=view.findViewById(R.id.right_tv);

            view.setTag(fuViewHodel);
        }else {

            fuViewHodel= (FuViewHodel) view.getTag();
        }

        String name = list.get(i).getName();
        fuViewHodel.text.setText(name);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ZiViewHodel ziViewHodel;
        if (view==null){
             ziViewHodel=new ZiViewHodel();
            view=LayoutInflater.from(context).inflate(R.layout.right_zi_rlv,null);

            //找到控件
            ziViewHodel.rlv=view.findViewById(R.id.right_zi_rlv);

            view.setTag(ziViewHodel);
        }else {
            ziViewHodel = (ZiViewHodel) view.getTag();
        }

        ziViewHodel.rlv.setLayoutManager(new GridLayoutManager(context, 3));
        List<rightbean.DataBean.ListBean> listBeans = this.list.get(i).getList();
        MyAdapterZi myAdapterZi=new MyAdapterZi(context,listBeans);

        ziViewHodel.rlv.setAdapter(myAdapterZi);
        myAdapterZi.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position, String pid) {
              //  Log.e("wwww",pid);
                //传过来pscid  进行操作
                Intent intent = new Intent(context, ShowlistActivity.class);
                intent.putExtra("pscid",pid);
                context.startActivity(intent);

            }

            @Override
            public void onLongItemClick(int position) {

            }
        });
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    class FuViewHodel {
        public TextView text;
    }
    class ZiViewHodel{
        public RecyclerView rlv;
    }
}
