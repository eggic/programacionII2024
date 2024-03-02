package com.ugb.calcul;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TabHost tbh;
    Spinner spn;
    TextView tempVal;
    Button btnCalc, btnConvert;
    Conversores miObj = new Conversores();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbh = findViewById(R.id.tbhParcial);
        tbh.setup();

        // Pestaña "Calculadora"
        tbh.addTab(tbh.newTabSpec("CALC").setContent(R.id.tabcalc).setIndicator("Calculadora", null));

        // Pestaña "Área"
        tbh.addTab(tbh.newTabSpec("AREA").setContent(R.id.tab_Area).setIndicator("Área", null));

        // Botón para la pestaña "Calculadora"
        btnCalc = findViewById(R.id.btncalc);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para el botón de la pestaña "Calculadora"
                calcularTarifaAgua();
            }
        });

        // Botón para la pestaña "Área"
        btnConvert = findViewById(R.id.btnConvertirArea);
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para el botón de la pestaña "Área"
                spn = findViewById(R.id.spnArea);
                int de = spn.getSelectedItemPosition();
                spn = findViewById(R.id.spnDArea);
                int a = spn.getSelectedItemPosition();
                tempVal = findViewById(R.id.txtCantidadArea);
                double cantidad = Double.parseDouble(tempVal.getText().toString());
                double respuesta = miObj.convertir(0, de, a, cantidad);
                Toast.makeText(getApplicationContext(), "Respuesta Área: " + respuesta, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class Conversores {
        double[][] valores = {
                {1, 10.763, 1.43, 1.19599, 0.001590, 0.0001434, 0.0001}
        };

        public double convertir(int opcion, int de, int a, double cantidad) {
            return valores[opcion][a] / valores[opcion][de] * cantidad;
        }
    }

    // Función para calcular la tarifa de agua
    private void calcularTarifaAgua() {
        EditText txtAgua = findViewById(R.id.txtAgua);
        TextView lblResp = findViewById(R.id.lblresp);

        try {
            int metrosConsumidos = Integer.parseInt(txtAgua.getText().toString());
            double tarifaTotal = calcularTarifa(metrosConsumidos);
            lblResp.setText("R// La tarifa total a pagar es: $" + tarifaTotal);
        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Ingrese una cantidad válida de metros", Toast.LENGTH_SHORT).show();
        }
    }

    // Función para calcular la tarifa de agua
    private double calcularTarifa(int metrosConsumidos) {
        double cuotaFija = 6.0;

        if (metrosConsumidos >= 1 && metrosConsumidos <= 18) {
            return cuotaFija;
        } else if (metrosConsumidos >= 19 && metrosConsumidos <= 28) {
            double exceso = metrosConsumidos - 18;
            double tarifaExceso = 0.45 * exceso;
            return cuotaFija + tarifaExceso;
        } else if (metrosConsumidos >= 29) {
            double exceso1 = 28 - 18;
            double tarifaExceso1 = 0.45 * exceso1;

            double exceso2 = metrosConsumidos - 28;
            double tarifaExceso2 = 0.65 * exceso2;

            return cuotaFija + tarifaExceso1 + tarifaExceso2;
        } else {
            Toast.makeText(getApplicationContext(), "Cantidad de metros no válida", Toast.LENGTH_SHORT).show();
            return 0.0;
        }
    }
}
