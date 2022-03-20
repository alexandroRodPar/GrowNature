package com.proyecto.alexandrorodriguez.grownature.ui.ejemplos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EjemplosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public EjemplosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is EJEMPLOS fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}