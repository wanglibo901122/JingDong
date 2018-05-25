package com.bawei.jingdongdemo1.Home.ui.adapter;

import android.content.Context;

import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.bawei.jingdongdemo1.Home.ui.Beans.Imgbean;
import com.bawei.jingdongdemo1.R;
import com.facebook.drawee.view.SimpleDraweeView;


import java.util.List;
/**
 * Created by 王利博 on 2018/5/15.
 */

public class RvRecommendAdapter extends RecyclerView.Adapter<RvRecommendAdapter.Myviewholder> {
    private Context context;
    private List<Imgbean.TuijianBean.ListBean>   list;

    public RvRecommendAdapter(Context context, List<Imgbean.TuijianBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public Myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rvrecommend_item, parent, false);
        Myviewholder myviewholder = new Myviewholder(view);
        return myviewholder;
    }

    @Override
    public void onBindViewHolder(Myviewholder holder, int position) {
        final Imgbean.TuijianBean.ListBean lb = list.get(position);
        holder.tv.setText(lb.getTitle());
        String images = lb.getImages();

        String[] split = images.split("\\|");
        holder.iv.setImageURI(split[0]);
        //监听
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,lb.getSubhead(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class Myviewholder extends RecyclerView.ViewHolder {
        public TextView tv;
        public SimpleDraweeView iv;
        public Myviewholder(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
            tv=itemView.findViewById(R.id.tv);
        }
    }
}