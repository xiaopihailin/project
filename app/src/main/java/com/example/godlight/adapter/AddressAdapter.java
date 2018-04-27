package com.example.godlight.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.godlight.R;
import com.example.godlight.bean.AddressBean;
import com.example.godlight.ui.account.AddressActivity;

import java.util.List;

/**
 * Created by lenovo on 2018/4/27.
 */

public class AddressAdapter extends RecyclerView.Adapter{
    private Context context;
    private List<AddressBean.DataBean> data;
    public AddressAdapter(Context context, List<AddressBean.DataBean> data) {
        this.context=context;
        this.data=data;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.recyclerview_address, null);
        return new WViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        WViewHolder viewHolder = (WViewHolder) holder;
        viewHolder.address_name.setText(data.get(position).getUser_name()+"");
        viewHolder.address_phone.setText(data.get(position).getUser_phone()+"");
        //"take_pro":"北京","take_city":"丰田","take_area":"神州科技园",
        viewHolder.dizhi_texta.setText(data.get(position).getTake_pro()+"市"+data.get(position).getTake_city()+"区"+data.get(position).getTake_area());

        viewHolder.shanchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"删除",Toast.LENGTH_SHORT).show();
                int address_id = data.get(position).getAddress_id();
                ((AddressActivity)context).ShanchuAddress(address_id);

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class WViewHolder extends RecyclerView.ViewHolder {

        private final TextView address_name;
        private final TextView address_phone;
        private final TextView dizhi_texta;
        private final TextView shanchu;

        public WViewHolder(View itemView) {
            super(itemView);
            address_name = itemView.findViewById(R.id.address_name);
            address_phone = itemView.findViewById(R.id.address_phone);
            dizhi_texta = itemView.findViewById(R.id.dizhi_texta);
            shanchu=itemView.findViewById(R.id.shanchu);
        }
    }
}
