package com.onlineclothingshopping;

public class ItemModel {

    private String item_name,item_price,image_name,item_description;
    private int image_id;

    public ItemModel(String item_name, String item_price, String image_name, String item_description,int image_id) {
        this.item_name = item_name;
        this.item_price = item_price;
        this.image_name = image_name;
        this.item_description = item_description;
        this.image_id=image_id;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_price() {
        return item_price;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }
}
