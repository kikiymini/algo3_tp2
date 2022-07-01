package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Excepciones.NombreVacioError;

public class Jugador{

    private String nombre;
    protected Puntaje puntaje;

    public Jugador(String nombre){
        if( nombre.isEmpty() ){
            throw new NombreVacioError();
        }
        this.nombre = nombre;
        this.puntaje = new Puntaje();

    }

    public String obtenerNombre(){
        return this.nombre;
    }

    protected int calcularPuntaje(int movimientos){
        puntaje.calcularPuntaje(movimientos);
        return puntaje.obtenerPuntaje();
    }

    public int puntajeObtenido(){
        return puntaje.obtenerPuntaje();
    }
}
