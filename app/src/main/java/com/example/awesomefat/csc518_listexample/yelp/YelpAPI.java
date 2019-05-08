package com.example.awesomefat.csc518_listexample.yelp;

import com.example.awesomefat.csc518_listexample.Core;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

public class YelpAPI extends Thread
{
    public void run()
    {

        try
        {
            // Core.currTree.payload.city + Core.currTree.payload.region
            URL airportURL = new URL("https://api.yelp.com/v3/businesses/search?location=" + Core.currTree.payload.city + ", " + Core.currTree.payload.region.split("-")[1] +
                    "&categories=restaurants");
            HttpURLConnection conn = (HttpURLConnection)airportURL.openConnection();
            conn.setRequestProperty("Authorization", "Bearer SV8YFmRSUiCnvnCcjijA0Tj1DAS5kkPPR2iG-r4MUf162PczJhWtBmklN9gdQFENqCKMeGVE2dyLpEESk8sgabPAsvjo8J6RH0GNVmeDaHHpeDBFNeytfN1oIQDJXHYx");
            Scanner input = new Scanner(conn.getInputStream());
            String data = "";

            while(input.hasNextLine())
            {
                data = data + input.nextLine();
            }
            input.close();
            System.out.println("*** DATA: " + data);
            Core.obj = new JSONObject(data);
            Core.businesses = Core.obj.getJSONArray("businesses");
            for(int i = 0; i < Core.businesses.length(); i++)
            {
                String name = Core.businesses.getJSONObject(i).getString("name");
                Core.businessesArrayList.add(name);
                System.out.println("*** " + name);
            }


        }
        catch(Exception e)
        {
            System.out.println("*** " + e.toString());
        }
    }
}
