package com.tokioschol.tp9_actionbar_toolbar;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.tokioschol.tp9_actionbar_toolbar.databinding.ActivityMainBinding;
import com.tokioschol.tp9_actionbar_toolbar.features.actionbar.ActionBarActivity;
import com.tokioschol.tp9_actionbar_toolbar.features.material.MaterialToolbarActivity;
import com.tokioschol.tp9_actionbar_toolbar.features.toolbar.ToolbarActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.mainActionBar.setOnClickListener(view -> navigate(ActionBarActivity.class));
        binding.mainToolbar.setOnClickListener(view -> navigate(ToolbarActivity.class));
        binding.mainToolbarMaterial.setOnClickListener(view -> navigate(MaterialToolbarActivity.class));
    }

    private void navigate(Class<?> clazz) {
        startActivity(new Intent(this, clazz));
    }
}