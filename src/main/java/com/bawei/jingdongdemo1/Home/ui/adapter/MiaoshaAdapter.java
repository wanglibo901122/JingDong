package com.bawei.jingdongdemo1.Home.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bawei.jingdongdemo1.Home.ui.Beans.Imgbean;
import com.bawei.jingdongdemo1.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 王利博 on 2018/5/15.
 */

public class MiaoshaAdapter extends RecyclerView.Adapter<MiaoshaAdapter.Myviewholder>{
    List<Imgbean.MiaoshaBean.ListBeanX> list;
    Context context;

    public MiaoshaAdapter(List<Imgbean.MiaoshaBean.ListBeanX> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public Myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rvre_item, parent, false);
        Myviewholder c = new Myviewholder(view);
        return c;
    }

    @Override
    public void onBindViewHolder(Myviewholder holder, int position) {
        final Imgbean.MiaoshaBean.ListBeanX ll = list.get(position);
        String imgurl = ll.getImages().split("\\|")[0];
        holder.iv.setImageURI(imgurl);
        //监听
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,ll.getTitle(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    public interface Onitemclicklistener {
        void click(int position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Myviewholder  extends RecyclerView.ViewHolder{
        public SimpleDraweeView iv;
        public Myviewholder(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
        }
    }
}
