package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Fakes.CiudadFake;
import edu.fiuba.algo3.modelo.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEntrega1 {

    @Test
    public void motorealiza5MovimientosALaDerechaYSeEncuentraConUnPozo(){
        CiudadFake ciudad = new CiudadFake();
        ciudad.setearVehiculoOrigen();
        ciudad.colocarCallesEnGrilla();
        ciudad.ponerAccionableEnPosicion(15, 0, new Pozo());
        for (int i = 0; i < 5 ; i++){
            ciudad.moverVehiculoDerecha();
        }
        assertEquals(45, ciudad.obtenerCantidadDeMovVehiculo());// da mal
    }
}
