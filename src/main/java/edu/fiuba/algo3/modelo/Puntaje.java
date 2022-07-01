package edu.fiuba.algo3.modelo;

public class Puntaje {

    private int puntaje;

    public Puntaje(){
        this.puntaje = 0;
    }

    public Puntaje(int puntaje) {
        this.puntaje = puntaje;

    }

    public void calcularPuntaje(int movimientos){
        puntaje = movimientos;
    }

    public int obtenerPuntaje(){
        return puntaje;
    }
}
