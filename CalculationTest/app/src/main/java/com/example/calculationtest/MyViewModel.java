package com.example.calculationtest;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.SavedStateHandle;

public class MyViewModel extends AndroidViewModel {
    public MyViewModel(@NonNull Application application, SavedStateHandle handle) {
        super(application);
    }
}
