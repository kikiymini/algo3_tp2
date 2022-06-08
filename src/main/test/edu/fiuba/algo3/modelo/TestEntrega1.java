package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Fakes.CiudadFake;
import edu.fiuba.algo3.modelo.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.TodoTerreno;
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
        assertEquals(17, ciudad.obtenerCantidadDeMovVehiculo());
    }

    @Test
    public void autoRealiza5MovimientosALaDerechaYSeEncuentraConUnPozo(){
        CiudadFake ciudad = new CiudadFake(new Auto(new Posicion(0, 0)));
        ciudad.ponerAccionableEnPosicion(1, 0, new Pozo());
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculoDerecha();
        }
        ArrayList<Integer> pos = ciudad.obtenerPosVehiculo();
        assertEquals(17, ciudad.obtenerCantidadDeMovVehiculo());
    }
    @Test
    public void todoTerrenoRealiza5MovimientosALaDerechaYSeEncuentraConUnPozoYnoEsPenalizado(){
        CiudadFake ciudad = new CiudadFake(new TodoTerreno(new Posicion(0, 0)));
        ciudad.ponerAccionableEnPosicion(1, 0, new Pozo());
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculoDerecha();
        }
        ArrayList<Integer> pos = ciudad.obtenerPosVehiculo();
        assertEquals(15, ciudad.obtenerCantidadDeMovVehiculo());
    }
    @Test
    public void todoTerrenoRealiza5MovimientosALaDerechaYSeEncuentraConTresPozosYEsPenalizado(){
        CiudadFake ciudad = new CiudadFake(new TodoTerreno(new Posicion(0, 0)));
        ciudad.ponerAccionableEnPosicion(1, 0, new Pozo());
        for(int i = 0; i< 3; i++){
            ciudad.ponerAccionableEnPosicion(i + 1, 0, new Pozo());
        }
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculoDerecha();
        }
        ArrayList<Integer> pos = ciudad.obtenerPosVehiculo();
        assertEquals(16, ciudad.obtenerCantidadDeMovVehiculo());
    }

}
