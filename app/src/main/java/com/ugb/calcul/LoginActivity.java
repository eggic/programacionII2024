package com.ugb.calcul;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUsuario;
    private EditText editTextContraseña;
    private Button btnIniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Aquí inflamos el diseño de inicio de sesión

        // Inicializar vistas
        editTextUsuario = findViewById(R.id.editTextUsuario);
        editTextContraseña = findViewById(R.id.editTextContraseña);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);

        // Configurar clic de botón de inicio de sesión
        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí agregarías la lógica para iniciar sesión
                String usuario = editTextUsuario.getText().toString();
                String contraseña = editTextContraseña.getText().toString();

                // Aquí deberías realizar la validación de los datos y la autenticación del usuario
                // Por ahora, solo mostraremos un mensaje de inicio de sesión exitoso
                mostrarMensaje("Inicio de sesión exitoso. Usuario: " + usuario + ", Contraseña: " + contraseña);
            }
        });
    }

    // Método para mostrar mensajes en forma de Toast
    private void mostrarMensaje(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}
