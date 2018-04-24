package com.example.godlight.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.godlight.R;


/**
 * Created by Lzh on 2018/4/20.
 */
public abstract class BaseFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=loadView(inflater); //加载布局
        initView(view);//加载样式
        initData(savedInstanceState);//加载数据
        setAllEvent();//初始化所有事件
        process();//业务逻加处理
        return view;
    }

    protected abstract View loadView(LayoutInflater inflater);
    protected abstract void initView(View view);
    protected abstract void initData(Bundle savedInstanceState);
    protected abstract void setAllEvent();
    protected abstract void process();
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        Activity act=getActivity();
        while (act.getParent()!=null) {
            act=act.getParent();
        }
        act.overridePendingTransition(R.anim.right_in, R.anim.default_anim);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        Activity act=getActivity();
        while (act.getParent()!=null) {
            act=act.getParent();
        }
        act.overridePendingTransition(R.anim.right_in,R.anim.default_anim);
    }

}
