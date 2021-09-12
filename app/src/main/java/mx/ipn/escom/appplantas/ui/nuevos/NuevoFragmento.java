package mx.ipn.escom.appplantas.ui.nuevos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import mx.ipn.escom.appplantas.R;

public class NuevoFragmento extends Fragment {
    @Override
    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle b) {
        View v = li.inflate(R.layout.nuevo_plnt, vg, false);
        return v;
    }
}