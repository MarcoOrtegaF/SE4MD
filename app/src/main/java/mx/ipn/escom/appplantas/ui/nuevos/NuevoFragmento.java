package mx.ipn.escom.appplantas.ui.nuevos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import mx.ipn.escom.appplantas.DB.DBHelper;
import mx.ipn.escom.appplantas.DB.DBPlantas;
import mx.ipn.escom.appplantas.R;

public class NuevoFragmento extends Fragment {
    EditText txtNombre, txtEspecie, txtTipo, txtEdad, txtCdPlan, txtLugar, txtDimensiones, txtNotas, txtURL;
    Button btnSelImg, btnListo;
    ImageView ImgPla;

    private Context mContext;
    public NuevoFragmento(){
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle b) {

        View v = li.inflate(R.layout.nuevo_plnt, vg, false);
        getActivity().setContentView(R.layout.nuevo_plnt);

        ImgPla = getActivity().findViewById(R.id.ImgPla);
        btnListo = getActivity().findViewById(R.id.btnList);
        btnSelImg = getActivity().findViewById(R.id.btnSelImg);

        //PRIMERA TABLA
        txtNombre = getActivity().findViewById(R.id.txtNom);
        txtEspecie = getActivity().findViewById(R.id.txtEsp);
        txtTipo = getActivity().findViewById(R.id.txtTipo);
        txtEdad = getActivity().findViewById(R.id.txtEdad);
        txtURL = getActivity().findViewById(R.id.txtUrl);

        //SEGUNDA TABLA
        txtCdPlan = getActivity().findViewById(R.id.txtCdPlan);
        txtLugar = getActivity().findViewById(R.id.txtLugar);
        txtDimensiones = getActivity().findViewById(R.id.txtDimensiones);
        txtNotas = getActivity().findViewById(R.id.txtNotas);

        btnSelImg.setOnClickListener(new View.OnClickListener() {               //BOTON PARA SETEAR LA IMAGEN DE LA PLANTA
            @Override
            public void onClick(View view) {
                String URLTry = "";
                URLTry = txtURL.getText().toString();

                Picasso.get()                   //PROBAMOS QUE LA IMAGEN SI SE PUEDA UTILIZAR
                        .load(URLTry)
                        .error(R.mipmap.ic_launcher_round)
                        .into(ImgPla);

            }
        });

        btnListo.setOnClickListener(view -> {                               //BOTON PARA ALTAS DE REGISTROS
            DBPlantas dbPlantas = new DBPlantas(mContext);
            long id;

            DBHelper dbHelper = new DBHelper(mContext);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            if(db != null){
                Toast.makeText( mContext,"Creada", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(mContext, "NO Creada", Toast.LENGTH_LONG).show();

            }

            id = dbPlantas.InsertPlanta(txtURL.getText().toString(), txtNombre.getText().toString(),
                    txtEspecie.getText().toString(), txtTipo.getText().toString(), Integer.parseInt(txtEdad.getText().toString()), txtCdPlan.getText().toString(),
                    txtLugar.getText().toString(), txtDimensiones.getText().toString(), txtNotas.getText().toString());

            if(id > 0) {
                Toast.makeText(mContext, "GUARDADO", Toast.LENGTH_LONG).show();
                Limpiar();
            }
            else
                Toast.makeText(mContext, "ERROR", Toast.LENGTH_LONG).show();

        });
        return v;
    }

    private void Limpiar(){
        txtNombre.setText("");
        txtEspecie.setText("");
        txtTipo.setText("");
        txtEdad.setText("");
        txtCdPlan.setText("");
        txtLugar.setText("");
        txtDimensiones.setText("");
        txtNotas.setText("");
        txtURL.setText("");
    }

}