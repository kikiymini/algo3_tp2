package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Accionable;
import edu.fiuba.algo3.modelo.Fakes.CiudadFake;
import edu.fiuba.algo3.modelo.Fakes.VehiculoFake;
import edu.fiuba.algo3.modelo.Movimiento.Derecha;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Sorpresa.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.Sorpresa.Desfavorable;
import edu.fiuba.algo3.modelo.Sorpresa.Favorable;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.TodoTerreno;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSorpresas {
    @Test
    public void Test01MotoPisaUnaSorpresaFavorableSinNingunMovimiento(){
        Posicion pos = new Posicion(0, 0);
        VehiculoFake vehiculo = new VehiculoFake(pos, new Moto(pos));
        Accionable favorable = new Favorable();
        favorable.accionar(vehiculo);
        assertEquals(0, vehiculo.cantidadDeMovimientos());
    }

    @Test
    public void Test02MotoPisaUnaSorpresaFavorableDespuesDeHacer10Movimientos(){
        Posicion pos = new Posicion(0, 0);
        VehiculoFake vehiculo = new VehiculoFake(pos, new Moto(pos));
        vehiculo.setearCantidadDeMovimientos(10);
        Accionable favorable = new Favorable();
        favorable.accionar(vehiculo);
        assertEquals(8, vehiculo.cantidadDeMovimientos());
    }

    @Test
    public void Test03AutoPisaUnaSorpresaFavorableSinNingunMovimiento(){
        Posicion pos = new Posicion(0, 0);
        VehiculoFake vehiculo = new VehiculoFake(pos, new Auto(pos));
        Accionable favorable = new Favorable();
        favorable.accionar(vehiculo);
        assertEquals(0, vehiculo.cantidadDeMovimientos());
    }

    @Test
    public void Test04AutoPisaUnaSorpresaFavorableDespuesDeHacer10Movimientos(){
        Posicion pos = new Posicion(0, 0);
        VehiculoFake vehiculo = new VehiculoFake(pos, new Auto(pos));
        vehiculo.setearCantidadDeMovimientos(10);
        Accionable favorable = new Favorable();
        favorable.accionar(vehiculo);
        assertEquals(8, vehiculo.cantidadDeMovimientos());
    }

    @Test
    public void Test05TodoTerrenoPisaUnaSorpresaFavorableSinNingunMovimiento(){
        Posicion pos = new Posicion(0, 0);
        VehiculoFake vehiculo = new VehiculoFake(pos, new TodoTerreno(pos));
        Accionable favorable = new Favorable();
        favorable.accionar(vehiculo);
        assertEquals(0, vehiculo.cantidadDeMovimientos());
    }

    @Test
    public void Test06TodoTerrenoPisaUnaSorpresaFavorableDespuesDeHacer10Movimientos(){
        Posicion pos = new Posicion(0, 0);
        VehiculoFake vehiculo = new VehiculoFake(pos, new TodoTerreno(pos));
        vehiculo.setearCantidadDeMovimientos(10);
        Accionable favorable = new Favorable();
        favorable.accionar(vehiculo);
        assertEquals(8, vehiculo.cantidadDeMovimientos());
    }

    @Test
    public void Test07MotoPisaUnaSorpresaDesfavorableSinNingunMovimiento(){
        Posicion pos = new Posicion(0, 0);
        VehiculoFake vehiculo = new VehiculoFake(pos, new Moto(pos));
        Accionable desfavorable = new Desfavorable();
        desfavorable.accionar(vehiculo);
        assertEquals(0, vehiculo.cantidadDeMovimientos());
    }

    @Test
    public void Test08MotoPisaUnaSorpresaDesfavorableDespuesDeHacer10Movimientos(){
        Posicion pos = new Posicion(0, 0);
        VehiculoFake vehiculo = new VehiculoFake(pos, new Moto(pos));
        vehiculo.setearCantidadDeMovimientos(10);
        Accionable desfavorable = new Desfavorable();
        desfavorable.accionar(vehiculo);
        assertEquals(12, vehiculo.cantidadDeMovimientos());
    }

    @Test
    public void Test09AutoPisaUnaSorpresaDesfavorableSinNingunMovimiento(){
        Posicion pos = new Posicion(0, 0);
        VehiculoFake vehiculo = new VehiculoFake(pos, new Auto(pos));
        Accionable desfavorable = new Desfavorable();
        desfavorable.accionar(vehiculo);
        assertEquals(0, vehiculo.cantidadDeMovimientos());
    }

    @Test
    public void Test10AutoPisaUnaSorpresaDesfavorableDespuesDeHacer10Movimientos(){
        Posicion pos = new Posicion(0, 0);
        VehiculoFake vehiculo = new VehiculoFake(pos, new Auto(pos));
        vehiculo.setearCantidadDeMovimientos(10);
        Accionable desfavorable = new Desfavorable();
        desfavorable.accionar(vehiculo);
        assertEquals(12, vehiculo.cantidadDeMovimientos());
    }

    @Test
    public void Test11TodoTerrenoPisaUnaSorpresaDesfavorableSinNingunMovimiento(){
        Posicion pos = new Posicion(0, 0);
        VehiculoFake vehiculo = new VehiculoFake(pos, new TodoTerreno(pos));
        Accionable desfavorable = new Desfavorable();
        desfavorable.accionar(vehiculo);
        assertEquals(0, vehiculo.cantidadDeMovimientos());
    }

    @Test
    public void Test12TodoTerrenoPisaUnaSorpresaDesfavorableDespuesDeHacer10Movimientos(){
        Posicion pos = new Posicion(0, 0);
        VehiculoFake vehiculo = new VehiculoFake(pos, new TodoTerreno(pos));
        vehiculo.setearCantidadDeMovimientos(10);
        Accionable desfavorable = new Desfavorable();
        desfavorable.accionar(vehiculo);
        assertEquals(12, vehiculo.cantidadDeMovimientos());
    }

    @Test
    public void autoAtraviesaLaCiudadYSeEncuentraUnaCambioDeVehiculoSeTransformaEnTodoTerrenoQuedaConMismosMovimientos(){
        Posicion pos = new Posicion(0, 0);
        VehiculoFake vehiculo = new VehiculoFake(pos, new Auto(pos));
        CiudadFake ciudad = new CiudadFake(vehiculo);
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculo(new Derecha());
        }
        assertEquals(5, ciudad.obtenerCantidadDeMovVehiculo());
    }

    @Test
    public void motoAtraviesaLaCiudadYSeEncuentraUnaCambioDeVehiculoYSeTransformaEnAutoQuedaConMismosMovimientos(){
        Posicion pos = new Posicion(0, 0);
        VehiculoFake vehiculo = new VehiculoFake(pos, new Auto(pos));
        CiudadFake ciudad = new CiudadFake(vehiculo);
        ciudad.ponerAccionableEnPosicion(14, 0, new CambioDeVehiculo());
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculo(new Derecha());
        }
        assertEquals(5, ciudad.obtenerCantidadDeMovVehiculo());
    }

    @Test
    public void todoTerrenoAtraviesaLaCiudadYSeEncuentraUnaCambioDeVehiculoYSeTransformaEnMotoQuedaConMismosMovimientos(){
        Posicion pos = new Posicion(0, 0);
        VehiculoFake vehiculo = new VehiculoFake(pos, new Auto(pos));
        CiudadFake ciudad = new CiudadFake(vehiculo);
        ciudad.ponerAccionableEnPosicion(14, 0, new CambioDeVehiculo());
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculo(new Derecha());
        }
        assertEquals(5, ciudad.obtenerCantidadDeMovVehiculo());
    }

}
