package com.example.dm2.fragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.example.dm2.fragments.FragmentListado.PeliculaListener;



import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements PeliculaListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentListado frgListado = (FragmentListado) getSupportFragmentManager().findFragmentById(R.id.FrgListado);
        Log.e("OBJETO","HOLA");
        frgListado.setPeliculaListener(this); //ALGO VA MAL AQUI ??
    }

    @Override
    public void onPeliculaSeleccionada(Pelicula p) {
        //Miramos si hay un fragment detalle o no para iniciar sino la actividad detalle para moviles
        boolean hayDetalle=(getSupportFragmentManager().findFragmentById(R.id.FrgDetalle)!=null);
//        Log.e("WEEE","ESTO ES PELI SELECCIOANDA");
        if (hayDetalle){
            ((FragmentDetalle) getSupportFragmentManager().findFragmentById(R.id.FrgDetalle)).mostrarDetalle(p);
        }else{
            Intent intent=new Intent(this, Detalle_Activity.class);
            intent.putExtra("pelicula", (Serializable) p);
            startActivity(intent);
        }
    }
}
