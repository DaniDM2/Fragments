package com.example.dm2.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by dm2 on 08/11/2017.
 */

public class FragmentListado extends Fragment{

    private Pelicula[] peliculas=new Pelicula[]{new Pelicula("El planeta de los simios","Franklin Schaffner",1998,120),
        new Pelicula("Bajo el planeta de los simios","Ted Post",1970,160),
        new Pelicula("Ben-Hur","William Wyler",1960,180),
        new Pelicula("Quo vadis","Mervyn LeRoy",1951,300)};
    public Pelicula[] getPeliculas() {
        return peliculas;
    }


    private ListView listado;

    private PeliculaListener listener;


//    Inflamos la lista
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listado, container, false);
    }


    //Recogemos la lista al lanzar la actividad
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listado=(ListView)getView().findViewById(R.id.ListadoPelis);
        listado.setAdapter(new AdaptadorPeliculas(this));

        //Creamos el listener para escuchar los eventos de la lista
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (listener!=null){
                    listener.onPeliculaSeleccionada((Pelicula) listado.getAdapter().getItem(position));
                }
            }
        });
    }



    //Creamo el adaptador de la lista de peliculas
    class AdaptadorPeliculas extends ArrayAdapter<Pelicula>{

        Activity context;

        AdaptadorPeliculas(Fragment context){
            super(context.getActivity(), R.layout.listaitem_pelicula, peliculas);
            this.context=context.getActivity();
        }


        public View getView(int position,  View convertView,  ViewGroup parent) {
            LayoutInflater inflater=context.getLayoutInflater();
            View item= inflater.inflate(R.layout.listaitem_pelicula,null);

            TextView titulo= (TextView)item.findViewById(R.id.Titulo);
            titulo.setText(peliculas[position].getTitulo());

            TextView director=(TextView)item.findViewById(R.id.Director);
            director.setText(peliculas[position].getDirector());

            return (item);
        }
    }

    //Esto no entiendo muy bien por qué....
    public interface PeliculaListener {
        void onPeliculaSeleccionada(Pelicula p);
    }

   public void setPeliculaListener(PeliculaListener pLis){
       Log.e("setPeliculaListener","BUENOOOOO A VER QUE PASAAQA");
       this.listener=pLis;
    }
}



