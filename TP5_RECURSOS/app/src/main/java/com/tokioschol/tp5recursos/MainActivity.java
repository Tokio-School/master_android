package com.tokioschol.tp5recursos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setValueStringFromJava();
        setStringFormatFromJava();
        setPluralsStrings();
        setArrayStrings();
    }

    private void setValueStringFromJava() {
        //1- Debemos de traernos la referencia de la vista xml.
        TextView wellcomeText = findViewById(R.id.text_java);

        //2- Recoger el valor del recurso string
        String valueText = getString(R.string.wellcome_course);

        //3- Set del valor recogido al TextView.
        wellcomeText.setText(valueText);

        //4- Para recuros colores cambiamos las propiedades del TextView
        wellcomeText.setTextColor(getResources().getColor(R.color.white,null));
        wellcomeText.setBackgroundColor(getResources().getColor(R.color.purple_700,null));
    }

    private void setStringFormatFromJava() {
        //1 Dar valor a las variables del string format. En este caso son 2 strings y un Entero.
        String nameMaster = "Master en Android";
        String teacher = "Manuel Cabezas";
        int duration = 600;

        //2- Debemos de traernos la referencia de la vista xml.
        TextView wellcomeFormat = findViewById(R.id.formatted_text);

        //3- Get el recurso string
        String formatString = getString(R.string.wellcome_course_format, nameMaster, teacher, duration);

        //4- Set el valor al TextView
        wellcomeFormat.setText(formatString);
    }

    private void setPluralsStrings() {
        //1 Dar valor a las variables del plural, En caso de ser más de un libro tendra formato el string
        String singularFound = getResources().getQuantityString(R.plurals.books_found,1);
        String pluralFound = getResources().getQuantityString(R.plurals.books_found, 6,6);

        //2- Debemos de traernos la referencia de la vista xml.
        TextView singularTextView = findViewById(R.id.plurals_zero_book);
        TextView pluralTextView = findViewById(R.id.plurals_two_book);

        //3 Set de los valores
        singularTextView.setText(singularFound);
        pluralTextView.setText(pluralFound);
    }

    private void setArrayStrings() {
        //1 Obtener el recurso com variable.
        String[] androidVersions = getResources().getStringArray(R.array.android_versions);

        //2- Debemos de traernos la referencia de la vista xml.
        Spinner spinner = findViewById(R.id.spinner_java);

        //3- Set del array al spinner (En el xml es el que hemos realizado mediante entries).
        spinner.setAdapter(new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, androidVersions));
    }
}