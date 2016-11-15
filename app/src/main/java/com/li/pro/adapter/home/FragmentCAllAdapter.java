package com.li.pro.adapter.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.li.pro.bean.home.BeanHomeResults;

import java.util.ArrayList;
import java.util.List;

import rxop.li.com.rxoperation.R;


/**
 * Created by Administrator on 2016/11/11 0011.
 */

public class FragmentCAllAdapter extends RecyclerView.Adapter<FragmentCAllAdapter.ViewHolder> {
    private List<BeanHomeResults> beanHomeResultses = new ArrayList<>();
    private Context context;
    private static FragmentCAllAdapter fragmentCAllAdapter;

    private FragmentCAllAdapter() {
    }

    public static synchronized FragmentCAllAdapter getInstance() {
        if (null == fragmentCAllAdapter) {
            fragmentCAllAdapter = new FragmentCAllAdapter();
        }
        return fragmentCAllAdapter;
    }

    public FragmentCAllAdapter init(Context context) {
        this.context = context;
        return this;
    }

    public FragmentCAllAdapter addData(BeanHomeResults beanHomeResults) {
        beanHomeResultses.add(beanHomeResults);
        return this;
    }

    public FragmentCAllAdapter clearAllData() {
        beanHomeResultses.clear();
        return this;
    }

    public FragmentCAllAdapter refresh() {
        notifyDataSetChanged();
        return this;
    }

    @Override
    public FragmentCAllAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_fragment_c_all_item, parent, false));
    }

    @Override
    public void onBindViewHolder(FragmentCAllAdapter.ViewHolder holder, int position) {
        if (null != beanHomeResultses.get(position).getImages() && null != beanHomeResultses.get(position) && null != beanHomeResultses && beanHomeResultses.get(position).getImages().size() > 0) {
            DraweeController draweeController = Fresco.newDraweeControllerBuilder().
                    setAutoPlayAnimations(true).
                    setUri(beanHomeResultses.get(position).getImages().get(0)).
                    build();
            holder.sdv_fragment_c_all.setController(draweeController);
        }
        holder.tv_fragment_c_all_title.setText(beanHomeResultses.get(position).getDesc());
        holder.tv_fragment_c_all_authro.setText(beanHomeResultses.get(position).getWho());
        holder.tv_fragment_c_all_date.setText(beanHomeResultses.get(position).getPublishedAt());
    }

    @Override
    public int getItemCount() {
        return beanHomeResultses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public SimpleDraweeView sdv_fragment_c_all;
        public TextView tv_fragment_c_all_title;
        public TextView tv_fragment_c_all_authro;
        public TextView tv_fragment_c_all_date;

        public ViewHolder(View itemView) {
            super(itemView);
            sdv_fragment_c_all = (SimpleDraweeView) itemView.findViewById(R.id.sdv_fragment_c_all);
            tv_fragment_c_all_title = (TextView) itemView.findViewById(R.id.tv_fragment_c_all_title);
            tv_fragment_c_all_authro = (TextView) itemView.findViewById(R.id.tv_fragment_c_all_authro);
            tv_fragment_c_all_date = (TextView) itemView.findViewById(R.id.tv_fragment_c_all_date);
        }
    }
}