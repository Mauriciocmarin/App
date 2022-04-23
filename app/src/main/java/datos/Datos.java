package datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Datos extends SQLiteOpenHelper {

    public Datos(@Nullable Context context) {
        super(context,"upb.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // estrctura para crear la base de datos
        String T1 = "CREATE TABLE Estudiante (" +
                " id INT PRIMARY KEY AUTOINCREMENT," +
                " nombre TEXT NOT NULL,"+
                " edad  INT NOT NULL," +
                "direccion CHAR(50)," +
                " subbsidio REAL " +
                ");";

        String T2 = "CREATE TABLE Profesores (" +
                " id INT PRIMARY KEY AUTOINCREMENT," +
                " nombre TEXT NOT NULL,"+
                " edad  INT NOT NULL," +
                "direccion CHAR(50)," +
                " salario REAL " +
                ");";

        // ejecutar las consulta
        db.execSQL(T1);
        db.execSQL(T2);

        //


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // CONSULTAR LA DATA

        //borro los datos
        db.execSQL("DROP TABLE IF EXISTS Estudiante;");
        db.execSQL("DROP TABLE IF EXISTS PROFESORES;");

        // VUELVE A CREAR LAS TABLAS

        onCreate(db);

        // registro nuevamente la informacion
    }
}
