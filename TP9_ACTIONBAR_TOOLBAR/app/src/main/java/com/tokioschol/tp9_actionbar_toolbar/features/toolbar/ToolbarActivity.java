package com.tokioschol.tp9_actionbar_toolbar.features.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.shoppingcart) {
            Toast.makeText(ToolbarActivity.this, "icono en toolbar pulsado", Toast.LENGTH_SHORT).show();
            return true;
        }

        if (item.getItemId() == R.id.shoppingcart2) {
            Toast.makeText(ToolbarActivity.this, "icono en toolbar pulsado", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}