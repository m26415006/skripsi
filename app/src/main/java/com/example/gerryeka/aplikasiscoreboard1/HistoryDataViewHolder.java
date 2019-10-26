package com.example.gerryeka.aplikasiscoreboard1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by gerry eka on 10/23/2019.
 */

public class HistoryDataViewHolder extends RecyclerView.ViewHolder{
    public TextView name1,name2,setscore,setscore1,setscore2;

    public HistoryDataViewHolder(@NonNull View itemView) {
        super(itemView);

        name1 = itemView.findViewById(R.id.row_name1);
        name2 = itemView.findViewById(R.id.row_name2);
        setscore = itemView.findViewById(R.id.row_set_score);
        setscore1 = itemView.findViewById(R.id.row_set_score1);
        setscore2 = itemView.findViewById(R.id.row_set_score2);

    }



}
