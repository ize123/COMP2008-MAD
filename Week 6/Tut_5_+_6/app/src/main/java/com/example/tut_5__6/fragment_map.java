package com.example.tut_5__6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_map#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_map extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recycView;
    fragment_selector selectorFragment;

    public fragment_map() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_map.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_map newInstance(String param1, String param2) {
        fragment_map fragment = new fragment_map();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_map, container, false);

        recycView = (RecyclerView) view.findViewById(R.id.mapRecyclerView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), MapData.HEIGHT, GridLayoutManager.HORIZONTAL, false);

        recycView.setLayoutManager(gridLayoutManager);

        MapData data = MapData.get();

        GridCellAdapter adapter = new GridCellAdapter(data, this);
        recycView.setAdapter(adapter);

        return view;
    }

    public void setSelectorFragment(fragment_selector fragment)
    {
        this.selectorFragment = fragment;
    }
    public Structure retrieveStruct()
    {
        return selectorFragment.getStructure();
    }
}