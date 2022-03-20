package com.proyecto.alexandrorodriguez.grownature.ui.plantasinflores;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PlantasSinFloresViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PlantasSinFloresViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is PLANTAS SIN FLORES fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}