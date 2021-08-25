package com.pw.parag.Model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Products {

    private String productID,
            productImage,
            productName;

    ArrayList<ProductTypes> alProductTypes;

    private Boolean isVeg;

    public Products(JSONObject objProduct) {
        try {
            setProductID(objProduct.getString("productID"));
            setProductImage(objProduct.getString("productImage"));
            setProductName(objProduct.getString("productName"));
            setVeg(objProduct.getBoolean("isVeg"));

            JSONArray array = objProduct.getJSONArray("type");
            alProductTypes = new ArrayList<>();

            for (int i = 0; i<array.length();i++){
                alProductTypes.add(new ProductTypes(array.getJSONObject(i)));
            }
        }catch(Exception e){
            System.out.println("Error "+e);
        }
    }

    public Products(String productID, String productImage, String productName, ArrayList<ProductTypes> alProductTypes, Boolean isVeg) {
        this.productID = productID;
        this.productImage = productImage;
        this.productName = productName;
        this.alProductTypes = alProductTypes;
        this.isVeg = isVeg;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ArrayList<ProductTypes> getAlProductTypes() {
        return alProductTypes;
    }

    public void setAlProductTypes(ArrayList<ProductTypes> alProductTypes) {
        this.alProductTypes = alProductTypes;
    }

    public Boolean getVeg() {
        return isVeg;
    }

    public void setVeg(Boolean veg) {
        isVeg = veg;
    }
}
