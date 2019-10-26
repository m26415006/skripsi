package com.example.gerryeka.aplikasiscoreboard1.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.gerryeka.aplikasiscoreboard1.LiveMatches;
import com.example.gerryeka.aplikasiscoreboard1.Model.Model_live;
import com.example.gerryeka.aplikasiscoreboard1.R;

import java.util.List;

/**
 * Created by gerry eka on 10/10/2019.
 */

public class Adapter_live extends ArrayAdapter<Model_live> {

    private List<Model_live> ListLive;
    private Context mCtx;

    public Adapter_live(List<Model_live> L, Context c) {
        super(c, R.layout.listlivematch, L);
        this.ListLive = L;
        this.mCtx = c;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.listlivematch,null,true);

        TextView id = (TextView) view.findViewById(R.id.IDmatch);
        TextView nama1 = (TextView) view.findViewById(R.id.Nama1);
        TextView nama2 = (TextView) view.findViewById(R.id.Nama2);
        TextView set_score1 = (TextView) view.findViewById(R.id.Set_Score1);
        TextView set_score2 = (TextView) view.findViewById(R.id.Set_Score2);
        TextView score1 = (TextView) view.findViewById(R.id.Score1);
        TextView score2 = (TextView) view.findViewById(R.id.Score2);

//        Button button3 = (Button) view.findViewById(R.id.button3);


        Model_live Live = ListLive.get(position);
        id.setText(Live.getId());
        nama1.setText(Live.getNama1());
        nama2.setText(Live.getNama2());
        set_score1.setText(Live.getSet_score1());
        set_score2.setText(Live.getSet_score2());
        score1.setText(Live.getScore1());
        score2.setText(Live.getScore2());

        return view;

    }


}
