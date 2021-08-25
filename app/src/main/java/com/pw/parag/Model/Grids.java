package com.pw.parag.Model;

import org.json.JSONObject;

public class Grids {

    private String productID,
            productImage,
            productName;

    public Grids(JSONObject objProduct) {
        try {
            setProductID(objProduct.getString("productID"));
            setProductImage(objProduct.getString("productImage"));
            setProductName(objProduct.getString("productName"));
        }catch(Exception e){
            System.out.println("Error "+e);
        }
    }

    public Grids(String productID, String productImage, String productName) {
        this.productID = productID;
        this.productImage = productImage;
        this.productName = productName;
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
}
