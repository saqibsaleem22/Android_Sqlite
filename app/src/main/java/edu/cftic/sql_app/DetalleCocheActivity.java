package edu.cftic.sql_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import edu.cftic.sql_app.dto.Coche;

public class DetalleCocheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_coche);

        Coche coche = getIntent().getParcelableExtra("coche");
        TextView tv1 = findViewById(R.id.id_coche_detalle);
        TextView tv2 = findViewById(R.id.modelo_coche_detalle);
        tv1.setText(coche.getId()+"");
        tv2.setText(coche.getModelo());

    }
}
