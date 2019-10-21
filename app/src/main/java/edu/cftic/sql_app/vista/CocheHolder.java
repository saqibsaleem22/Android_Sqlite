package edu.cftic.sql_app.vista;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import edu.cftic.sql_app.R;
import edu.cftic.sql_app.dto.Coche;


public class CocheHolder extends RecyclerView.ViewHolder {

    private TextView text_id;
    private TextView text_modelo;


    public CocheHolder(View itemView) {

        super(itemView);
        text_id = (TextView)itemView.findViewById(R.id.id_coche);
        text_modelo = (TextView)itemView.findViewById(R.id.modelo_coche);

    }


    public void cargarCocheHolder(Coche coche) {
        Log.d("MIAPP", coche.getId() + " " + coche.getModelo());
        text_id.setText(coche.getId() + " ");
        text_modelo.setText(coche.getModelo());
    }
}
