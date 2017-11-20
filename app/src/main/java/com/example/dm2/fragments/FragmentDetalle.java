package com.example.dm2.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by dm2 on 10/11/2017.
 */

public class FragmentDetalle extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detalle,container,false);
    }

    public void mostrarDetalle(Pelicula p){
        TextView txtTitulo= (TextView)getView().findViewById(R.id.Titulo);
        txtTitulo.setText(p.getTitulo());

        TextView txtDirector=(TextView)getView().findViewById(R.id.Director);
        txtDirector.setText(txtDirector.getText()+" "+p.getDirector());

        TextView txtAño=(TextView)getView().findViewById(R.id.año);
        txtAño.setText(txtAño.getText()+" "+p.getAño());

        TextView txtDuracion=(TextView)getView().findViewById(R.id.Duracion);
        txtDuracion.setText(txtDuracion.getText()+" "+p.getDuracion()+" mins");
    }
}
