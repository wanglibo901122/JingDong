package com.bawei.jingdongdemo1.Class_.adaoter;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.jingdongdemo1.Class_.beans.proudshopbean;
import com.bawei.jingdongdemo1.Home.ui.adapter.MiaoshaAdapter;
import com.bawei.jingdongdemo1.Net.OnItemClickListener;
import com.bawei.jingdongdemo1.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by 王利博 on 2018/5/18.
 */

public class Listadapter extends RecyclerView.Adapter<Listadapter.Myviewholder> {
   private   List<proudshopbean.DataBean> data ;
   private   Context context;
   private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public Listadapter(List<proudshopbean.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public Myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item_list, parent, false);
        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(Myviewholder holder, final int position) {
        final proudshopbean.DataBean db = data.get(position);
        //holder.iv.setImageURI(Uri.parse(db.getImages().split("\\|")[0]));
        holder.tvTitle.setText(db.getTitle());

        holder.tvPrice.setText(db.getPrice()+"");
        Picasso.with(context).load(db.getImages().split("\\|")[0]).into(holder.iv);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(position,db.getPid()+"");
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder {
        public ImageView iv;
        public TextView tvTitle;
        public  TextView tvPrice;
        public Myviewholder(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
            tvPrice=itemView.findViewById(R.id.tvPrice);
            tvTitle=itemView.findViewById(R.id.tvTitle);
        }
    }
}
