package com.example.bubblenew;

import android.app.Service;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BubbleActivity extends FloatingBubbleService {
    TextView itemName, price, brand, sku;

    @Override
    protected FloatingBubbleConfig getConfig() {
        Context context = getApplicationContext();
        View rootView = inflater.inflate(R.layout.sample_view_1, null);
        init(rootView);
        getApiCall();
        return new FloatingBubbleConfig.Builder()
                .bubbleIcon(ContextCompat.getDrawable(context, R.drawable.web_icon))
                .removeBubbleIcon(ContextCompat.getDrawable(context, com.example.bubblenew.R.drawable.close_default_icon))
                .bubbleIconDp(80)
                .expandableView(rootView)
                .removeBubbleIconDp(70)
                .paddingDp(4)
                .borderRadiusDp(0)
                .physicsEnabled(true)
                .expandableColor(Color.WHITE)
                .triangleColor(0xFF215A64)
                .gravity(Gravity.LEFT)
                .build();



    }

    private void init(View rootView) {
        itemName = rootView.findViewById(R.id.item_name);
        price = rootView.findViewById(R.id.price);
        sku = rootView.findViewById(R.id.sku);
        brand = rootView.findViewById(R.id.brand);
    }

    private void getApiCall() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NetworkInterface networkInterface = retrofit.create(NetworkInterface.class);
        Call<BubbleModel> call = networkInterface.getProductList();
        call.enqueue(new Callback<BubbleModel>() {
            @Override
            public void onResponse(Call<BubbleModel> call, Response<BubbleModel> response) {
                if (response.isSuccessful()) {
                    BubbleModel bubbleModel = response.body();
                    itemName.setText(bubbleModel.getItem_name());
                    price.setText(bubbleModel.getPrice());
                    brand.setText(bubbleModel.getBrand());
                    sku.setText(bubbleModel.getSku());
                }
            }

            @Override
            public void onFailure(Call<BubbleModel> call, Throwable t) {

            }
        });
    }
}
