package mx.ipn.escom.appplantas.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

    /*
        CLASE PARA MANEJAR LA BD
    */

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 15;
    private static final String DATABASE_NOMBRE = "PlantasInfo.DB"; //NOMBRE DE LA BB
    public static final String TABLE_PLANTAS = "T_Plantas";    //TABLAS DE LA BD
    final String CREAR_TABLA_PLANTAS = "CREATE TABLE IF NOT EXISTS " + TABLE_PLANTAS + " (Id INTEGER PRIMARY KEY AUTOINCREMENT, URLIMG TEXT NOT NULL, Nombre TEXT NOT NULL, Especie TEXT NOT NULL, Tipo_Planta TEXT NOT NULL, Edad INTEGER NOT NULL, " +
            " Cuand_Plant TEXT NOT NULL, Lugar TEXT NOT NULL, Dimensiones TEXT NOT NULL, Notas TEXT NOT NULL);";


    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREAR_TABLA_PLANTAS);   //QUERY PARA CREAR TABLA PLANTAS Y CUIDADOS     + "; " + CREAR_TABLA_CUIDADOS
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PLANTAS);
        onCreate(sqLiteDatabase);
    }
}
