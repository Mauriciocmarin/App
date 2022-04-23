package datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import modelo.Estudiante;

public class EstudianteCAD {

    public static boolean guardarEstudiante(Estudiante e, Context c){

        // llamando a la base de datos en modo escritura
        Datos dbHelper = new Datos(c);
        // Gets the data repository in write mode
        SQLiteDatabase db = dbHelper.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(Datos.EST_NOMBRE,e.getNombre());
        values.put(Datos.EST_APELLIDO,e.getApellido());
        values.put(Datos.EST_EDAD,e.getEdad());
        values.put(Datos.EST_DIRECCION,e.getDireccion());
        values.put(Datos.EST_TELEFONO,e.getTelefono());
        values.put(Datos.EST_CORREO,e.getCorreo());

// Insert the new row, returning the primary key value of the new row
        long id = db.insert(Datos.TABLA_ESTUDIANTE, null, values);
        return id >0;

    }
}
