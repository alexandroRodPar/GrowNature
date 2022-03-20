package com.proyecto.alexandrorodriguez.grownature.ui.arboles;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ArbolesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ArbolesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is ARBOLES fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}