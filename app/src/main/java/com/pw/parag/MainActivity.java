package com.pw.parag;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pw.parag.Adapter.BannerAdapter;
import com.pw.parag.Adapter.GridAdapter;
import com.pw.parag.Adapter.ProductListAdapter;
import com.pw.parag.Model.Banner;
import com.pw.parag.Model.Grids;
import com.pw.parag.Model.Products;
import com.skydoves.balloon.ArrowOrientation;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;
import com.skydoves.balloon.BalloonSizeSpec;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fb;
    RecyclerView rvBanner , rvProductList , rvGridList;
    LinearLayout llBanner , llProductList , llGridList , llImageSingle;

    ArrayList<Banner> alBanner;
    ArrayList<Products> alProduct;
    ArrayList<Grids> alGrid;

    ProductListAdapter productListAdapter;
    BannerAdapter bannerAdapter;
    GridAdapter gridAdapter;

    int gridCount = 3;

    ImageView ivBannerImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fb = findViewById(R.id.fb);
        rvBanner = findViewById(R.id.rvBanner);
        rvProductList = findViewById(R.id.rvProductList);
        rvGridList = findViewById(R.id.rvGridList);
        llBanner = findViewById(R.id.llBanner);
        llProductList = findViewById(R.id.llProductList);
        llGridList = findViewById(R.id.llGridList);
        llImageSingle = findViewById(R.id.llImageSingle);
        ivBannerImage = findViewById(R.id.ivImageBanner);


        alProduct = new ArrayList<>();
        productListAdapter = new ProductListAdapter(this, alProduct);
        rvProductList.setLayoutManager(new LinearLayoutManager(this));
        rvProductList.setAdapter(productListAdapter);

        alBanner = new ArrayList<>();
        bannerAdapter = new BannerAdapter(this , alBanner);
        rvBanner.setLayoutManager(new LinearLayoutManager(this , RecyclerView.VERTICAL , false));
        rvBanner.setHasFixedSize(false);
        rvBanner.setNestedScrollingEnabled(false);
        rvBanner.setAdapter(bannerAdapter);

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Balloon ballon = new Balloon.Builder(MainActivity.this)
                        .setLayout(R.layout.layout_info)
                        .setArrowSize(10)
                        .setArrowColor(ContextCompat.getColor(MainActivity.this, R.color.pink))
                        .setArrowOrientation(ArrowOrientation.RIGHT)
                        .setArrowPosition(0.5f)
                        .setWidthRatio(0.80f)
                        .setHeight(BalloonSizeSpec.WRAP)
                        .setCornerRadius(4f)
                        .setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.white))
                        .setBalloonAnimation(BalloonAnimation.CIRCULAR)
                        .setLifecycleOwner((LifecycleOwner) MainActivity.this)
                        .build();

                ballon.show(((RelativeLayout)findViewById(R.id.rl)));
            }
        });

        getListData();
    }


    public void getListData() {
//        try {
//
//            JSONObject main = new JSONObject();
//
//            JSONArray array = new JSONArray();
//
//
//            array.put(new JSONObject().put("productImage", "https://c4.wallpaperflare.com/wallpaper/113/82/562/minions-despicable-me-3-2017-movies-animated-movies-wallpaper-preview.jpg"));
//            array.put(new JSONObject().put("productImage", "https://images.unsplash.com/photo-1593085512500-5d55148d6f0d?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8Y2FydG9vbnxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&w=1000&q=80"));
//            array.put(new JSONObject().put("productImage", "https://images.unsplash.com/photo-1623346016470-53d81533a76d?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80"));
//            array.put(new JSONObject().put("productImage", "https://i.pinimg.com/originals/e4/9f/17/e49f174aa55f338e655f9325b4cb494c.jpg"));
//            main.put("banner",array);
//
//            JSONArray array2 = new JSONArray();
//            JSONObject objProduct1 = new JSONObject();
//            objProduct1.put("productID", "1");
//            objProduct1.put("productImage", "https://m.media-amazon.com/images/I/51GyUUKe-0L.jpg");
//            objProduct1.put("productName", "");
//            objProduct1.put("quantity", "1 Litre");
//            objProduct1.put("price", "");
//            objProduct1.put("offerPrice", "");
//            objProduct1.put("discount", "");
//            objProduct1.put("isVeg", true);
//
//            JSONObject objProduct2 = new JSONObject();
//            objProduct2.put("productID", "1");
//            objProduct2.put("productImage", "https://m.media-amazon.com/images/I/81VIi38z2xL._SY550_.jpg");
//            objProduct2.put("productName", "");
//            objProduct2.put("quantity", "1 Litre");
//            objProduct2.put("price", "");
//            objProduct2.put("offerPrice", "");
//            objProduct2.put("discount", "");
//            objProduct2.put("isVeg", true);
//
//
//            JSONObject objProduct3 = new JSONObject();
//            objProduct3.put("productID", "1");
//            objProduct3.put("productImage", "https://d5prkkjyl9azo.cloudfront.net/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/i/n/india_gate_dubar_basmati_4.jpg");
//            objProduct3.put("productName", "");
//            objProduct3.put("quantity", "1 Litre");
//            objProduct3.put("price", "");
//            objProduct3.put("offerPrice", "");
//            objProduct3.put("discount", "");
//            objProduct3.put("isVeg", true);
//
//
//            JSONObject objProduct4 = new JSONObject();
//            objProduct4.put("productID", "1");
//            objProduct4.put("productImage", "https://www.bigbasket.com/media/uploads/p/xxl/1207396_3-cadbury-oreo-creme-biscuit-vanilla-family-pack-300-g-pack-of-3.jpg");
//            objProduct4.put("productName", "");
//            objProduct4.put("quantity", "1 Litre");
//            objProduct4.put("price", "");
//            objProduct4.put("offerPrice", "");
//            objProduct4.put("discount", "");
//            objProduct4.put("isVeg", true);
//
//            array2.put(objProduct1);
//            array2.put(objProduct2);
//            array2.put(objProduct3);
//            array2.put(objProduct4);
//
//            main.put("productList", array2);
//
//
//            JSONArray array3 = new JSONArray();
//            JSONObject objGrid1 = new JSONObject();
//            objGrid1.put("productID", "1");
//            objGrid1.put("productImage", "https://m.media-amazon.com/images/I/51GyUUKe-0L.jpg");
//            objGrid1.put("productName", "");
//            objGrid1.put("quantity", "1 Litre");
//            objGrid1.put("price", "");
//            objGrid1.put("offerPrice", "");
//            objGrid1.put("discount", "");
//            objGrid1.put("isVeg", true);
//
//            JSONObject objGrid2 = new JSONObject();
//            objGrid2.put("productID", "1");
//            objGrid2.put("productImage", "https://m.media-amazon.com/images/I/81VIi38z2xL._SY550_.jpg");
//            objGrid2.put("productName", "");
//            objGrid2.put("quantity", "1 Litre");
//            objGrid2.put("price", "");
//            objGrid2.put("offerPrice", "");
//            objGrid2.put("discount", "");
//            objGrid2.put("isVeg", true);
//
//
//            JSONObject objGrid3 = new JSONObject();
//            objGrid3.put("productID", "1");
//            objGrid3.put("productImage", "https://d5prkkjyl9azo.cloudfront.net/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/i/n/india_gate_dubar_basmati_4.jpg");
//            objGrid3.put("productName", "");
//            objGrid3.put("quantity", "1 Litre");
//            objGrid3.put("price", "");
//            objGrid3.put("offerPrice", "");
//            objGrid3.put("discount", "");
//            objGrid3.put("isVeg", true);
//
//
//            JSONObject objGrid4 = new JSONObject();
//            objGrid4.put("productID", "1");
//            objGrid4.put("productImage", "https://www.bigbasket.com/media/uploads/p/xxl/1207396_3-cadbury-oreo-creme-biscuit-vanilla-family-pack-300-g-pack-of-3.jpg");
//            objGrid4.put("productName", "");
//            objGrid4.put("quantity", "1 Litre");
//            objGrid4.put("price", "");
//            objGrid4.put("offerPrice", "");
//            objGrid4.put("discount", "");
//            objGrid4.put("isVeg", true);
//
//            array3.put(objGrid1);
//            array3.put(objGrid2);
//            array3.put(objGrid3);
//            array3.put(objGrid4);
//
//            main.put("GridList", array3);
//
//
//            System.out.println("JSON "+ main);
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        InputStream is = getResources().openRawResource(R.raw.text);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];

        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        /***************************************************************************/
        /*Potrait Banner URL*/
        /*"https://psdfreebies.com/wp-content/uploads/2018/08/Big-Sale-Web-Banner-PSD-Templates-Preview.jpg"*/
        /***************************************************************************/
        try {

            String jsonString = writer.toString();
            JSONObject obj = new JSONObject(jsonString);

            gridCount = obj.optInt("GridCount" , 3);

            Glide.with(this).load(obj.optString("singleBanner")).placeholder(R.drawable.ic_baseline_downloading_24).error(R.drawable.ic_baseline_broken_image_24).into(ivBannerImage);

            JSONArray arProduct = obj.optJSONArray("productList");

            if (arProduct!=null && arProduct.length()>=0) {

                for (int i = 0; i < arProduct.length(); i++) {
                    alProduct.add(new Products(arProduct.getJSONObject(i)));
                }
                productListAdapter.notifyDataSetChanged();
            }
            else {
                llProductList.setVisibility(View.GONE);
            }

            JSONArray arBanner = obj.optJSONArray("banner");

            if (arBanner!=null && arBanner.length()>=0) {
                for (int i = 0; i < arBanner.length(); i++) {
                    alBanner.add(new Banner(arBanner.getJSONObject(i).getString("productImage")));
                }
                bannerAdapter.notifyDataSetChanged();
            }
            else {
                llBanner.setVisibility(View.GONE);
            }

            JSONArray arGrid = obj.optJSONArray("GridList");

            if (arGrid!=null && arGrid.length()>=0) {
                alGrid = new ArrayList<>();
                gridAdapter = new GridAdapter(this, alGrid);
                rvGridList.setLayoutManager(new GridLayoutManager(this, gridCount, RecyclerView.VERTICAL, false));
                rvGridList.setAdapter(gridAdapter);

                for (int i = 0; i < arGrid.length(); i++) {
                    alGrid.add(new Grids(arGrid.getJSONObject(i).getString("productID"), arGrid.getJSONObject(i).getString("productImage"), arGrid.getJSONObject(i).getString("productName")));
                }
                gridAdapter.notifyDataSetChanged();
            }
            else {
                llGridList.setVisibility(View.GONE);
            }

        }catch (Exception e){

        }


    }

}