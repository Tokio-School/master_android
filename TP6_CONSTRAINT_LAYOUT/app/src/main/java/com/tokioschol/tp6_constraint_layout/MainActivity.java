package com.tokioschol.tp6_constraint_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.tokioschol.tp6_constraint_layout.databinding.ActivityMainBinding;
import com.tokioschol.tp6_constraint_layout.examples.BarrierConstraint;
import com.tokioschol.tp6_constraint_layout.examples.ChainConstraints;
import com.tokioschol.tp6_constraint_layout.examples.OnboardingExample;
import com.tokioschol.tp6_constraint_layout.examples.SimpleConstraint;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        listeners();
    }

    private void listeners() {
        binding.simpleConstraints.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, SimpleConstraint.class)));
        binding.barrierConstraints.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, BarrierConstraint.class)));
        binding.chainHorizontalVerticalConstraints.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, ChainConstraints.class)));
        binding.exampleOnboardingPageConstraints.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, OnboardingExample.class)));
    }
}