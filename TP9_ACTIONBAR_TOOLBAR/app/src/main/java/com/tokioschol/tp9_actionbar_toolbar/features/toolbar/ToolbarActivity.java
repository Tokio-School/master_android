package com.tokioschol.tp9_actionbar_toolbar.features.toolbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.tokioschol.tp9_actionbar_toolbar.R;
import com.tokioschol.tp9_actionbar_toolbar.databinding.ActivityToolbarBinding;

public class ToolbarActivity extends AppCompatActivity {

    private ActivityToolbarBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityToolbarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);



        binding.toolbar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.shoppingcart) {
                Toast.makeText(ToolbarActivity.this, "icono en toolbar pulsado", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });

    }

}