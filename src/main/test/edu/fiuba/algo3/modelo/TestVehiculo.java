package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Fakes.VehiculoFake;
import edu.fiuba.algo3.modelo.Movimiento.Arriba;
import edu.fiuba.algo3.modelo.Movimiento.Derecha;
import edu.fiuba.algo3.modelo.Movimiento.Abajo;
import edu.fiuba.algo3.modelo.Movimiento.Izquierda;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.TodoTerreno;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestVehiculo {

    @Test
    public void autoCambiaDeVehiculoYDevuelveTodoTerreno(){
        Posicion pos = new Posicion(0, 0);
        VehiculoFake vehiculo = new VehiculoFake(pos, new Auto(pos));
        vehiculo.cambiarVehiculo();
        assertEquals(vehiculo.obtenerEstado().getClass(), new TodoTerreno(pos).getClass());
    }

    @Test
    public void motoCambiaDeVehiculoYDevuelveAuto(){
        Posicion pos = new Posicion(0, 0);
        VehiculoFake vehiculo = new VehiculoFake(pos, new Moto(pos));
        vehiculo.cambiarVehiculo();
        assertEquals(vehiculo.obtenerEstado().getClass(), new Auto(pos).getClass());
    }

    @Test
    public void todoTerrenoCambiaDeVehiculoYDevuelveMoto(){
        Posicion pos = new Posicion(0, 0);
        VehiculoFake vehiculo = new VehiculoFake(pos, new TodoTerreno(pos));
        vehiculo.cambiarVehiculo();
        assertEquals(vehiculo.obtenerEstado().getClass(), new Moto(pos).getClass());
    }

    @Test
    public void moverUnVehiculoHaciaDerechaDesdeElOrigenNoSeMueve(){
        Posicion pos = new Posicion(0, 0);
        VehiculoFake vehiculo = new VehiculoFake(pos, new Moto(pos));
        vehiculo.movermeHacia(new Derecha());
        assertEquals(pos,vehiculo.obtenerPosVehiculo());
    }

    @Test
    public void moverUnVehiculoHaciaDerechaDesdeOtroPuntoSeMueve(){
        Posicion pos = new Posicion(1, 1);
        VehiculoFake vehiculo = new VehiculoFake(pos, new Moto(pos));
        vehiculo.movermeHacia(new Derecha());
        Posicion posicionEsperada = new Posicion(2,1);
        assertEquals(posicionEsperada,vehiculo.obtenerPosVehiculo());
    }

    @Test
    public void moverUnVehiculoHaciaIzquierdaDesdeOtroPuntoSeMueve(){
        Posicion pos = new Posicion(1, 2);
        VehiculoFake vehiculo = new VehiculoFake(pos, new Moto(pos));
        vehiculo.movermeHacia(new Izquierda());
        Posicion posicionEsperada = new Posicion(0,2);
        assertEquals(posicionEsperada,vehiculo.obtenerPosVehiculo());
    }

    @Test
    public void moverHaciaArribaDesdeElOrigenNoSePuede(){
        Posicion pos = new Posicion(0, 0);
        VehiculoFake vehiculo = new VehiculoFake(pos, new Moto(pos));
        vehiculo.movermeHacia(new Arriba());
        assertEquals(pos,vehiculo.obtenerPosVehiculo());
    }

    @Test // ver caso borde en esquinas random con x=0
    public void moverHaciaArribaDesdeOtroPuntoSePuedeMover(){
        Posicion pos = new Posicion(1, 1);
        VehiculoFake vehiculo = new VehiculoFake(pos, new Moto(pos));
        vehiculo.movermeHacia(new Arriba());
        Posicion posicionEsperada = new Posicion(1,0);
        assertEquals(posicionEsperada,vehiculo.obtenerPosVehiculo());
    }

    @Test // ver caso borde en esquinas random
    public void moverHaciaAbajoDesdeElOrigenSeMueve(){
        Posicion pos = new Posicion(0, 0);
        VehiculoFake vehiculo = new VehiculoFake(pos, new Moto(pos));
        vehiculo.movermeHacia(new Abajo());
        Posicion posicionEsperada = new Posicion(0,1);
        assertEquals(posicionEsperada,vehiculo.obtenerPosVehiculo());
    }


}
