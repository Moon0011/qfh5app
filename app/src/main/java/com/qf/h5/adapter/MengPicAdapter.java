package com.qf.h5.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.h5.R;
import com.qf.h5.bean.RecommendBean;
import com.qf.h5.common.GlideApp;

import java.util.List;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

/**
 * Created by Administrator on 2017/11/24.
 */

public class MengPicAdapter extends RecyclerView.Adapter<MengPicAdapter.ViewHolder> {
    private Context mContext;
    private List<RecommendBean> mDatas;
    private LayoutInflater inf;

    public interface OnRecyclerViewItemListener {
        void onItemClickListener(View view, int position);
    }

    private OnRecyclerViewItemListener mOnRecyclerViewItemListener;

    public void setOnRecyclerViewItemListener(OnRecyclerViewItemListener listener) {
        mOnRecyclerViewItemListener = listener;
    }

    public MengPicAdapter(Context mContext, List<RecommendBean> datas) {
        this.mContext = mContext;
        mDatas = datas;
        inf = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = inf.inflate(R.layout.meng_pic_item_layout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if (holder == null) {
            return;
        }
        GlideApp.with(mContext)
                .load(mDatas.get(position).getBgurl())
                .placeholder(R.mipmap.error_pic)
                .transition(withCrossFade())
                .error(R.mipmap.error_pic)
                .into(holder.imgbg);
        if (mOnRecyclerViewItemListener != null) {
            itemOnClick(holder);
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvGameName, tvType;
        ImageView imgbg;

        public ViewHolder(View itemView) {
            super(itemView);
            tvGameName = (TextView) itemView.findViewById(R.id.tv_title);
            tvType = (TextView) itemView.findViewById(R.id.tv_sec_title);
            imgbg = (ImageView) itemView.findViewById(R.id.game_logo);
        }
    }

    private void itemOnClick(final RecyclerView.ViewHolder holder) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int position = holder.getLayoutPosition();
//                mOnRecyclerViewItemListener.onItemClickListener(holder.itemView, position);
            }
        });
    }

    public void clearData() {
        mDatas.clear();
    }

    public void addAllData(List<RecommendBean> dataList) {
        mDatas.addAll(dataList);
        notifyDataSetChanged();
    }
}