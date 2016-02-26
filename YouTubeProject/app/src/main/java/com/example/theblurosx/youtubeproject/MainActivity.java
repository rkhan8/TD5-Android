package com.example.theblurosx.youtubeproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ClassYoutube classYoutube;

    private ListView listVue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button search = (Button) findViewById(R.id.buttonSearch);

        final EditText textsearch = (EditText) findViewById(R.id.TextSearch);

        listVue = (ListView) findViewById(R.id.listView);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String result = textsearch.getText().toString();

                result = result.replaceAll(" ", "%20");


                String stringURL = "https://www.googleapis.com/youtube/v3/search?part=snippet&q="+result+"&type=video&maxResults=8&key=AIzaSyAHW1VVkg5Qmk8Y2qsnNk5B9rSohQrxVOM";

                RequestQueue queue = Volley.newRequestQueue(MainActivity.this, null);

                // Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, stringURL,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response){

                                Gson gson = new Gson();

                                classYoutube = gson.fromJson(response, ClassYoutube.class);

                                final ArrayList<Items> item = classYoutube.getItems();
                                final YoutubeAdapter contractAdapterList = new YoutubeAdapter(MainActivity.this, item);
                                listVue.setAdapter(contractAdapterList);


                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
                // Add the request to the RequestQueue.
                queue.add(stringRequest);


            }
        });


    }
}
