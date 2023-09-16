package com.example.tutorial4;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityData extends ViewModel {
    public MutableLiveData<Integer> clickedValue;
    private MutableLiveData<String> noteBody;
    private MutableLiveData<String> noteTitle;

    public MainActivityData()
    {
        clickedValue = new MediatorLiveData<Integer>();
        clickedValue.setValue(0);
        noteBody = new MediatorLiveData<String>();
        noteTitle = new MediatorLiveData<String>();
    }

    public int getClikedValue() {
        return clickedValue.getValue();
    }
    public void setClickedValue(int value){
        clickedValue.setValue(value);
    }
    public String getNoteBody(){
        return noteBody.getValue();
    }
    public void setNoteBody(String value){
        noteBody.setValue(value);
    }
    public String getNoteTitle(){
        return noteTitle.getValue();
    }
    public void setNoteTitle(String value){
        noteTitle.setValue(value);
    }
}
