package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Fakes.CiudadFake;
import edu.fiuba.algo3.modelo.Movimiento.Derecha;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCiudad {

    @Test
    public void moverVehiculoDerecha(){
        CiudadFake ciudad = new CiudadFake();
        ciudad.setearVehiculoOrigen();
        ciudad.moverVehiculoDerecha();
        Derecha derecha = new Derecha();
        int posX = ciudad.obtenerPosVehiculoEnX();
        assertEquals(3, posX);
    }
    @Test
    public void moverVehiculoIzquierda(){
        CiudadFake ciudad = new CiudadFake();
        ciudad.setearVehiculoEn(3, 0);
        ciudad.moverVehiculoIzquierda();
        int posX = ciudad.obtenerPosVehiculoEnX();
        assertEquals(0, posX);
    }

    @Test
    public void moverVehiculoAbajo(){
        CiudadFake ciudad = new CiudadFake();
        ciudad.setearVehiculoEn(0, 0);
        ciudad.moverVehiculoAbajo();
        int posY = ciudad.obtenerPosVehiculoEnY();
        assertEquals(3, posY);
    }

    @Test
    public void moverVehiculoAriba(){
        CiudadFake ciudad = new CiudadFake();
        ciudad.setearVehiculoEn(0, 3);
        ciudad.moverVehiculoArriba();
        int posY = ciudad.obtenerPosVehiculoEnY();
        assertEquals(0, posY);
    }

}
