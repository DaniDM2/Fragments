package com.example.dm2.fragments;

import android.util.Log;

import java.io.Serializable;

/**
 * Created by dm2 on 08/11/2017.
 */

public class Pelicula implements Serializable{
    private String titulo,director;
    private int duracion,año;

    public Pelicula(String titulo, String director, int duracion, int año) {
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
        this.año = año;
        Log.e("WEEE","SOoy una peli");
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getAño() {
        return año;
    }
}
