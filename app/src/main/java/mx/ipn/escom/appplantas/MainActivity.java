package mx.ipn.escom.appplantas;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import mx.ipn.escom.appplantas.Adaptadores.ListaPLantasAdapter;
import mx.ipn.escom.appplantas.DB.DBHelper;
import mx.ipn.escom.appplantas.DB.DBPlantas;
import mx.ipn.escom.appplantas.Entidades.Plantas;
import mx.ipn.escom.appplantas.databinding.ActivityMainBinding;
import mx.ipn.escom.appplantas.ui.nuevos.NuevoFragmento;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    RecyclerView ListaPlantas;
    ArrayList <Plantas> listaArrContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ListaPlantas = findViewById(R.id.RecViLista);
        ListaPlantas.setLayoutManager(new LinearLayoutManager(this));

        DBPlantas dbPlantas = new DBPlantas(MainActivity.this);

        listaArrContactos = new ArrayList<>();

        ListaPLantasAdapter adapter = new ListaPLantasAdapter(DBPlantas.mostrarPlantas());
        ListaPlantas.setAdapter(adapter);



        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        setSupportActionBar(binding.appBarMain.toolbar);
      /*  binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                setContentView(R.layout.nuevo_plnt);
            }
        });
*/
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery,R.id.nav_nuevo_plantas)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}