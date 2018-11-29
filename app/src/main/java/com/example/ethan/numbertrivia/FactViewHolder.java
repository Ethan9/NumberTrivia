package com.example.ethan.numbertrivia;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class FactViewHolder extends RecyclerView.ViewHolder {
    public TextView randomNumber;
    public TextView numberFact;

    public FactViewHolder(@NonNull View itemView) {
        super(itemView);
        randomNumber = itemView.findViewById(R.id.randomNumberTextView);
        numberFact = itemView.findViewById(R.id.randomFactTextView);
    }
}