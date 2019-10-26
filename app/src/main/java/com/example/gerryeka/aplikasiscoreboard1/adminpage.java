package com.example.gerryeka.aplikasiscoreboard1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class adminpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpage);
    }

    public void livebutton(View v){
        Intent myIntent = new Intent(getBaseContext(), Admin_Live.class);
        startActivity(myIntent);
    }
}
