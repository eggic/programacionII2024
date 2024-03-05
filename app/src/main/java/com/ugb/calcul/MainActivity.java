package com.ugb.calcul;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtnombre, txtdireccion, txtTelefono, txtmail, txtdui;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Configurar el modo claro/oscuro basado en la configuración del sistema
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configurar la barra de herramientas
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Enlazar los EditText y el Button con sus respectivos IDs
        txtnombre = findViewById(R.id.txtnombre);
        txtdireccion = findViewById(R.id.txtdireccion);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtmail = findViewById(R.id.txtmail);
        txtdui = findViewById(R.id.txtdui);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Cambiar el color del texto en txtnombre en función del modo claro/oscuro
        int textColor = ContextCompat.getColor(
                this,
                AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES
                        ? android.R.color.white
                        : android.R.color.black
        );

        txtnombre.setTextColor(textColor);

        // Resto de tu código...
    }

    // Resto de tu código...
}
