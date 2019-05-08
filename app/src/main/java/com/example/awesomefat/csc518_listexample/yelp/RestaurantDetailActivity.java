package com.example.awesomefat.csc518_listexample.yelp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.awesomefat.csc518_listexample.R;

public class RestaurantDetailActivity extends AppCompatActivity
{
    private TextView name, url, rating, reviewCount, address, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);

        //name, url, rating, review count, address, phone
        this.name = this.findViewById(R.id.nameTV);
        this.url = this.findViewById(R.id.urlTV);
        this.rating = this.findViewById(R.id.ratingTV);
        this.reviewCount = this.findViewById(R.id.reviewCountTV);
        this.address = this.findViewById(R.id.addressTV);
        this.phone = this.findViewById(R.id.phoneTV);
    }
}
