package edu.cftic.sql_app.vista;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.cftic.sql_app.R;

import edu.cftic.sql_app.dao.BaseDatosCochesPersona;
import edu.cftic.sql_app.dto.Coche;

public class MuestraCochesActivity extends AppCompatActivity {


    private AdapterCoche adapterCoche;
    private RecyclerView recyclerView;
    private List<Coche> lista_coches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_coches);

        BaseDatosCochesPersona baseDatosCochesPersona = new BaseDatosCochesPersona(this, "MiDB", null, 1);
        lista_coches = baseDatosCochesPersona.buscarCoches();

        adapterCoche = new AdapterCoche(lista_coches);
        recyclerView = findViewById(R.id.recicler);
        recyclerView.setAdapter(adapterCoche);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //recView.setLayoutManager(new GridLayoutManager(this,3));
        //StaggeredGridLayoutManager para celdas de tamaño variable
        //recView.setLayoutManager(new StaggeredGridLayoutManager());


        //ITEM DECORATOR --> OPCIONAL

        recyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }


    public void ordenarPorId(View view) {

        Log.d("MIAPP","ORDENANDO POR ID");
        Collections.sort(lista_coches, new ComparadorCoches());
        //repintar
       // adapterCoche = new AdapterCoche(lista_coches);
       // recyclerView.setAdapter(adapterCoche);
        //repintar PEREA
        adapterCoche.notifyDataSetChanged();
    }

    public void ordenarPorModelo(View view) {

        Log.d("MIAPP","ORDENANDO POR MODELO");
        Collections.sort(lista_coches);
        adapterCoche = new AdapterCoche(lista_coches);
        recyclerView.setAdapter(adapterCoche);
    }

    /*private void obtenerCorreos ()
    {
        AccountManager accountManager = (AccountManager) getSystemService(ACCOUNT_SERVICE);
        Account[] lista_cuentas = accountManager.getAccounts();

        for (Account cuenta : lista_cuentas)
        {
            Log.d(getClass().getCanonicalName(), " Cuenta = " + cuenta.name);

            if (cuenta.type.equals("com.google")) //si la cuenta es de gmail
            {
                str_aux = str_aux + cuenta.name+",";
            }
        }


    }*/
}
