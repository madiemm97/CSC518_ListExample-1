package com.example.awesomefat.csc518_listexample.yelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.awesomefat.csc518_listexample.AirportDetailActivity;
import com.example.awesomefat.csc518_listexample.Core;
import com.example.awesomefat.csc518_listexample.R;

public class YelpActivity extends AppCompatActivity
{
    private ListView restaurantsLV;
    private YelpActivity myself;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yelp);
        this.myself = this;
        this.restaurantsLV = this.findViewById(R.id.restaurantsLV);

        //Core.businessesArrayList.clear();       //this empties out the arraylist before we will it up each time with a different region

//        YelpAPI yelp = new YelpAPI();
//        yelp.start();

        ArrayAdapter aa = new ArrayAdapter<String>(this, R.layout.another_row, Core.businessesArrayList);
        this.restaurantsLV.setAdapter(aa);

//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
//                this,
//                android.R.layout.sim,
//                Core.businesses );
//        restaurantsLV.setAdapter(arrayAdapter);

        this.restaurantsLV.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long row_id)
            {
                Intent i = new Intent(myself, RestaurantDetailActivity.class);
                String airportCode = getIntent().getExtras().getString("airportCode");
                i.putExtra("airportCode", airportCode);
                String location = getIntent().getExtras().getString("location");
                i.putExtra("location", location);
                myself.startActivity(i);
            }
        });


//        YelpAPI yelp = new YelpAPI();
//        yelp.start();


    }
}
