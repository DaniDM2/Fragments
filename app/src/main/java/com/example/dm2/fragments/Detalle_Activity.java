package com.example.dm2.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Detalle_Activity extends AppCompatActivity {
    public static final String EXTRA_TEXTO="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        //Recogemos el elemto seleccioando
        FragmentDetalle detalle=(FragmentDetalle)getSupportFragmentManager().findFragmentById(R.id.FrgDetalle);
        Bundle extras= getIntent().getExtras();
        //Lo mostramos todo sobre la pelicula
        Pelicula p= (Pelicula) extras.getSerializable("pelicula");
        detalle.mostrarDetalle(p);
    }
}
