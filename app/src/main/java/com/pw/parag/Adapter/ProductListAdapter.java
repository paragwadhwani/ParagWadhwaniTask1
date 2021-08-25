package com.pw.parag.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pw.parag.Model.Products;
import com.pw.parag.R;

import java.util.ArrayList;
import java.util.List;


public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductListHolder> {

    Context context;
    ArrayList<Products> al;

    public ProductListAdapter(Context context, ArrayList<Products> al) {
        this.context = context;
        this.al = al;
    }

    @NonNull
    @Override
    public ProductListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductListHolder(LayoutInflater.from(context).inflate(R.layout.layout_product_list_recycler, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ProductListHolder holder, int position) {
        Products products = al.get(position);
        holder.tvProductName.setText(""+products.getProductName()+" - "+products.getAlProductTypes().get(0).getQuantity());
        holder.tvPrice.setText("MRP : ₹"+products.getAlProductTypes().get(0).getPrice());
        holder.tvOfferPrice.setText("DMart ₹"+products.getAlProductTypes().get(0).getOfferPrice());
        holder.tvDiscount.setText("Save ₹"+products.getAlProductTypes().get(0).getDiscount());

        Glide.with(context).load(products.getProductImage()).placeholder(R.drawable.ic_baseline_downloading_24).error(R.drawable.ic_baseline_broken_image_24).into(holder.ivProductImage);

        if (products.getVeg()){
            holder.llVeg.setBackground(context.getDrawable(R.drawable.background_veg));
            holder.cardVeg.setCardBackgroundColor(context.getResources().getColor(R.color.green));
        } else{
            holder.llVeg.setBackground(context.getDrawable(R.drawable.background_nonveg));
            holder.cardVeg.setCardBackgroundColor(context.getResources().getColor(R.color.red));
        }

        List<String> list = new ArrayList<String>();
        for (int i = 0 ; i<products.getAlProductTypes().size();i++){
            list.add(products.getAlProductTypes().get(i).getQuantity());
        }

        ArrayAdapter<String> adapter =new ArrayAdapter<String>(context, R.layout.spinner_layout , list);
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        holder.spType.setAdapter(adapter);

        holder.spType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                holder.tvProductName.setText(""+products.getProductName()+" - "+products.getAlProductTypes().get(position).getQuantity());
                holder.tvPrice.setText("MRP : ₹"+products.getAlProductTypes().get(position).getPrice());
                holder.tvOfferPrice.setText("DMart ₹"+products.getAlProductTypes().get(position).getOfferPrice());
                holder.tvDiscount.setText("Save ₹"+products.getAlProductTypes().get(position).getDiscount());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        holder.btnAddList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.btnAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return al.size();
    }


    class ProductListHolder extends RecyclerView.ViewHolder {

        TextView tvProductName, tvPrice , tvOfferPrice , tvDiscount;
        Button btnAddList , btnAddCart;
        CardView cardVeg;
        LinearLayout llVeg;
        ImageView ivProductImage;
        Spinner spType;

        public ProductListHolder(View v) {
            super(v);

            tvProductName = v.findViewById(R.id.tvProductName);
            tvPrice = v.findViewById(R.id.tvPrice);
            tvOfferPrice = v.findViewById(R.id.tvOfferPrice);
            tvDiscount = v.findViewById(R.id.tvDiscount);
            btnAddList = v.findViewById(R.id.btnAddList);
            btnAddCart = v.findViewById(R.id.btnAddCart);
            llVeg = v.findViewById(R.id.llVeg);
            cardVeg = v.findViewById(R.id.cardVeg);
            ivProductImage = v.findViewById(R.id.ivProductImage);
            spType = v.findViewById(R.id.spAmount);

        }
    }
}
