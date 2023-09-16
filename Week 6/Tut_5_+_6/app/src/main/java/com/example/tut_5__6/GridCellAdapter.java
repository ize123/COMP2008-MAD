package com.example.tut_5__6;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GridCellAdapter extends RecyclerView.Adapter<GridCellVH> {
    MapData data;
    fragment_map fragment;

    public GridCellAdapter(MapData data, fragment_map fragment){
        this.data = data;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public GridCellVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.grid_cell, parent, false);
        GridCellVH gridCellVH = new GridCellVH(view, parent);
        return gridCellVH;
    }

    @Override
    public void onBindViewHolder(@NonNull GridCellVH holder, int position) {

        int row = position % MapData.HEIGHT;
        int col = position / MapData.HEIGHT;

        MapElement me = data.get(row, col);
        if(me.getStructure() != null)
            holder.structure.setImageResource(me.getStructure().getDrawableId());
        holder.northWestImg.setImageResource(me.getNorthWest());
        holder.northEastImg.setImageResource(me.getNorthEast());
        holder.southWestImg.setImageResource(me.getSouthWest());
        holder.southEastImg.setImageResource(me.getSouthEast());

        holder.structure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // set the on click when a piece has been selected here
                if(fragment.retrieveStruct() != null)
                {
                    //Set the structure on the map here -- unsure how to do yet
                    Log.d("Values: ", fragment.retrieveStruct().getLabel());
                }
            }
        });
    }

    // Set it to 300 as the size of the map is 30 x 10 (Unsure if correct ask Sajib in class)
    @Override public int getItemCount() {
        return 300;
    }
}
