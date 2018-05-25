package com.bawei.jingdongdemo1.Class_.adaoter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.jingdongdemo1.Class_.beans.rightbean;
import com.bawei.jingdongdemo1.Net.OnItemClickListener;
import com.bawei.jingdongdemo1.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 王利博 on 2018/5/18.
 */

public class MyAdapterZi extends RecyclerView.Adapter<MyAdapterZi.MyViewHodel>{
    private final Context context;
    private final List<rightbean.DataBean.ListBean> list;
    private  OnItemClickListener onItemClickListener;
    public MyAdapterZi(Context context, List<rightbean.DataBean.ListBean> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public MyViewHodel onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rvre_you, parent, false);
        return new MyViewHodel(view);
    }

    @Override
    public void onBindViewHolder(MyViewHodel holder, final int position) {
        String name = list.get(position).getName();
        String icon = list.get(position).getIcon();
        holder.sdv.setImageURI(Uri.parse(icon));
        holder.tv.setText(name);
        holder.sdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(position,list.get(position).getPscid()+"");

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    class MyViewHodel extends RecyclerView.ViewHolder{
        public SimpleDraweeView sdv;
        public TextView tv;
        public MyViewHodel(View itemView) {
            super(itemView);
            this.sdv=itemView.findViewById(R.id.rvre_item_sdv);
            this.tv=itemView.findViewById(R.id.rvre_item_tv);

        }
    }
}
