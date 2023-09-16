package com.example.tut_5__6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    fragment_map frag_map = new fragment_map();
    fragment_selector frag_selector = new fragment_selector();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frag_map.setSelectorFragment(frag_selector);
        loadMapFragment();
        loadSelectorFragment();
    }

    private void loadMapFragment()
    {
        FragmentManager fm = getSupportFragmentManager();
        Fragment frag = fm.findFragmentById(R.id.map_fragment);
        if(frag==null) {
            fm.beginTransaction().add(R.id.map_fragment, frag_map).commit();
        }
        else
        {
            fm.beginTransaction().replace(R.id.map_fragment, frag_map).commit();
        }
    }

    private void loadSelectorFragment()
    {
        FragmentManager fm = getSupportFragmentManager();
        Fragment frag = fm.findFragmentById(R.id.selector_fragment);
        if(frag==null) {
            fm.beginTransaction().add(R.id.selector_fragment, frag_selector).commit();
        }
        else
        {
            fm.beginTransaction().replace(R.id.selector_fragment, frag_selector).commit();
        }
    }
}