package com.upbmovil.clase1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import datos.EstudianteCAD;
import modelo.Estudiante;

public class RegistroActivity extends AppCompatActivity {

    EditText txtNombre,txtApellido,txtDireccion,txtTelefono,txtCorreo,
            txtEdad,txtContrasena,txtRepetirContrasena;

    RadioButton radioEstudiante,radioProfesor;

    Button btnRegistrar,btnActualizar,btnCancelar,btnConsultar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        inicializarGUI();
    }

    private void inicializarGUI() {
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtDireccion = findViewById(R.id.txtDireccion);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtCorreo = findViewById(R.id.txtCorreo);
        txtEdad = findViewById(R.id.txtEdad);
        txtContrasena = findViewById(R.id.txtContrasena);
        txtRepetirContrasena = findViewById(R.id.txtRepetirContrasena);
        radioEstudiante = findViewById(R.id.radioEstudiante);
        radioProfesor = findViewById(R.id.radioProfesor);
        btnRegistrar= findViewById(R.id.btnRegistrar);
        btnActualizar= findViewById(R.id.btnActualizar);
        btnCancelar= findViewById(R.id.btnCancelar);
        btnConsultar= findViewById(R.id.btConsultar);
    }

    private boolean validarFormuladio(){

        if (txtNombre.getText().toString().isEmpty()){
            txtNombre.setError("Ingresa un nombre");
            return false;
        }else if (txtApellido.getText().toString().isEmpty()){
            txtApellido.setError("");
        }
        return true;

    }

    public void guardarEstudiante(View v){
        //if(validarFormulario()){
            //recoger los datos del formulario
            Estudiante e=new Estudiante();
            e.setNombre(txtNombre.getText().toString());
            e.setApellido(txtApellido.getText().toString());
            e.setDireccion(txtDireccion.getText().toString());
            e.setTelefono(txtTelefono.getText().toString());
            e.setCorreo(txtCorreo.getText().toString());
            e.setClave(txtContrasena.getText().toString());
            e.setEdad(Integer.parseInt(txtEdad.getText().toString()));

            if(EstudianteCAD.guardarEstudiante(e,RegistroActivity.this)){
                Toast.makeText(getApplicationContext(),"Guardado",Toast.LENGTH_LONG).show();

                //finish();
            }else{
                Toast.makeText(getApplicationContext(),"No guardó",Toast.LENGTH_LONG).show();

            }
       // }
    }


    public void actualizarEstudiante(View v){
        //if(validarFormulario()){
        //recoger los datos del formulario
        Estudiante e=new Estudiante();
        e.setNombre(txtNombre.getText().toString());
        e.setApellido(txtApellido.getText().toString());
        e.setDireccion(txtDireccion.getText().toString());
        e.setTelefono(txtTelefono.getText().toString());
        e.setCorreo(txtCorreo.getText().toString());
        e.setClave(txtContrasena.getText().toString());
        e.setEdad(Integer.parseInt(txtEdad.getText().toString()));

        if(EstudianteCAD.actualizarEstudiante(e,RegistroActivity.this)){
            Toast.makeText(getApplicationContext(),"Actualizado",Toast.LENGTH_LONG).show();
            btnActualizar.setVisibility(View.GONE);
            btnRegistrar.setVisibility(View.VISIBLE);
            cancelar(v);
            //finish();
        }else{
            Toast.makeText(getApplicationContext(),"No actualizó",Toast.LENGTH_LONG).show();

        }
        // }
    }

    private void limpiarCampos(){
        txtNombre.getText().clear();
        txtApellido.getText().clear();
        txtDireccion.getText().clear();
        txtTelefono.getText().clear();
        txtCorreo.getText().clear();
        txtContrasena.getText().clear();
        txtRepetirContrasena.getText().clear();
        txtEdad.getText().clear();
    }

    Estudiante e;
    public void consultar(View v){
        e= EstudianteCAD.consultarEstudiante(txtCorreo.getText().toString(),getApplicationContext());
        if(e!=null){
            txtNombre.setText(e.getNombre());
            txtApellido.setText(e.getApellido());
            txtDireccion.setText(e.getDireccion());
            txtTelefono.setText(e.getTelefono());
            txtEdad.setText(String.valueOf(e.getEdad()));
            btnActualizar.setVisibility(View.VISIBLE);
            btnRegistrar.setVisibility(View.GONE);
            btnConsultar.setVisibility(View.GONE);
            btnCancelar.setVisibility(View.VISIBLE);
        }
    }

    public void  cancelar(View v){
        if(!e.getNombre().equals(txtNombre.getText().toString()) || !e.getApellido().equals(txtApellido.getText().toString())) {

            AlertDialog.Builder dialogo = new AlertDialog.Builder(RegistroActivity.this);
            dialogo.setTitle("Upps!")
                    .setMessage("¿Desea salirse sin guardar los cambios?")
                    .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            reiniciar();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });

            dialogo.create();
            dialogo.show();

        }else{
            reiniciar();
        }

    }

    private void reiniciar() {
        btnActualizar.setVisibility(View.GONE);
        btnRegistrar.setVisibility(View.VISIBLE);
        btnConsultar.setVisibility(View.VISIBLE);
        btnCancelar.setVisibility(View.GONE);
        limpiarCampos();
    }

}