package com.bawei.jingdongdemo1.Home.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.bawei.jingdongdemo1.Home.ui.Beans.rvClassbeans;
import com.bawei.jingdongdemo1.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 王利博 on 2018/5/13.
 */

public class rvClassAdapter extends RecyclerView.Adapter<rvClassAdapter.Myviewholder> {
    List<rvClassbeans.DataBean> list;
    Context context;

    public rvClassAdapter(List<rvClassbeans.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public Myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rvclassitem, parent, false);
        Myviewholder myviewholder = new Myviewholder(view);
        return myviewholder;
    }
    public interface Onitemclicklistener {
        void click(int position);
    }
    @Override
    public void onBindViewHolder(Myviewholder holder, int position) {
        rvClassbeans.DataBean db = list.get(position);
        String icon = db.getIcon();
        final String name = db.getName();

        //监听
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,name,Toast.LENGTH_SHORT).show();
            }
        });
        //图片赋值
        AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                //图片地址
                .setUri(icon)
                //播放gif 图片
                .setAutoPlayAnimations(true)
                //点击重新加载时 可以重新加载4 次
                .setTapToRetryEnabled(true)
                .build();
        holder.iv.setController(controller);
        holder.tv.setText(name  );

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder{
        public SimpleDraweeView iv;
        public TextView tv;
        public Myviewholder(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
            tv=itemView.findViewById(R.id.tv);
        }
    }
}
