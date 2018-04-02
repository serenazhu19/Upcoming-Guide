package com.example.serenazhu.upcomingguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ListView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import org.json.JSONObject;
import org.json.JSONArray;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import java.util.HashMap;
import java.util.Map;

/**
 * Application to display information about upcoming events
 * as retrieved from a server.
 *
 * Author: Serena Zhu
 * Date: 04/02/2018
 */

public class MainActivity extends AppCompatActivity {


    ListView listView;
    GuideAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_simple);
        //to use my adapter, one would use setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        final TextView guide1 = (TextView) findViewById(R.id.guide1);
        final TextView guide2 = (TextView) findViewById(R.id.guide2);


        //Instantiate the RequestQueue
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://guidebook.com/service/v2/upcomingGuides/";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //Logging the response from the server for debugging
                            Log.d("Response", response.toString());


                            //parse the string, based on provided Guide class object
                            Gson gson = new GsonBuilder().create();

                            GuideList guideList = gson.fromJson(response, GuideList.class);


                            /*
                            The following code would be used to set an adapter for the ListView but
                            has been commented out until future debugging.

                            listView = (ListView) findViewById(R.id.guide_list);
                            adapter = new GuideAdapter(getApplicationContext(), guideList);
                            listView.setAdapter(adapter);
                               */

                            /*
                            This was originally used for testing purposes by demonstrating that my code does correctly retrieve and print the data
                            received from the given url. Unfortunately, the list adapter I created was buggy thus I have commented out all code that
                            relates to showing all guides and have reverted to a point where only the guide that is indexed by the following 'get' function
                            returns. With additional time, it would be simple to fix the list adapter and show all guides.
                             */
                            Guide g = guideList.get(0);
                            guide1.setText(String.valueOf(g.getName()) + "\n" + String.valueOf(g.getVenue()) + "\n" + String.valueOf(g.getEndDate()));
                            ImageView image1 = (ImageView) findViewById(R.id.image1);
                            Picasso.get().load(String.valueOf(g.getUrl())).into(image1); //Did not have time to debug why this image does not load

                            Guide g2 = guideList.get(1);
                            guide2.setText(String.valueOf(g2.getName()) + "\n" + String.valueOf(g2.getVenue()) + "\n" + String.valueOf(g2.getEndDate()));
                            ImageView image2 = (ImageView) findViewById(R.id.image2);
                            Picasso.get().load(String.valueOf(g.getUrl())).into(image2); //Did not have time to debug why this image does not load


                        } catch (Exception e) {
                            Log.d("JSON", e.toString());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        guide1.setText("Error: " + error.toString());

                    }


                }) {
            //Set custom headers
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Accept", "application/json"); // or else HTTP code 500
                return params;
            }
        };

        //Add request to RequestQueue
        queue.add(stringRequest);
    }
}


