package com.example.tut_5__6;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ScrollCellVH extends RecyclerView.ViewHolder {
    public ImageView image;
    public TextView text;
    public ImageView selectImage;

    public ScrollCellVH(@NonNull View itemView, ViewGroup parent)
    {
        super(itemView);
        image = itemView.findViewById(R.id.selectorImage);
        text = itemView.findViewById(R.id.selectorText);
        selectImage = itemView.findViewById(R.id.selectedImage);
    }
}
