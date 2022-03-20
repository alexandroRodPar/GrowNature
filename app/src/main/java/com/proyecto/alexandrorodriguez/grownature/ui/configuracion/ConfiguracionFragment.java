package com.proyecto.alexandrorodriguez.grownature.ui.configuracion;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.proyecto.alexandrorodriguez.grownature.R;

public class ConfiguracionFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }
}