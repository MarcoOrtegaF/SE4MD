package mx.ipn.escom.appplantas.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import mx.ipn.escom.appplantas.Entidades.Plantas;
import mx.ipn.escom.appplantas.R;

public class ListaPLantasAdapter extends RecyclerView.Adapter<ListaPLantasAdapter.PlantasViewHolder> {

    ArrayList<Plantas> ListaPlantas;

    public ListaPLantasAdapter(ArrayList <Plantas> listaPlantas){
        this.ListaPlantas = listaPlantas;
    }

    @NonNull
    @Override
    public PlantasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_plantas, null,false);
        return new PlantasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlantasViewHolder holder, int position) {
        holder.viewID.setText(String.valueOf(ListaPlantas.get(position).getID()));
        holder.viewNombre.setText(String.valueOf(ListaPlantas.get(position).getNombre()));
        holder.viewEsp.setText(String.valueOf(ListaPlantas.get(position).getEspecie()));
        Picasso.get()                  //PROBAMOS QUE LA IMAGEN SI SE PUEDA UTILIZAR
                .load(ListaPlantas.get(position).getURL())
                .error(R.drawable.ic_launcher_background)
                .into(holder.viewImgPla);
    }

    @Override
    public int getItemCount() {
        return ListaPlantas.size();
    }

    public class PlantasViewHolder extends RecyclerView.ViewHolder {

        TextView viewID, viewNombre, viewEsp;
        ImageView viewImgPla;
        public PlantasViewHolder(@NonNull View itemView) {
            super(itemView);

            viewID = itemView.findViewById(R.id.txtIDSal);
            viewNombre = itemView.findViewById(R.id.txtNombre);
            viewEsp = itemView.findViewById(R.id.txtEsp);
            viewImgPla = itemView.findViewById(R.id.ImgViPLannta);
        }
    }
}
