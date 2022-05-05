package com.upbmovil.clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }

    public void Registar (View v){
        // pasar de un pantalla a otra  donde estoy para donde voy
        Intent intension = new Intent(LoginActivity.this,RegistroActivity.class);

        //ejecuto la intension de una pantalla a otro..
        startActivity(intension);


    }

}