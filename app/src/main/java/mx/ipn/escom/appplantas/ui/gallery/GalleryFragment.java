package mx.ipn.escom.appplantas.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.squareup.picasso.Picasso;

import mx.ipn.escom.appplantas.DB.DBHelper;
import mx.ipn.escom.appplantas.R;
import mx.ipn.escom.appplantas.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment{
    EditText txtNombreIn;
    Button btnBucar;

    @Override
    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle b) {
        View v = li.inflate(R.layout.catalogo, vg, false);
        btnBucar = getActivity().findViewById(R.id.btnBusc);
        txtNombreIn =  getActivity().findViewById(R.id.txtNomBus);


        btnBucar.setOnClickListener(new View.OnClickListener() {               //BOTON PARA SETEAR LA IMAGEN DE LA PLANTA
            @Override
            public void onClick(View view) {

        });

        return v;
    }
}