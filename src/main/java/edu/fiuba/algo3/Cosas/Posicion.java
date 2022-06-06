package edu.fiuba.algo3.Cosas;

public class Posicion {

    private int x; //ver
    private int y;
    private boolean ocupado = false;

    public void ocupar() {
        ocupado = true;
    }
    public boolean devolverEstado(){
        return ocupado;
    }
}
