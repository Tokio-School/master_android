package com.tokioschol.tp7_main_widgets_android.widgets;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.tokioschol.tp7_main_widgets_android.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputLayoutActivity extends AppCompatActivity {

    private TextInputEditText inputPassword;
    private TextInputLayout inputLayoutPassword;
    private AutoCompleteTextView dropdownInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputlayout);
        bindViews();
        checkPasswork();
        drpopdown();
    }

    private void drpopdown() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,getList());
        dropdownInput.setAdapter(adapter);
    }

    private List<String> getList() {
        return new ArrayList<String>(Arrays.asList("uno","dos","ttres"));
    }

    private void bindViews() {
        inputPassword = findViewById(R.id.input_text_filled);
        inputLayoutPassword = findViewById(R.id.input_layout_filled);
        dropdownInput = findViewById(R.id.autocompletetxt);
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