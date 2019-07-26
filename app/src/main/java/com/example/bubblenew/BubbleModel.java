package com.example.bubblenew;

import android.os.Parcel;
import android.os.Parcelable;

public class BubbleModel implements Parcelable {
    String item_name;
    String sku;
    String price;
    String brand;
    String image_url;

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public static Creator<BubbleModel> getCREATOR() {
        return CREATOR;
    }



    protected BubbleModel(Parcel in) {
        item_name = in.readString();
        sku = in.readString();
        price = in.readString();
        brand = in.readString();
        image_url = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(item_name);
        dest.writeString(sku);
        dest.writeString(price);
        dest.writeString(brand);
        dest.writeString(image_url);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BubbleModel> CREATOR = new Creator<BubbleModel>() {
        @Override
        public BubbleModel createFromParcel(Parcel in) {
            return new BubbleModel(in);
        }

        @Override
        public BubbleModel[] newArray(int size) {
            return new BubbleModel[size];
        }
    };
}
