package mx.ipn.escom.appplantas;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import mx.ipn.escom.appplantas.DB.DBHelper;

public class Mis_plantas extends Activity implements View.OnClickListener {
    Button BtnCrea;

   @Override
   public void onCreate (Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.mis_plantas);

   }
        @Override
    public void onClick(View view) {
    }
}
