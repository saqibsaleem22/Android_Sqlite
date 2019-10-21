package edu.cftic.sql_app.vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import edu.cftic.sql_app.R;
import edu.cftic.sql_app.dao.BaseDatosCochesPersona;
import edu.cftic.sql_app.dto.Coche;
import edu.cftic.sql_app.dto.Persona;

public class MainActivity extends AppCompatActivity {

    private BaseDatosCochesPersona baseDatosCochesPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //truquillo para saber si la base de datos existe
        File dbpath = getDatabasePath("MiDB");
        boolean existe_bd = dbpath.exists();
        Button boton_mostrar = findViewById(R.id.butonmostrar);
        boton_mostrar.setEnabled(dbpath.exists());
    }

    public void cargarDatos(View view) {

        //creo el objeto de la base de datos
        this.baseDatosCochesPersona = new BaseDatosCochesPersona(this, "MiDB", null, 1);

        Persona persona1 = new Persona(1, "Juan");
        Persona persona2 = new Persona(2, "Conchi");
        Persona persona3 = new Persona(3, "Manolo");

        //inserto las personas
        baseDatosCochesPersona.insertarPersona(persona1);
        baseDatosCochesPersona.insertarPersona(persona2);
        baseDatosCochesPersona.insertarPersona(persona3);

        Coche coche1 = new Coche("Ferrari", persona2);
        Coche coche2 = new Coche("Renault", persona2);
        Coche coche3 = new Coche("Fiat", persona1);

        //inserto los coches
        baseDatosCochesPersona.insertarCoche(coche1);
        baseDatosCochesPersona.insertarCoche(coche2);
        baseDatosCochesPersona.insertarCoche(coche3);

        //TODO cojer el botón de mostrar y habilitarlo
        Button boton_mostrar = findViewById(R.id.butonmostrar);
        boton_mostrar.setEnabled(true);


    }

    public void mostrarDatos(View view) {

        Intent intent = new Intent(this, MuestraCochesActivity.class);
        startActivity(intent);

    }


}
