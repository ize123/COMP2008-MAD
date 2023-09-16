package com.example.tutorial4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    MenuFragment menuFragment = new MenuFragment();
    NoteTakingFragment noteFragment = new NoteTakingFragment();
    boolean rotated = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout layout2 = findViewById(R.id.f_container2);

        int screenOrientation = getResources().getConfiguration().orientation;
        if (screenOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            // make the note taking framelayout visible
            layout2.setVisibility(View.VISIBLE);
            rotated = true;

        } else if (screenOrientation == Configuration.ORIENTATION_PORTRAIT) {
            // Portrait orientation
            // make the note taking framelayout invisible
            layout2.setVisibility(View.INVISIBLE);
            layout2.setVisibility(View.GONE);
            rotated = false;
        }

        loadMenuFragment();
        MainActivityData mainActivityDataViewModel = new ViewModelProvider(this)
                .get(MainActivityData.class);
        mainActivityDataViewModel.clickedValue.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if(mainActivityDataViewModel.getClikedValue() == 1)
                {
                    loadNoteTakingFragment();
                }
                if(mainActivityDataViewModel.getClikedValue() == 2)
                {
                    loadMenuFragment();
                }
            }
        });
    }

    private void loadMenuFragment()
    {
        FragmentManager fm = getSupportFragmentManager();
        Fragment frag = fm.findFragmentById(R.id.f_container);
        if(frag==null) {
            fm.beginTransaction().add(R.id.f_container, menuFragment).commit();
        }
        else
        {
            fm.beginTransaction().replace(R.id.f_container, menuFragment).commit();
        }
    }

    private void loadNoteTakingFragment()
    {
        FragmentManager fm = getSupportFragmentManager();
        Fragment frag = fm.findFragmentById(R.id.f_container);
        if(rotated)
        {
            if(frag==null) {
                fm.beginTransaction().add(R.id.f_container2, noteFragment).commit();
            }
            else {
                fm.beginTransaction().replace(R.id.f_container2, noteFragment).commit();
            }
        }
        else {
            if(frag==null) {
                fm.beginTransaction().add(R.id.f_container, noteFragment).commit();
            }
            else {
                fm.beginTransaction().replace(R.id.f_container, noteFragment).commit();
            }
        }
    }
}