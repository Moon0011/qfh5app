package com.qf.h5.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.qf.h5.R;
import com.qf.h5.bean.RecommendBean;
import com.qf.h5.common.GlideApp;

import java.util.List;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

/**
 * Created by Administrator on 2017/11/24.
 */

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.ViewHolder> {
    private Context mContext;
    private List<RecommendBean> mDatas;
    private LayoutInflater inf;

    public interface OnRecyclerViewItemListener {
        public void onItemClickListener(View view, int position);
    }

    private OnRecyclerViewItemListener mOnRecyclerViewItemListener;

    public void setOnRecyclerViewItemListener(OnRecyclerViewItemListener listener) {
        mOnRecyclerViewItemListener = listener;
    }

    public NewAdapter(Context mContext, List<RecommendBean> datas) {
        this.mContext = mContext;
        mDatas = datas;
        inf = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = inf.inflate(R.layout.new_item_layout, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if (holder == null) {
            return;
        }
        holder.tvGameName.setText(mDatas.get(position).getGameName());
        holder.tvCount.setText(mDatas.get(position).getCount() + "");

        GlideApp.with(mContext)
                .load(mDatas.get(position).getBgurl())
                .placeholder(R.mipmap.error_pic)
                .transition(withCrossFade())
                .error(R.mipmap.error_pic)
                .into(holder.imgbg);
        holder.play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "play" + mDatas.get(position).getGameName(), Toast.LENGTH_SHORT).show();
            }
        });

        if (mOnRecyclerViewItemListener != null) {
            itemOnClick(holder);
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvGameName, tvCount;
        ImageView imgbg;
        Button play;

        public ViewHolder(View itemView) {
            super(itemView);
            tvGameName = (TextView) itemView.findViewById(R.id.game_name);
            tvCount = (TextView) itemView.findViewById(R.id.tv_count);
            imgbg = (ImageView) itemView.findViewById(R.id.game_logo);
            play = (Button) itemView.findViewById(R.id.btn_play);
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