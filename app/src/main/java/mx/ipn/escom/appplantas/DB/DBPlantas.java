package mx.ipn.escom.appplantas.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import mx.ipn.escom.appplantas.Entidades.Plantas;

public class DBPlantas extends DBHelper{

    private static Context context;
    //Context context;

    public DBPlantas(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long InsertPlanta(String URL, String Nombre, String Especie, String Tipo, int Edad, String CuandPla, String Lugar, String Dimensiones , String Notas){
        long id = 0;

        try {
            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase DB = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("URLIMG", URL);
            values.put("Nombre", Nombre);
            values.put("Especie", Especie);
            values.put("Tipo_Planta", Tipo);
            values.put("Edad", Edad);
            values.put("Cuand_Plant", CuandPla);
            values.put("Lugar", Lugar);
            values.put("Dimensiones", Dimensiones);
            values.put("Notas", Notas);

            id = DB.insert(TABLE_PLANTAS, null, values);
            System.out.println("S-ID = "+id);
        }catch (Exception Ex){
            System.out.println( Ex.toString());
            Ex.toString();
        }
        return id;
    }

    public static ArrayList <Plantas> mostrarPlantas(){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase DB = dbHelper.getWritableDatabase();

        ArrayList <Plantas> ListaPlantas = new ArrayList<>();
        Plantas plantas = null;
        Cursor cursorPlantas = null;

        cursorPlantas = DB.rawQuery("SELECT * FROM " + TABLE_PLANTAS, null);

        if(cursorPlantas.moveToFirst()){
            do{
                plantas = new Plantas();

                plantas.setID(cursorPlantas.getInt(0));
                plantas.setURL(cursorPlantas.getString(1));
                plantas.setNombre(cursorPlantas.getString(2));
                plantas.setEspecie(cursorPlantas.getString(3));
                ListaPlantas.add(plantas);
            }while (cursorPlantas.moveToNext());
        }

        cursorPlantas.close();

        return ListaPlantas;
    }

    public String ObtBusq(){
        String query;
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase DB = dbHelper.getWritableDatabase();
        Cursor cursorPlantas = null;

        cursorPlantas = DB.rawQuery("SELECT * FROM " + TABLE_PLANTAS, null);


    }
}
