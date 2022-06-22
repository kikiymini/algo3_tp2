package edu.fiuba.algo3.modelo.Entrega1;

import edu.fiuba.algo3.modelo.Fakes.CiudadFake;
import edu.fiuba.algo3.modelo.Fakes.VehiculoFake;
import edu.fiuba.algo3.modelo.Movimiento.Abajo;
import edu.fiuba.algo3.modelo.Movimiento.Derecha;
import edu.fiuba.algo3.modelo.Obstaculo.Piquete;
import edu.fiuba.algo3.modelo.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.TodoTerreno;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEntrega1 {

    @Test
    public void motoRealiza5MovimientosALaDerechaYSeEncuentraConUnPozo(){
        Posicion pos = new Posicion(0, 0);
        CiudadFake ciudad = new CiudadFake(new VehiculoFake(pos, new Moto(pos)));
        ciudad.ponerAccionableEnPosicion(1, 0, new Pozo());
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculo(new Derecha());
        }
        assertEquals(8, ciudad.obtenerCantidadDeMovVehiculo());

    }

    @Test
    public void motoAtraviesaGrillaALoAnchoSinObstaculos(){
        Posicion pos = new Posicion(0, 0);
        CiudadFake ciudad = new CiudadFake(new VehiculoFake(pos, new Moto(pos)));
        int anchoGrilla = (ciudad.obtenerAnchoCiudad()/3) - 1;
        for(int i = 0; i < (anchoGrilla); i++){
            ciudad.moverVehiculo(new Derecha());
        }
        assertEquals(anchoGrilla, ciudad.obtenerCantidadDeMovVehiculo());
    }

    @Test
    public void motoAtraviesaGrillaALoLargoSinObstaculos(){
        Posicion pos = new Posicion(0, 0);
        CiudadFake ciudad = new CiudadFake(new VehiculoFake(pos, new Moto(pos)));
        int largoGrilla = (ciudad.obtenerLargoCiudad()/3) - 1;
        for(int i = 0; i < largoGrilla; i++){
            ciudad.moverVehiculo(new Abajo());
        }
        assertEquals(largoGrilla, ciudad.obtenerCantidadDeMovVehiculo());
    }
    @Test
    public void autoRealiza5MovimientosALaDerechaYSeEncuentraConUnPozo(){
        Posicion pos = new Posicion(0, 0);
        CiudadFake ciudad = new CiudadFake(new VehiculoFake(pos, new Moto(pos)));
        ciudad.ponerAccionableEnPosicion(1, 0, new Pozo());
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculo(new Derecha());
        }
        assertEquals(8, ciudad.obtenerCantidadDeMovVehiculo());
    }
    @Test
    public void todoTerrenoRealiza5MovimientosALaDerechaYSeEncuentraConUnPozoYnoEsPenalizado(){
        Posicion pos = new Posicion(0, 0);
        CiudadFake ciudad = new CiudadFake(new VehiculoFake(pos, new TodoTerreno(pos)));
        ciudad.ponerAccionableEnPosicion(1, 0, new Pozo());
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculo(new Derecha());
        }
        assertEquals(5, ciudad.obtenerCantidadDeMovVehiculo());

    }
    @Test
    public void todoTerrenoRealiza5MovimientosALaDerechaYSeEncuentraConTresPozosYEsPenalizado(){
        Posicion pos = new Posicion(0, 0);
        CiudadFake ciudad = new CiudadFake(new VehiculoFake(pos, new TodoTerreno(pos)));
        for(int i = 1; i< 5; i++){
            if (i % 3 != 0) {
                ciudad.ponerAccionableEnPosicion(i, 0, new Pozo());
            }
        }
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculo(new Derecha());
        }

        assertEquals(7, ciudad.obtenerCantidadDeMovVehiculo());

    }

    @Test
    public void motoRealiza5MovimientosYSeCruzaConUnPiquetePenalizaDosMovimientos(){
        Posicion pos = new Posicion(0, 0);
        CiudadFake ciudad = new CiudadFake(new VehiculoFake(pos, new Moto(pos)));
        ciudad.ponerAccionableEnPosicion(1, 0, new Piquete());
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculo(new Derecha());
        }
        assertEquals(7, ciudad.obtenerCantidadDeMovVehiculo());
    }

    @Test
    public void autoRealiza5MovimientosYSeCruzaConUnPiqueteNoPuedePasar(){
        Posicion pos = new Posicion(0, 0);
        CiudadFake ciudad = new CiudadFake(new VehiculoFake(pos, new Auto(pos)));
        ciudad.ponerAccionableEnPosicion(14, 0, new Piquete()); //ver pos con cambio de esquina

        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculo(new Derecha());
        }

        assertEquals(4, ciudad.obtenerCantidadDeMovVehiculo());

    }
}
