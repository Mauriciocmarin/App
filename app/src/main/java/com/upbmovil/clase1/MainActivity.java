package com.upbmovil.clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {


    private EditText txtVisor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this.txtVisor = (EditText) findViewById(R.id.txtVisor);
    }

    public void clickNum1 (View v){
        txtVisor.setText("1");
    }
}