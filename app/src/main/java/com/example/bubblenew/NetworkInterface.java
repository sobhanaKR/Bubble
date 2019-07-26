package com.example.bubblenew;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkInterface {


    @GET("v2/5d35e3715600007d5d3a50d9")
    Call<BubbleModel> getProductList();
}
