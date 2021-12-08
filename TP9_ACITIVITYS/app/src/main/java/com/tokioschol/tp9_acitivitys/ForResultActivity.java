package com.tokioschol.tp9_acitivitys;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tokioschol.tp9_acitivitys.databinding.ActivityForResultBinding;

public class ForResultActivity extends AppCompatActivity {

    private ActivityForResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.finishBtn.setOnClickListener(v -> returnValues());
    }

    private void returnValues() {
        if(binding.nameEt.getText()!=null && binding.nameEt.getText().length()>0){
            Intent resultIntent = new Intent();
            resultIntent.putExtra("resultado",binding.nameEt.getText().toString());
            setResult(RESULT_OK,resultIntent);
            finish();
        }else{
            Toast.makeText(this,"debes de introducir un nombre",Toast.LENGTH_LONG).show();
        }
    }
}
