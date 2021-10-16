package com.tokioschol.tp9_actionbar_toolbar.features.toolbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tokioschol.tp9_actionbar_toolbar.R;
import com.tokioschol.tp9_actionbar_toolbar.features.material.MaterialCollapsingActivity;

/**
 * {@link MaterialCollapsingActivity}
 */
public class ToolbarCollapsingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_collapsing);
    }
}