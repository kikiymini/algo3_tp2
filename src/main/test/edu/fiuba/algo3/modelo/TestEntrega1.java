package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Fakes.CiudadFake;
import edu.fiuba.algo3.modelo.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEntrega1 {

    @Test
    public void motoRealiza5MovimientosALaDerechaYSeEncuentraConUnPozo(){
        CiudadFake ciudad = new CiudadFake(new Moto(new Posicion(0, 0)));
        ciudad.ponerAccionableEnPosicion(1, 0, new Pozo());
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculoDerecha();
        }
        ArrayList<Integer> pos = ciudad.obtenerPosVehiculo();
        assertEquals(17, ciudad.obtenerCantidadDeMovVehiculo());// da mal
    }

}
