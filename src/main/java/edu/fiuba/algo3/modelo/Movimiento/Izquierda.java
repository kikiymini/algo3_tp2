package edu.fiuba.algo3.modelo.Movimiento;

import edu.fiuba.algo3.modelo.Posicion;

public class Izquierda  implements Movimiento {
    public void movermeHacia(Posicion posicion){
        posicion.incrementarY();
    }
}
