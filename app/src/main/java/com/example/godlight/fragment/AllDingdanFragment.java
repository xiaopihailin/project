package com.example.godlight.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.godlight.R;
import com.example.godlight.adapter.DingdanAdapter;
import com.example.godlight.bean.AddressBean;
import com.example.godlight.bean.DingdanBean;
import com.example.godlight.net.ApiMethod;
import com.example.godlight.net.MyObserver;
import com.example.godlight.net.ObserverOnNextListener;

import java.util.HashMap;

/**
 * Created by lenovo on 2018/4/28.
 */

public class AllDingdanFragment extends Fragment {

    private View view;
    private RecyclerView recyclerview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dingdan_fragment, null);
        recyclerview = view.findViewById(R.id.recyclerview);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ObserverOnNextListener<DingdanBean> listener = new ObserverOnNextListener<DingdanBean>() {
            @Override
            public void onNext(DingdanBean bean) {
                //Toast.makeText()
                Log.i("quanbudingdan",bean.getMsg());
            }
        };



        HashMap<String, String> map = new HashMap<>();
        map.put("service_id","1");
        ApiMethod.ChaAllDingdan(new MyObserver<DingdanBean>(getActivity(),listener),map);




    }
}
