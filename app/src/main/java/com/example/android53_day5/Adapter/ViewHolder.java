package com.example.android53_day5.Adapter;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android53_day5.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    //tv1: name
    //tv2: price
    TextView tv1,tv2;
    ImageView img;
    public ViewHolder(@NonNull android.view.View itemView) {
        super(itemView);
        img = (ImageView) itemView.findViewById(R.id.img);
        tv1 = (TextView) itemView.findViewById(R.id.tv1);
        tv2 = (TextView) itemView.findViewById(R.id.tv2);


    }
}
