package com.ugb.calcul;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    // Declaración de vistas
    EditText editTextNombre, editTextEmail, editTextContraseñaRegistro;
    Button btnRegistrarse;
    TextView txtLoginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        // Inicialización de vistas
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextContraseñaRegistro = findViewById(R.id.editTextContraseñaRegistro);
        btnRegistrarse = findViewById(R.id.btnRegistrarse);
        txtLoginLink = findViewById(R.id.txtLoginLink);

        // Configuración de clics de botón para el registro
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para registrar al usuario
                String nombre = editTextNombre.getText().toString();
                String email = editTextEmail.getText().toString();
                String contraseña = editTextContraseñaRegistro.getText().toString();

                // Aquí deberías enviar los datos a tu backend o realizar el registro en tu base de datos

                // Por ahora, simplemente mostramos un mensaje de registro exitoso
                mostrarMensaje("Registro exitoso. Nombre: " + nombre + ", Email: " + email + ", Contraseña: " + contraseña);
            }
        });

        // Configuración de clics de texto para volver al inicio de sesión
        txtLoginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí puedes agregar la lógica para ir a la pantalla de inicio de sesión
                // Por ejemplo, puedes iniciar una nueva actividad de inicio de sesión
                // Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                // startActivity(intent);
            }
        });
    }

    // Método para mostrar mensajes en forma de Toast
    private void mostrarMensaje(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}
