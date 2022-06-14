package edu.fiuba.algo3.modelo.Movimiento;

import edu.fiuba.algo3.modelo.Posicion;

public class Arriba implements Movimiento {
    public void mover(Posicion posicion){
        posicion.decrementarY();
    };
}

