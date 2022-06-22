package edu.fiuba.algo3.modelo.Movimiento;

import edu.fiuba.algo3.modelo.Posicion;

public class Derecha implements Movimiento {
    public void mover(Posicion posicion){
        posicion.incrementarX();
    };
}
