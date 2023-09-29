package com.example.tut_5__6;

import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ScrollCellAdapter extends RecyclerView.Adapter<ScrollCellVH>{
    StructureData data;
    fragment_selector fragment;

    public ScrollCellAdapter(StructureData data, fragment_selector fragment)
    {
        this.data = data;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public ScrollCellVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_selection, parent, false);
        ScrollCellVH scrollCellVH = new ScrollCellVH(view, parent);
        return scrollCellVH;
    }

    @Override
    public void onBindViewHolder(@NonNull ScrollCellVH holder, int position) {
        Structure singleData = data.get(position);
        holder.image.setImageResource(singleData.getDrawableId());
        holder.text.setText(singleData.getLabel());
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // set the currently select map piece here
                fragment.setStructure(singleData);
            }
        });
    }



    @Override
    public int getItemCount() {
        return data.size();
    }
}
