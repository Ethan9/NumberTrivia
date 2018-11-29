package com.example.ethan.numbertrivia;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class FactAdapter extends RecyclerView.Adapter<FactViewHolder>  {


    private Context context;
    public List<NumberFactItem> listFactObject;


    public FactAdapter(Context context, List<NumberFactItem> listFactObject) {
        this.context = context;
        this.listFactObject = listFactObject;
    }


    @Override
    public FactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.number_card, parent, false);
        return new FactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FactViewHolder factViewHolder, int i) {
        // Gets a single item in the list from its position
        final NumberFactItem numberFactItem = listFactObject.get(i);
        // The holder argument is used to reference the views inside the viewHolder
        // Populate the views with the data from the list
        factViewHolder.numberFact.setText(numberFactItem.getText());
        factViewHolder.randomNumber.setText(numberFactItem.getNumber().toString());
    }

    @Override
    public int getItemCount() {
        return listFactObject.size();
    }
}
