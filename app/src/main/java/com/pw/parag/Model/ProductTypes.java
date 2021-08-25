package com.pw.parag.Model;

import org.json.JSONArray;
import org.json.JSONObject;

public class ProductTypes {

    String quantity,
    price,
    offerPrice,
    discount;

    public ProductTypes(JSONObject obj) {
        try {
            setQuantity(obj.getString("quantity"));
            setPrice(obj.getString("price"));
            setOfferPrice(obj.getString("offerPrice"));
            setDiscount(obj.getString("discount"));

        }catch(Exception e ){

        }
    }

    public ProductTypes(String quantity, String price, String offerPrice, String discount) {
        this.quantity = quantity;
        this.price = price;
        this.offerPrice = offerPrice;
        this.discount = discount;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(String offerPrice) {
        this.offerPrice = offerPrice;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
