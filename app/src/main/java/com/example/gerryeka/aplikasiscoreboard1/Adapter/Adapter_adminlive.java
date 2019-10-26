package com.example.gerryeka.aplikasiscoreboard1.Adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gerryeka.aplikasiscoreboard1.Admin_Live;
import com.example.gerryeka.aplikasiscoreboard1.AdminliveDataViewHolder;
import com.example.gerryeka.aplikasiscoreboard1.EditAdminLive;
import com.example.gerryeka.aplikasiscoreboard1.Model.Model_adminlive;
import com.example.gerryeka.aplikasiscoreboard1.R;

import java.util.ArrayList;

/**
 * Created by gerry eka on 10/23/2019.
 */

public class Adapter_adminlive extends RecyclerView.Adapter<AdminliveDataViewHolder>{

    ArrayList<Model_adminlive> list;
    Context context;

    public Adapter_adminlive() {
    }

    public Adapter_adminlive(ArrayList<Model_adminlive> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public AdminliveDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listadminlive,parent,false);


        return new AdminliveDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdminliveDataViewHolder holder, int position) {
        Model_adminlive currentData = list.get(position);
        holder.name1.setText(currentData.getNama1());
        holder.name2.setText(currentData.getNama2());
        holder.setscore.setText(currentData.getSet_score());
        holder.setscore1.setText(currentData.getSet_score1());
        holder.setscore2.setText(currentData.getSet_score2());
        holder.score1.setText(currentData.getScore1());
        holder.score2.setText(currentData.getScore2());
        holder.editbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), EditAdminLive.class);
                view.getContext().startActivity(myIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
