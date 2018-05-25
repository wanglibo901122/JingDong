package com.bawei.jingdongdemo1.Class_.adaoter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.bawei.jingdongdemo1.Home.ui.Beans.rvClassbeans;
import com.bawei.jingdongdemo1.Net.OnItemClickListener;
import com.bawei.jingdongdemo1.R;

import java.util.List;



/**
 * Created by 王利博 on 2018/5/15.
 */

public class Myleftadapter extends RecyclerView.Adapter<Myleftadapter.Myviewholder>{
    private List<rvClassbeans.DataBean> data;
            private Context context;
    private  OnItemClickListener onItemClickListener;

    public Myleftadapter(List<rvClassbeans.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public Myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.left_item, parent, false);
        Myviewholder myviewholder = new Myviewholder(inflate);
        return myviewholder;
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;

    }
    @Override
    public void onBindViewHolder(final Myviewholder holder,final int position) {
        final rvClassbeans.DataBean db = data.get(position);
        holder.tv.setText( db.getName() );

       holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(position,db.getCid()+"");

            }
        });
    }
    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder{
        public TextView tv;

        public Myviewholder(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
        }
    }

}
