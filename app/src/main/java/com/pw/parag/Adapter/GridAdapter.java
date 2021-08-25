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
import com.pw.parag.Model.Grids;
import com.pw.parag.Model.Products;
import com.pw.parag.R;

import java.util.ArrayList;


public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ProductListHolder> {

    Context context;
    ArrayList<Grids> al;

    public GridAdapter(Context context, ArrayList<Grids> al) {
        this.context = context;
        this.al = al;
    }

    @NonNull
    @Override
    public ProductListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductListHolder(LayoutInflater.from(context).inflate(R.layout.grid_recycler, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ProductListHolder holder, int position) {
        Grids grids = al.get(position);
        holder.tvProductName.setText(""+grids.getProductName());
        Glide.with(context).load(grids.getProductImage()).placeholder(R.drawable.ic_baseline_downloading_24).error(R.drawable.ic_baseline_broken_image_24).into(holder.ivProductImage);

    }

    @Override
    public int getItemCount() {
        return al.size();
    }


    class ProductListHolder extends RecyclerView.ViewHolder {

        TextView tvProductName;
        ImageView ivProductImage;

        public ProductListHolder(View v) {
            super(v);

            tvProductName = v.findViewById(R.id.tvProductName);
            ivProductImage = v.findViewById(R.id.ivProductImage);

        }
    }
}
