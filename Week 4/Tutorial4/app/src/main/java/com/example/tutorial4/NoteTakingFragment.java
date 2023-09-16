package com.example.tutorial4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NoteTakingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NoteTakingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NoteTakingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NoteTakingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NoteTakingFragment newInstance(String param1, String param2) {
        NoteTakingFragment fragment = new NoteTakingFragment();
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
        View view =  inflater.inflate(R.layout.fragment_note_taking, container, false);
        MainActivityData mainActivityDataViewModel = new ViewModelProvider(getActivity()).
                get(MainActivityData.class);

        Button saveButton = view.findViewById(R.id.save_note);
        EditText noteTitle = view.findViewById(R.id.note_title);
        EditText noteBody = view.findViewById(R.id.note_body);

        noteTitle.setText(mainActivityDataViewModel.getNoteTitle());
        noteBody.setText(mainActivityDataViewModel.getNoteBody());

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityDataViewModel.setNoteTitle(noteTitle.getText().toString());
                mainActivityDataViewModel.setNoteBody(noteBody.getText().toString());
                mainActivityDataViewModel.setClickedValue(2);
            }
        });
        return view;
    }
}