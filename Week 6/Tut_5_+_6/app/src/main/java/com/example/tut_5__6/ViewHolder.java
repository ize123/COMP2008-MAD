package com.example.tut_5__6;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    public ImageView northWestImg;
    public ImageView northEastImg;
    public ImageView southWestImg;
    public ImageView southEastImg;

    public ImageView structure;
    public ViewHolder(@NonNull View itemView)
    {
        super(itemView);
        northWestImg = itemView.findViewById(R.id.northWest);
        northEastImg = itemView.findViewById(R.id.northEast);
        southWestImg = itemView.findViewById(R.id.southWest);
        southEastImg = itemView.findViewById(R.id.southEast);
        structure = itemView.findViewById(R.id.topImage);

    }
}
