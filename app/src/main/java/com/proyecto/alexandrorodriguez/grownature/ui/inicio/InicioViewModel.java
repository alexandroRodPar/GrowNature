package com.proyecto.alexandrorodriguez.grownature.ui.inicio;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InicioViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public InicioViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is INICIO fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}