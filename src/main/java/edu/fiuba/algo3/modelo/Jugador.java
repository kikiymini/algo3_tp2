package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Excepciones.NombreVacioError;

public class Jugador{

    private String nombre;
    protected int cantMovimientos;
    protected Puntaje puntaje;

    public Jugador(String nombre){
        if( nombre.isEmpty() ){
            throw new NombreVacioError();
        }
        this.nombre = nombre;
        this.cantMovimientos = 0;
        this.puntaje = new Puntaje();

    }

    public String obtenerNombre(){
        return this.nombre;
    }

    protected int puntajeObtenido(){
        return puntaje.obtenerPuntaje();
    }

    public void sumarMovimiento() {
        cantMovimientos++;
    }
}
