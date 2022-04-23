package com.upbmovil.clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

public class PresentacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentacion);
        pasarPantalla();

    }

    private void pasarPantalla() {
        CountDownTimer contador = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                // pasar de un pantalla a otra  donde estoy para donde voy
                Intent intension = new Intent(PresentacionActivity.this,LoginActivity.class);

                //ejecuto la intension de una pantalla a otro
                startActivity(intension);

                //finaliza la pantalla si le dan atras
                finish();
            }
        };
        contador.start();

    }

}