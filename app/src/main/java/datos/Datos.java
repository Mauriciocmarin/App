package datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import modelo.Estudiante;

public class Datos extends SQLiteOpenHelper {


    public static String TABLA_ESTUDIANTE= "tbl_estudiantes";
    public static String EST_ID = "_id";
    public static String EST_NOMBRE = "nombre";
    public static String EST_APELLIDO = "apellido";
    public static String EST_EDAD = "edad";
    public static String EST_DIRECCION = "direccion";
    public static String EST_TELEFONO = "telefono";
    public static String EST_CORREO = "correo";
    public static String EST_CLAVE = "clave";



    public Datos(@Nullable Context context) {
        super(context,"upb.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // estrctura para crear la base de datos
        String SQL_TABLA_ESTUDIANTES = "CREATE TABLE " + TABLA_ESTUDIANTE +"(" +
                EST_ID +" LONG PRIMARY KEY AUTOINCREMENT," +
                EST_NOMBRE+" TEXT NOT NULL,"+
                EST_APELLIDO+" TEXT NOT NULL," +
                EST_EDAD+" INTEGER ," +
                EST_DIRECCION +" TEXT, " +
                EST_TELEFONO +" TEXT NOT NULL, " +
                EST_CORREO + " TEXT NOT NULL, " +
                EST_CLAVE + " TEXT NOT NULL " +
                ")";

        String T2 = "CREATE TABLE Profesores (" +
                " id INT PRIMARY KEY AUTOINCREMENT," +
                " nombre TEXT NOT NULL,"+
                " edad  INT NOT NULL," +
                "direccion CHAR(50)," +
                " salario REAL " +
                ");";

        // ejecutar las consulta
        db.execSQL(SQL_TABLA_ESTUDIANTES);
        db.execSQL(T2);

        //


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // CONSULTAR LA DATA

        //borro los datos
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_ESTUDIANTE);
        db.execSQL("DROP TABLE IF EXISTS PROFESORES;");

        // VUELVE A CREAR LAS TABLAS

        onCreate(db);

        // registro nuevamente la informacion
    }

}
