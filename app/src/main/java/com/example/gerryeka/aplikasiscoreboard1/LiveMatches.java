package com.example.gerryeka.aplikasiscoreboard1;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.gerryeka.aplikasiscoreboard1.Adapter.Adapter_live;
import com.example.gerryeka.aplikasiscoreboard1.Model.Model_live;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LiveMatches extends AppCompatActivity {

    ListView listView;
    List<Model_live> ListLive;
    private Adapter_live adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_matches);
        listView = (ListView) findViewById(R.id.list_live);
        ListLive = new ArrayList<>();

        content();

    }

    public void content(){
        showList();
        refresh(10000);
    }
    public void refresh(int miliseconds){
        final Handler handlerrefresh = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                content();
            }
        };
        handlerrefresh.postDelayed(runnable,miliseconds);
    }


    private void showList(){
        final StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.0.32/loginapp/listlivematches.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(final String response) {

                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONArray array = obj.getJSONArray("semualive");
                            ListLive.clear();
                            for(int i = 0; i<array.length();i++){
                                JSONObject liveObj = array.getJSONObject(i);
                                Model_live L = new Model_live(liveObj.getString("id_live"),liveObj.getString("name1"),liveObj.getString("name2"),
                                        liveObj.getString("set_score1"),liveObj.getString("set_score2"),liveObj.getString("score1"),liveObj.getString("score2"));

                                ListLive.add(L);

                            }
                            Adapter_live adapter = new Adapter_live(ListLive,getApplicationContext());
                            listView.setAdapter(adapter);

//                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                                @Override
//                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                                    Intent myintent = new Intent(LiveMatches.this, livedetail.class);
//                                    myintent.putExtra("key", );
//                                    startActivity(myintent);
//                                }
//                            });
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){

        };

        Handler_live.getmInstance(getApplicationContext()).addtoRequestQue(stringRequest);

    }


}
