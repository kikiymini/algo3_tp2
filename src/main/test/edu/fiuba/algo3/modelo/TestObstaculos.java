package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Fakes.CiudadFake;
import edu.fiuba.algo3.modelo.Fakes.VehiculoFake;
import edu.fiuba.algo3.modelo.Obstaculo.Piquete;
import edu.fiuba.algo3.modelo.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Sorpresa.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.TodoTerreno;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestObstaculos {
    @Test
    public void Test01MotoPisaUnPozoSeIncrementan3Movimientos(){
        Posicion pos = new Posicion(0, 0);
        VehiculoFake vehiculo = new VehiculoFake(pos, new Moto(pos));
        Pozo pozo = new Pozo();
        pozo.accionar(vehiculo);
        assertEquals(3,vehiculo.cantidadDeMovimientos());
    }

    @Test
    public void Tes03MotoPisaUnAccionablePozoYLeSuma3Movimientos(){
        Posicion pos = new Posicion(0, 0);
        VehiculoFake vehiculo = new VehiculoFake(pos, new Moto(pos));
        Accionable pozo = new Pozo();
        pozo.accionar(vehiculo);
        assertEquals(3, vehiculo.cantidadDeMovimientos());
    }

    @Test
    public void Test04MotoPisaUnAccionablePozo2VecesYLeSuma6Movimientos(){
        Posicion pos = new Posicion(0, 0);
        VehiculoFake vehiculo = new VehiculoFake(pos, new Moto(pos));
        Accionable pozo = new Pozo();
        pozo.accionar(vehiculo);
        pozo.accionar(vehiculo);
        assertEquals(6, vehiculo.cantidadDeMovimientos());
    }

    @Test
    public void Test05AutoPisaUnPozoYLeSuma3Movimientos(){
        Posicion pos = new Posicion(0, 0);
        VehiculoFake vehiculo = new VehiculoFake(pos, new Auto(pos));
        Accionable pozo = new Pozo();
        pozo.accionar(vehiculo);
        assertEquals(3, vehiculo.cantidadDeMovimientos());
    }

    @Test
    public void Test06AutoPisaUnPozoDosVecesYLeSuma6Movimientos(){
        Posicion pos = new Posicion(0, 0);
        VehiculoFake vehiculo = new VehiculoFake(pos, new Auto(pos));
        Accionable pozo = new Pozo();
        pozo.accionar(vehiculo);
        pozo.accionar(vehiculo);
        assertEquals(6, vehiculo.cantidadDeMovimientos());
    }
    @Test
    public void Tes07MotoSeEncuentraUnPiqueteYLeSuma2Movimientos(){
        Posicion pos = new Posicion(0, 0);
        VehiculoFake vehiculo = new VehiculoFake(pos, new Moto(pos));
        Accionable piquete = new Piquete();
        piquete.accionar(vehiculo);
        assertEquals(2, vehiculo.cantidadDeMovimientos());
    }

}
