package com.example.android.zemuntour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationItemActivity extends AppCompatActivity {
    TextView name, adress;
    ImageView image;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_item);

        Bundle bundle = getIntent().getExtras();

        image = findViewById(R.id.location_item_image);
        name = findViewById(R.id.location_item_name);
        adress = findViewById(R.id.location_item_adress);
        ratingBar = findViewById(R.id.location_rating_bar);


        int imageId = bundle.getInt("image");

        String tempHolder = getIntent().getStringExtra("name");
        String tempAdressHolder = getIntent().getStringExtra("adress");

        boolean ratingStar = bundle.getBoolean("starRate");
        float stars = bundle.getFloat("stars");

        if(ratingStar) {
            ratingBar.setVisibility(View.VISIBLE);
            ratingBar.setRating(stars);
        }else {
            ratingBar.setVisibility(View.GONE);
        }


        image.setImageResource(imageId);
        adress.setText(tempAdressHolder);
        name.setText(tempHolder);
    }
}
