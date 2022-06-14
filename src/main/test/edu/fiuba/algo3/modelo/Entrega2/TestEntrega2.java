package edu.fiuba.algo3.modelo.Entrega2;

import edu.fiuba.algo3.modelo.Fakes.CiudadFake;
import edu.fiuba.algo3.modelo.Movimiento.Derecha;
import edu.fiuba.algo3.modelo.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Sorpresa.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.Sorpresa.Desfavorable;
import edu.fiuba.algo3.modelo.Sorpresa.Favorable;
import edu.fiuba.algo3.modelo.TestPosicion;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.TodoTerreno;
import javafx.geometry.Pos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEntrega2 {

    @Test
    public void autoAtraviesaLaCiudadYSeEncuentraUnaSorpresaFavorable(){
        CiudadFake ciudad = new CiudadFake(new Auto(new Posicion(0, 0)));
        ciudad.ponerAccionableEnPosicion(14, 0, new Favorable());
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculo(new Derecha());
        }
        assertEquals(4, ciudad.obtenerCantidadDeMovVehiculo());
    }

    @Test
    public void motoAtraviesaLaCiudadYSeEncuentraUnaSorpresaFavorable(){
        CiudadFake ciudad = new CiudadFake(new Moto(new Posicion(0, 0)));
        ciudad.ponerAccionableEnPosicion(14, 0, new Favorable());
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculo(new Derecha());
        }
        assertEquals(4, ciudad.obtenerCantidadDeMovVehiculo());
    }

    @Test
    public void todoTerrenoAtraviesaLaCiudadYSeEncuentraUnaSorpresaFavorable(){
        CiudadFake ciudad = new CiudadFake(new TodoTerreno(new Posicion(0, 0)));
        ciudad.ponerAccionableEnPosicion(14, 0, new Favorable());
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculo(new Derecha());
        }
        assertEquals(4, ciudad.obtenerCantidadDeMovVehiculo());
    }

    @Test
    public void autoAtraviesaLaCiudadYSeEncuentraUnaSorpresaDesfavorable(){
        CiudadFake ciudad = new CiudadFake(new Auto(new Posicion(0, 0)));
        ciudad.ponerAccionableEnPosicion(14, 0, new Desfavorable());
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculo(new Derecha());
        }
        assertEquals(6, ciudad.obtenerCantidadDeMovVehiculo());
    }

    @Test
    public void motoAtraviesaLaCiudadYSeEncuentraUnaSorpresaDesfavorable(){
        CiudadFake ciudad = new CiudadFake(new Moto(new Posicion(0, 0)));
        ciudad.ponerAccionableEnPosicion(14, 0, new Desfavorable());
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculo(new Derecha());
        }
        assertEquals(6, ciudad.obtenerCantidadDeMovVehiculo());
    }

    @Test
    public void todoTerrenoAtraviesaLaCiudadYSeEncuentraUnaSorpresaDesfavorable(){
        CiudadFake ciudad = new CiudadFake(new TodoTerreno(new Posicion(0, 0)));
        ciudad.ponerAccionableEnPosicion(14, 0, new Desfavorable());
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculo(new Derecha());
        }
        assertEquals(6, ciudad.obtenerCantidadDeMovVehiculo());
    }

    @Test
    public void autoAtraviesaLaCiudadYSeEncuentraUnaCambioDeVehiculoYSeTransformaEnTodoTerreno(){
        CiudadFake ciudad = new CiudadFake(new Auto(new Posicion(0, 0)));
        ciudad.ponerAccionableEnPosicion(14, 0, new CambioDeVehiculo());
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculo(new Derecha());
        }
        assertEquals(new TodoTerreno(new Posicion(0, 0)).getClass(), ciudad.obtenerVehiculo().getClass());
    }

    @Test
    public void motoAtraviesaLaCiudadYSeEncuentraUnaCambioDeVehiculoYSeTransformaEnAuto(){
        CiudadFake ciudad = new CiudadFake(new Moto(new Posicion(0, 0)));
        ciudad.ponerAccionableEnPosicion(14, 0, new CambioDeVehiculo());
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculo(new Derecha());
        }
        assertEquals(new Auto(new Posicion(0, 0)).getClass(), ciudad.obtenerVehiculo().getClass());
    }

    @Test
    public void todoTerrenoAtraviesaLaCiudadYSeEncuentraUnaCambioDeVehiculoYSeTransformaEnMoto(){
        CiudadFake ciudad = new CiudadFake(new TodoTerreno(new Posicion(0, 0)));
        ciudad.ponerAccionableEnPosicion(14, 0, new CambioDeVehiculo());
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculo(new Derecha());
        }
        assertEquals(new Moto(new Posicion(0, 0)).getClass(), ciudad.obtenerVehiculo().getClass());
    }



}
