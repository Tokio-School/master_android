package com.tokioschol.tp8_viewbinding_databinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.tokioschol.tp8_viewbinding_databinding.databinding.ActivityMainBinding;
import com.tokioschol.tp8_viewbinding_databinding.databinding.DataBindingFragment;
import com.tokioschol.tp8_viewbinding_databinding.viewbinding.ViewBindingInflateFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //2 Debemos recuperar la vista a utilizar
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //3 Ahora ya podemos utilizar la vinculación directa con la vista
        binding.btnViewBindingInflateFragment.setOnClickListener(v ->
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(binding.container.getId(), new ViewBindingInflateFragment())
                        .commitAllowingStateLoss());

        binding.btnDababindingFragment.setOnClickListener(v ->
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(binding.container.getId(), new DataBindingFragment())
                        .commitAllowingStateLoss());
    }
}