package mx.ipn.escom.appplantas.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import mx.ipn.escom.appplantas.R;
import mx.ipn.escom.appplantas.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle b) {
        View v = li.inflate(R.layout.mis_plantas, vg, false);
        return v;
    }
}