package com.upbmovil.clase1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import API.API;
import modelo.Estudiante;


public class RegistroActivity extends AppCompatActivity {

    EditText txtRazonSocial,txtNIT,txtDireccion,txtCorreo,txtContrasena,txtRepetirContrasena;

    String razonSocial,nit,direcciones,email,clave;
    Button btnRegistrar;
    //ProgressBar progressBar;

    private void inicializarGUI() {

        txtRazonSocial = findViewById(R.id.txtRazonSocial);
        txtNIT = findViewById(R.id.txtNIT);
        txtDireccion = findViewById(R.id.txtDireccion);
        txtCorreo = findViewById(R.id.txtCorreo);
        txtContrasena = findViewById(R.id.txtContrasena);
        txtRepetirContrasena = findViewById(R.id.txtRepetirContrasena);

        btnRegistrar= findViewById(R.id.btnRegistrar);
        btnRegistrar.setVisibility(View.VISIBLE);
        //progressBar.setVisibility(View.GONE);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        inicializarGUI();
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                razonSocial = txtRazonSocial.getText().toString();
                nit=txtNIT.getText().toString();
                direcciones = txtDireccion.getText().toString();
                email = txtCorreo.getText().toString();
                clave = txtContrasena.getText().toString();

                agregarEmpresa(razonSocial,nit,direcciones,email,clave);
            }
        });

    }



    public void registarEmpresa(View view){

        btnRegistrar.setVisibility(View.GONE);
        //pdEspera.setVisibility(View.VISIBLE);

                //btnRegistrar.setVisibility(View.VISIBLE);
                //pdEspera.setVisibility(View.GONE);
                //Toast.makeText(getApplicationContext(),"Finalizó la petición ",Toast.LENGTH_LONG).show();

                // Solicitamos a un API rest

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = API.URL_BASE +"/empresas";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        btnRegistrar.setVisibility(View.VISIBLE);
                        //pdEspera.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(),"Entro"+response,Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                btnRegistrar.setVisibility(View.VISIBLE);
                //pdEspera.setVisibility(View.GONE);
                if(error.getMessage().contains("Connection reset")){
                    Toast.makeText(getApplicationContext(),"Verifica tu conexión a WIFI",Toast.LENGTH_LONG).show();

                }else {
                    Toast.makeText(getApplicationContext(),"Upps intenta más tarde !",Toast.LENGTH_LONG).show();

                }

            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);


    }


    private void agregarEmpresa(String razonSocial,String nit, String direcciones,String email,String clave){

        btnRegistrar.setVisibility(View.GONE);
        //progressBar.setVisibility(View.VISIBLE);

        String url = API.URL_BASE +"/empresas";

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        StringRequest  request = new StringRequest (Request.Method.POST, url, new com.android.volley.Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject respObj = new JSONObject(response);
                            Toast.makeText(getApplicationContext(),respObj.getString("Mensaje"),Toast.LENGTH_LONG).show();


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        txtRazonSocial.getText().clear();
                        txtNIT.getText().clear();
                        txtDireccion.getText().clear();
                        txtCorreo.getText().clear();
                        txtContrasena.getText().clear();
                        txtRepetirContrasena.getText().clear();
                        btnRegistrar.setVisibility(View.VISIBLE);
                        Toast.makeText(getApplicationContext(),"Guardado con Exito",Toast.LENGTH_LONG).show();


                        Intent intension = new Intent(getApplicationContext(),LoginActivity.class);

                        //ejecuto la intension de una pantalla a otro
                        startActivity(intension);

                        //finaliza la pantalla si le dan atras
                        finish();

                    }
                    }, new com.android.volley.Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    // method to handle errors.
                    Toast.makeText(getApplicationContext(), "Upps! Falla al crear la empresa = " + error, Toast.LENGTH_SHORT).show();
                    btnRegistrar.setVisibility(View.VISIBLE);

                }
            }) {
                @Override
                protected Map<String, String> getParams() {
                    // below line we are creating a map for
                    // storing our values in key and value pair.
                    Map<String, String> params = new HashMap<String, String>();

                    // on below line we are passing our key
                    // and value pair to our parameters.
                    params.put("razon_social",razonSocial);
                    params.put("nit",nit);
                    params.put("direccion",direcciones);
                    params.put("correo", email);
                    params.put("contrasena", clave);

                    // at last we are
                    // returning our params.
                    return params;
                }
            };
            // below line is to make
            // a json object request.
        queue.add(request);
        btnRegistrar.setVisibility(View.VISIBLE);
        }

    public void guardarEmpresa(View v){
       /* //if(validarFormulario()){
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
       // }*/
    }


    public void actualizarEstudiante(View v){
       /*
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
        // } */
    }

    private void limpiarCampos(){

        /*txtNombre.getText().clear();
        txtApellido.getText().clear();
        txtDireccion.getText().clear();
        txtTelefono.getText().clear();
        txtCorreo.getText().clear();
        txtContrasena.getText().clear();
        txtRepetirContrasena.getText().clear();
        txtEdad.getText().clear();*/
    }

    Estudiante e;
    public void consultar(View v){
        /*
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
        */

    }

    public void  cancelar(View v){
        /*
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

         */

    }

    private void reiniciar() {
        /*
        btnActualizar.setVisibility(View.GONE);
        btnRegistrar.setVisibility(View.VISIBLE);
        btnConsultar.setVisibility(View.VISIBLE);
        btnCancelar.setVisibility(View.GONE);
        limpiarCampos();
    }

         */

    }
}