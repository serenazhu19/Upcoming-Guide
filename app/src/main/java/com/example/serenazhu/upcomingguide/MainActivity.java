package com.example.serenazhu.upcomingguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.widget.TextView;

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

import org.json.JSONObject;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        final TextView mTextView = (TextView) findViewById(R.id.text);


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
                            //GuideResponse gr = gson.fromJson(response, GuideResponse.class);
                            //GuideList guideList = gr.properties;

                            GuideList guideList = gson.fromJson(response, GuideList.class);

                            //TODO: iterate through the guides
                            Guide g = guideList.get(0);

                            mTextView.setText(String.valueOf(g.getName()) + "\n" + String.valueOf(g.getVenue()) + "\n" + String.valueOf(g.getEndDate()));
                            //mTextView.setText(String.valueOf(g.getName()));

                        } catch (Exception e) {
                            Log.d("JSON", e.toString());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mTextView.setText("Error: " + error.toString());

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


