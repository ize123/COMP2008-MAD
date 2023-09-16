package com.example.tut_5__6;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GridCellVH extends RecyclerView.ViewHolder {
    public ImageView northWestImg;
    public ImageView northEastImg;
    public ImageView southWestImg;
    public ImageView southEastImg;

    public ImageView structure;
    public GridCellVH(@NonNull View itemView, ViewGroup parent)
    {
        super(itemView);
        // Setting the size of the view holder to a square
        int size = parent.getMeasuredHeight() / MapData.HEIGHT + 1;
        ViewGroup.LayoutParams lp = itemView.getLayoutParams();
        lp.width = size;
        lp.height = size;

        // Assign all the images
        structure = itemView.findViewById(R.id.topImage);
        northWestImg = itemView.findViewById(R.id.northWest);
        northEastImg = itemView.findViewById(R.id.northEast);
        southWestImg = itemView.findViewById(R.id.southWest);
        southEastImg = itemView.findViewById(R.id.southEast);
        structure = itemView.findViewById(R.id.topImage);
    }
}
