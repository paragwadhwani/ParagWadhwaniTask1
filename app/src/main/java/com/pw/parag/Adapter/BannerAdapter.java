package com.pw.parag.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pw.parag.Model.Banner;
import com.pw.parag.Model.Products;
import com.pw.parag.R;

import java.util.ArrayList;


public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannertHolder> {

    Context context;
    ArrayList<Banner> al;

    public BannerAdapter(Context context, ArrayList<Banner> al) {
        this.context = context;
        this.al = al;
    }

    @NonNull
    @Override
    public BannertHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BannertHolder(LayoutInflater.from(context).inflate(R.layout.banne_recycler, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull BannertHolder holder, int position) {
        Banner banner = al.get(position);

        Glide.with(context).load(banner.getProductImage()).placeholder(R.drawable.ic_baseline_downloading_24).error(R.drawable.ic_baseline_broken_image_24).into(holder.ivBanner);
    }

    @Override
    public int getItemCount() {
        return al.size();
    }


    class BannertHolder extends RecyclerView.ViewHolder {

        ImageView ivBanner;

        public BannertHolder(View v) {
            super(v);

            ivBanner = v.findViewById(R.id.ivBanner);

        }
    }
}
