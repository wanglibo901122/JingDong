package com.bawei.jingdongdemo1.Find;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.jingdongdemo1.R;

/**
 * Created by 王利博 on 2018/4/28.
 */

public class FindFragMent  extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_find, container, false);
        return view;
    }
}
