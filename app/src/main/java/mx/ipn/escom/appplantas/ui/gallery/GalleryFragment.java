package mx.ipn.escom.appplantas.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import mx.ipn.escom.appplantas.R;
import mx.ipn.escom.appplantas.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle b) {
        View v = li.inflate(R.layout.catalogo, vg, false);
        return v;
    }
}