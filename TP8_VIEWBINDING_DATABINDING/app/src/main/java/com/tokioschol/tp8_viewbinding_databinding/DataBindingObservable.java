package com.tokioschol.tp8_viewbinding_databinding;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import com.tokioschol.tp8_viewbinding_databinding.databinding.ActivityDataBindingObservableBinding;

public class DataBindingObservable extends AppCompatActivity {

    private ActivityDataBindingObservableBinding dataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = ActivityDataBindingObservableBinding.inflate(getLayoutInflater());
        setContentView(dataBinding.getRoot());

    }
}