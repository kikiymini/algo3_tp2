package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Fakes.CiudadFake;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCiudad {

    @Test
    public void moverVehiculoDerecha(){
        CiudadFake ciudad = new CiudadFake();
        ciudad.setearVehiculoOrigen();
        ArrayList<Integer> pos = ciudad.obtenerPosVehiculo();
        System.out.println(pos.get(0));
        ciudad.moverVehiculoDerecha();
        assertEquals(3, pos.get(0));

    }
}
