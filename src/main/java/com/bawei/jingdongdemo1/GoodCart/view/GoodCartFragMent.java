package com.bawei.jingdongdemo1.GoodCart.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.jingdongdemo1.Class_.ui.XiangActivity;
import com.bawei.jingdongdemo1.GoodCart.Beans.DatasBean;
import com.bawei.jingdongdemo1.GoodCart.Beans.MessageBean;
import com.bawei.jingdongdemo1.GoodCart.Beans.SomeId;
import com.bawei.jingdongdemo1.GoodCart.adapter.MyAdapter;
import com.bawei.jingdongdemo1.GoodCart.event.MessageEvent;
import com.bawei.jingdongdemo1.GoodCart.event.PriceAndCountEvent;
import com.bawei.jingdongdemo1.GoodCart.presenter.DelPresenter;
import com.bawei.jingdongdemo1.GoodCart.presenter.NewsPresenter;
import com.bawei.jingdongdemo1.R;
import com.bawei.jingdongdemo1.login.view.LoginActivity;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

/**
 * Created by 王利博 on 2018/4/28.
 */

public class GoodCartFragMent extends Fragment implements Iview {

    private String uid = "72";
    private NewsPresenter presenter;
    private CheckBox mCheckbox2;
    private ExpandableListView mElv;

    /**
     * 0
     */
    private TextView mTvPrice;
    /**
     * 结算(0)
     */
    private TextView mTvNum;
    private MyAdapter adapter;
    private List<DatasBean> groupList = new ArrayList<>();
    private List<List<DatasBean.ListBean>> childList = new ArrayList<>();
    private String pid;
    private DelPresenter delPresenter;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_goodcart, container, false);
        EventBus.getDefault().register(this);


        presenter = new NewsPresenter();
        presenter.attachView(this);
        delPresenter = new DelPresenter();
        delPresenter.attachView(this);
        initView();
        adapter = new MyAdapter(getActivity(), groupList, childList);
        mElv.setAdapter(adapter);


        mCheckbox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.changeAllListCbState(mCheckbox2.isChecked());
            }
        });


        return view;
    }

    private void initView() {

        mElv = (ExpandableListView) view.findViewById(R.id.elv1);
        mCheckbox2 = (CheckBox) view.findViewById(R.id.checkbox21);
        mTvPrice = (TextView) view.findViewById(R.id.tv_price);
        mTvNum = (TextView) view.findViewById(R.id.tv_num);
    }

    @Override
    public void onSuccess(Object o) {

        if (o != null) {
            List<DatasBean> list = (List<DatasBean>) o;
            if (list != null) {
                groupList.addAll(list);
                for (int i = 0; i < list.size(); i++) {
                    List<DatasBean.ListBean> datas = list.get(i).getList();
                    childList.add(datas);
                }

                adapter.notifyDataSetChanged();
                mCheckbox2.setChecked(true);

                adapter.changeAllListCbState(true);
                mElv.setGroupIndicator(null);
                for (int i = 0; i < groupList.size(); i++) {
                    mElv.expandGroup(i);
                }

            }
        }
    }

    @Override
    public void onFailed(Exception e) {

    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.getData(uid, pid);
    }

    @Override
    public void delSuccess(MessageBean listMessageBean) {
        Toast.makeText(getContext(), listMessageBean.getMsg(), Toast.LENGTH_SHORT).show();
    }

    @Subscribe
    public void onMessageEvent(MessageEvent event) {
        mCheckbox2.setChecked(event.isChecked());
    }

    @Subscribe
    public void onMessageEvent(PriceAndCountEvent event) {
        mTvNum.setText("结算(" + event.getCount() + ")");
        mTvPrice.setText("￥" + event.getPrice());
        //按钮监听
        mTvNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(getContext(),"点击结算",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), SlActivity.class);
                startActivity(intent);
            }
        });
    }

    @Subscribe
    public void onMessageEvent(SomeId event) {
        pid = event.getPid();
        Log.e("zxz", "我得到了pid:" + pid);
        delPresenter.getData(uid, pid);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        if (presenter != null) {
            presenter.detachView();
        }
    }

}
