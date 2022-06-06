package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Accionable;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Sorpresa.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.TodoTerreno;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import javafx.geometry.Pos;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestVehiculo {

    @Test
    public void autoCambiaDeVehiculoYDevuelveTodoTerreno(){
        Posicion pos = new Posicion(0,0);
        Vehiculo vehiculo = new Auto(pos);
        vehiculo = vehiculo.cambiarVehiculo();
        assertEquals(vehiculo.getClass(), new TodoTerreno(pos).getClass());
    }

    @Test
    public void motoCambiaDeVehiculoYDevuelveAuto(){
        Posicion pos = new Posicion(0,0);
        Vehiculo vehiculo = new Moto(pos);
        vehiculo = vehiculo.cambiarVehiculo();
        assertEquals(vehiculo.getClass(), new Auto(pos).getClass());
    }

    @Test
    public void todoTerrenoCambiaDeVehiculoYDevuelveMoto(){
        Posicion pos = new Posicion(0,0);
        Vehiculo vehiculo = new TodoTerreno(pos);
        vehiculo = vehiculo.cambiarVehiculo();
        assertEquals(vehiculo.getClass(), new Moto(pos).getClass());
    }

}
