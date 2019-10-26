package com.example.gerryeka.aplikasiscoreboard1;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.gerryeka.aplikasiscoreboard1.Adapter.Adapter_adminlive;
import com.example.gerryeka.aplikasiscoreboard1.Model.Model_adminlive;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Admin_Live extends AppCompatActivity {
    private RecyclerView recyclerView;
    ArrayList<Model_adminlive> adminList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__live);
        recyclerView = findViewById(R.id.adminliveview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adminList = new ArrayList<Model_adminlive>();

        JsonFetch jsonFetch = new JsonFetch();
        jsonFetch.execute();
    }

    public class JsonFetch extends AsyncTask<String,String,String>{

        HttpURLConnection httpURLConnection = null;
        String mainfile;
        @Override
        protected String doInBackground(String... strings) {

            try {
                URL url = new URL("http://192.168.0.32/loginapp/adminlive.php");
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer = new StringBuffer();
                String line="";
                while ((line=bufferedReader.readLine())!=null){
                    stringBuffer.append(line);

                }
                mainfile = stringBuffer.toString();
                JSONArray parent = new JSONArray(mainfile);
                int i = 0;
                while(i <= parent.length()){
                    JSONObject child = parent.getJSONObject(i);

                    String id = child.getString("id_live");
                    String name1 = child.getString("name1");
                    String name2 = child.getString("name2");
                    String setscore = child.getString("set_score");
                    String setscore1 = child.getString("set_score1");
                    String setscore2 = child.getString("set_score2");
                    String score1 = child.getString("score1");
                    String score2 = child.getString("score2");


                    adminList.add(new Model_adminlive(id,name1,name2,setscore,setscore1,setscore2,score1,score2));

                    i++;
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Adapter_adminlive adapter_adminlive = new Adapter_adminlive(adminList,getApplicationContext());
            recyclerView.setAdapter(adapter_adminlive);

        }


    }

}
