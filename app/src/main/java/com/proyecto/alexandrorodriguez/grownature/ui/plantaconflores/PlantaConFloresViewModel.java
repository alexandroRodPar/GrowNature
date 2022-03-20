package com.proyecto.alexandrorodriguez.grownature.ui.plantaconflores;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PlantaConFloresViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PlantaConFloresViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is PLANTAS CON FLORES fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}