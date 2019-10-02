package com.hdelacruz.gastos_ingresos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup tipoingresoRadio;
    private RadioGroup tipocuenta;
    private TextView montoText;
    private RadioButton ingresoRadio;
    private RadioButton egresoRadio;
    private RadioButton tcreditoRadio;
    private RadioButton tahorrosRadio;
    private RadioButton efectivoRadio;
    private Button registrarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        montoText = findViewById(R.id.monto_text);
        ingresoRadio = findViewById(R.id.ingreso_radio);
        egresoRadio = findViewById(R.id.egreso_radio);
        tcreditoRadio = findViewById(R.id.tcredito_radio);
        tahorrosRadio = findViewById(R.id.tahorros_radio);
        efectivoRadio = findViewById(R.id.efectivo_radio);
        registrarButton = findViewById(R.id.registrar_button);

        tipoingresoRadio =  (RadioGroup) findViewById(R.id.tipo_ingreso);
        tipocuenta = (RadioGroup) findViewById(R.id.tipo_cuenta);
        tipoingresoRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                answer();
            }

            private void answer() {

                int radioButtonId = tipoingresoRadio.getCheckedRadioButtonId();
                if (radioButtonId == -1) {
                    Toast.makeText(MainActivity.this, "Selecione una de los dos", Toast.LENGTH_SHORT).show();
                } else {
                    // Individual selected
                    if (radioButtonId == R.id.ingreso_radio) {
                        Toast.makeText(MainActivity.this, "Seleciono Ingreso", Toast.LENGTH_SHORT).show();

                    } else if (radioButtonId == R.id.egreso_radio) {
                        Toast.makeText(MainActivity.this, "Selecciono Egreso", Toast.LENGTH_SHORT).show();

                    }

                }
            }
        });

        registrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callregister();
            }
        });
    }

    private void  callregister(){

        String  monto = montoText.getText().toString();
        if(monto.isEmpty()){
            Toast.makeText(this, "Complete el campo", Toast.LENGTH_SHORT).show();
            return;

        }


        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



}
