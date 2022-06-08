package edu.fiuba.algo3.modelo.Movimiento;

import edu.fiuba.algo3.modelo.Posicion;

public class Adelante implements Movimiento {
    public void movermeHacia(Posicion posicion){
        posicion.incrementarX();
    }
}
