package com.ugb.calcul;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroupOperaciones1;
    private RadioGroup radioGroupOperaciones2;
    private Button calcularButton;
    private TextView lblRespuesta;
    private TextView txtDato1, txtDato2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroupOperaciones1 = findViewById(R.id.radioGroupOperaciones1);
        radioGroupOperaciones2 = findViewById(R.id.radioGroupOperaciones2);
        calcularButton = findViewById(R.id.button);
        lblRespuesta = findViewById(R.id.lblrespuesta);
        txtDato1 = findViewById(R.id.txtdato1);
        txtDato2 = findViewById(R.id.txtdato2);

        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los datos ingresados
                double dato1 = Double.parseDouble(txtDato1.getText().toString());

                // Validar si txtDato2 está vacío
                String txtDato2Value = txtDato2.getText().toString();
                double dato2 = 0; // Valor por defecto si txtDato2 está vacío

                if (!txtDato2Value.isEmpty()) {
                    dato2 = Double.parseDouble(txtDato2Value);
                }

                // Realizar la operación deseada y mostrar el resultado en lblRespuesta
                String respuesta = "";

                if (radioGroupOperaciones1.getCheckedRadioButtonId() != -1) {
                    RadioButton selectedRadio1 = findViewById(radioGroupOperaciones1.getCheckedRadioButtonId());
                    String operacion1 = selectedRadio1.getText().toString();

                    switch (operacion1) {
                        case "Suma":
                            respuesta = String.valueOf(dato1 + dato2);
                            break;
                        case "Resta":
                            respuesta = String.valueOf(dato1 - dato2);
                            break;
                        case "Multiplicación":
                            respuesta = String.valueOf(dato1 * dato2);
                            break;
                        case "División":
                            if (dato2 != 0) {
                                respuesta = String.valueOf(dato1 / dato2);
                            } else {
                                respuesta = "Error: División por cero";
                            }
                            break;
                    }
                }

                if (radioGroupOperaciones2.getCheckedRadioButtonId() != -1) {
                    RadioButton selectedRadio2 = findViewById(radioGroupOperaciones2.getCheckedRadioButtonId());
                    String operacion2 = selectedRadio2.getText().toString();

                    switch (operacion2) {
                        case "Porcentaje":
                            respuesta = String.valueOf((dato1 / 100) * dato2);
                            break;
                        case "Exponenciación":
                            respuesta = String.valueOf(Math.pow(dato1, dato2));
                            break;
                        case "Factorial":
                            if (dato1 >= 0 && dato1 == (int) dato1) {
                                respuesta = String.valueOf(factorial((int) dato1));
                            } else {
                                respuesta = "Error: Factorial solo acepta números enteros no negativos";
                            }
                            break;
                        case "Raíz":
                            // Agregar lógica para manejar diferentes tipos de raíces y exponentes
                            respuesta = calcularRaiz(dato1, dato2);
                            break;
                    }
                }

                // Mostrar la respuesta en lblRespuesta
                lblRespuesta.setText(respuesta);
                lblRespuesta.setVisibility(View.VISIBLE);

                // Reiniciar los RadioGroups
                radioGroupOperaciones1.clearCheck();
                radioGroupOperaciones2.clearCheck();
            }
        });
    }

    // Método para calcular el factorial de un número entero
    private long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    // Método para calcular la raíz con diferentes tipos y exponentes
    private String calcularRaiz(double base, double exponente) {
        // Validar si el exponente es un número entero positivo
        if (exponente >= 0 && exponente == (int) exponente) {
            double resultado;

            // Calcular la raíz cuadrada
            if (exponente == 2) {
                resultado = Math.sqrt(base);
            }
            // Calcular la raíz cúbica
            else if (exponente == 3) {
                resultado = Math.cbrt(base);
            }
            // Calcular raíz con otro exponente
            else {
                resultado = Math.pow(base, 1 / exponente);
            }

            return String.valueOf(resultado);
        } else {
            return "Error: El exponente debe ser un número entero no negativo";
        }
    }
}