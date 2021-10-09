package com.tokioschol.tp9_acitivitys;

import static com.tokioschol.tp9_acitivitys.MainActivity.KEY_INTENT_USER;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.tokioschol.tp9_acitivitys.databinding.ActivityObjectsBinding;
import com.tokioschol.tp9_acitivitys.domain.User;

public class ObjectDateActivity extends AppCompatActivity {

    private ActivityObjectsBinding binding;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityObjectsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //leer datos recibidos
        bundleArgs();
        bindDates();
    }

    private void bundleArgs() {
        if (getIntent().getExtras() != null) {
            user = getIntent().getExtras().getParcelable(KEY_INTENT_USER);
        }
    }

    private void bindDates() {
        if(user!=null) {
            binding.objectDateActivityUserText.setText(getString(R.string.user_name, user.getName(), user.getLastName(), user.getAge()));
        }
    }
}
