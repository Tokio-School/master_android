package com.tokioschol.tp7_main_widgets_android.widgets;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.tokioschol.tp7_main_widgets_android.R;

public class InputLayoutActivity extends AppCompatActivity {

    private TextInputEditText inputPassword;
    private TextInputLayout inputLayoutPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputlayout);
        bindViews();
        checkPasswork();
    }

    private void bindViews() {
        inputPassword = findViewById(R.id.input_text_filled);
        inputLayoutPassword = findViewById(R.id.input_layout_filled);
    }

    private void checkPasswork() {
        inputLayoutPassword.setStartIconOnClickListener(v -> {
            if(inputPassword.getText()!=null && "123456".equalsIgnoreCase(inputPassword.getText().toString())){
                inputLayoutPassword.setError(null);
                Snackbar.make(inputPassword,"Password correcto",Snackbar.LENGTH_LONG).show();
            }else{
                inputLayoutPassword.setErrorEnabled(true);
                inputLayoutPassword.setError("Ups?? comprueba que es correcto");
            }
        });
    }
}