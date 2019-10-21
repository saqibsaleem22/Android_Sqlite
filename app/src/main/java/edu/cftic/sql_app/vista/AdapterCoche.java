package edu.cftic.sql_app.vista;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import edu.cftic.sql_app.DetalleCocheActivity;
import edu.cftic.sql_app.R;
import edu.cftic.sql_app.dto.Coche;

/**
 * ESTA CLASE PROVEE LOS DATOS AL RECYCLER
 */
public class AdapterCoche extends RecyclerView.Adapter<CocheHolder> implements View.OnClickListener {

//PA GUARDAR LA LISTA DE LIBROS
    private List<Coche> datos;


    //Creo la vista, con el Holder dentro
    //aquí estoy creando cada elemento de la lista
    @Override
    public CocheHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CocheHolder cocheHolder = null;

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.layout_coche_item, parent, false);
        itemView.setOnClickListener(this);//asociaría el listener
        cocheHolder = new CocheHolder(itemView);

        return cocheHolder;
    }
    //Al holder, le meto la info de libro que toca
    @Override
    public void onBindViewHolder(CocheHolder holder, int position) {
//relleno la fila
        Coche coche = datos.get(position);
        holder.cargarCocheHolder(coche);
        holder.itemView.setTag(position);//en la fila, indico el número
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public AdapterCoche(List<Coche> coches)
    {
        this.datos = coches;
    }


    @Override
    public void onClick(View view) {
        Log.d("MIAPP", "Se ha tocado un elemento de lista");
        int posicion_tocada = (int)view.getTag();//así ya lo sé
        Coche coche_seleccionado = datos.get(posicion_tocada);
        Log.d("MIAPP", "COCHE TOCADO " + coche_seleccionado.toString());
        Intent intent = new Intent(view.getContext(), DetalleCocheActivity.class);
        intent.putExtra("coche", coche_seleccionado);
        view.getContext().startActivity(intent);
    }
}
