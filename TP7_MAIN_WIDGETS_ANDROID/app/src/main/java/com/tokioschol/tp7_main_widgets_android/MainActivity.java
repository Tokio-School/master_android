package com.tokioschol.tp7_main_widgets_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.tokioschol.tp7_main_widgets_android.databinding.ActivityMainBinding;
import com.tokioschol.tp7_main_widgets_android.widgets.CardViewActivity;
import com.tokioschol.tp7_main_widgets_android.widgets.InputLayoutActivity;
import com.tokioschol.tp7_main_widgets_android.widgets.SpinnerActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.activitySpinner.setOnClickListener(view -> startActivity(new Intent(this, SpinnerActivity.class)));
        binding.activityCardView.setOnClickListener(view -> startActivity(new Intent(this, CardViewActivity.class)));
        binding.activityInputLayout.setOnClickListener(view-> startActivity(new Intent(this, InputLayoutActivity.class)));

    }
}