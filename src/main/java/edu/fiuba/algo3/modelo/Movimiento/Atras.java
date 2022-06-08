package edu.fiuba.algo3.modelo.Movimiento;

import edu.fiuba.algo3.modelo.Posicion;

public class Atras implements Movimiento {
        public void movermeHacia(Posicion posicion){
                posicion.decrementarX();
        }
}
