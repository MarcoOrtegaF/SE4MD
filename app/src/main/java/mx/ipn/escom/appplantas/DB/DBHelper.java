package mx.ipn.escom.appplantas.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

    /*
        CLASE PARA MANEJAR LA BD
    */

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "PlantasInfo.DB"; //NOMBRE DE LA BB
    private static final String TABLE_PLANTAS = "T_Plantas";    //TABLAS DE LA BD

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_PLANTAS + "(" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Nombre TEXT NOT NULL," +
                "Tip_Planta TEXT NOT NULL)");   //QUERY PARA CREAR TABLA

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_PLANTAS);
        onCreate(sqLiteDatabase);
    }
}
