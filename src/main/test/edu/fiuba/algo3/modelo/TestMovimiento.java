package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Movimiento.*;
import javafx.geometry.Pos;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestMovimiento {

    @Test
    public void movimientoDerechaIncrementaEnUnoLaCoordenadaX(){
        Movimiento mov = new Derecha();
        Posicion pos = new Posicion(1, 3);
        mov.mover(pos);
        assertEquals(2, pos.obtenerPosX());

    }

    @Test
    public void movimientoIzquierdaReduceEnUnoLaCoordenadaX(){
        Movimiento mov = new Izquierda();
        Posicion pos = new Posicion(1, 3);
        mov.mover(pos);
        assertEquals(0, pos.obtenerPosX());
    }

    @Test
    public void movimientoArribaReduceEnUnoLaCoordenadaY(){
        Movimiento mov = new Arriba();
        Posicion pos = new Posicion(1, 1);
        mov.mover(pos);
        assertEquals(0, pos.obtenerPosY());
    }
    @Test
    public void movimientoAbajoIncrementaEnUnoLaCoordenadaY(){
        Movimiento mov = new Abajo();
        Posicion pos = new Posicion(0, 0);
        mov.mover(pos);
        assertEquals(1, pos.obtenerPosY());
    }


}
