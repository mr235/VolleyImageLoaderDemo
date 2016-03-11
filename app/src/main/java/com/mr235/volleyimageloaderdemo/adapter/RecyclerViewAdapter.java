package com.mr235.volleyimageloaderdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.mr235.volleyimageloaderdemo.R;
import com.mr235.volleyimageloaderdemo.utils.VolleyUtil;

import java.util.Random;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private String[] mDataset;
    private ImageLoader mImageLoader;
    private Random mRandom = new Random();

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        NetworkImageView mNetworkImageView;
        public ViewHolder(View v) {
            super(v);
            mNetworkImageView = (NetworkImageView) v.findViewById(R.id.niv);
        }
    }

    public RecyclerViewAdapter(String[] myDataset, Context context) {
        mDataset = myDataset;
        mImageLoader = VolleyUtil.getInstance(context).getImageLoader();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                               .inflate(R.layout.item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mNetworkImageView.setImageUrl(mDataset[position], mImageLoader);
        holder.mNetworkImageView.setErrorImageResId(R.drawable.ic_pic_error);
        holder.mNetworkImageView.setDefaultImageResId(R.drawable.ic_pic_default);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}