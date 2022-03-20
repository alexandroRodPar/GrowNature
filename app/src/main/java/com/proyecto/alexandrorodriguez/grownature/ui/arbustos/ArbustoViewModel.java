package com.proyecto.alexandrorodriguez.grownature.ui.arbustos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ArbustoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ArbustoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is ARBUSTO fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}