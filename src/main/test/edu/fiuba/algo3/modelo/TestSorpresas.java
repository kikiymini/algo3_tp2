package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Accionable;
import edu.fiuba.algo3.modelo.Posicion;
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
        Vehiculo moto = new Moto(new Posicion(1, 1));
        Accionable favorable = new Favorable();
        favorable.accionar(moto);
        assertEquals(0, moto.cantidadDeMovimientos());
    }

    @Test
    public void Test02MotoPisaUnaSorpresaFavorableDespuesDeHacer10Movimientos(){
        Moto moto = new Moto(new Posicion(1, 1));
        moto.setearCantidadDeMovimientos(10);
        Accionable favorable = new Favorable();
        favorable.accionar(moto);
        assertEquals(8, moto.cantidadDeMovimientos());
    }

    @Test
    public void Test03AutoPisaUnaSorpresaFavorableSinNingunMovimiento(){
        Vehiculo auto = new Auto(new Posicion(1, 1));
        Accionable favorable = new Favorable();
        favorable.accionar(auto);
        assertEquals(0, auto.cantidadDeMovimientos());
    }

    @Test
    public void Test04AutoPisaUnaSorpresaFavorableDespuesDeHacer10Movimientos(){
        Vehiculo auto = new Auto(new Posicion(1, 1));
        auto.setearCantidadDeMovimientos(10);
        Accionable favorable = new Favorable();
        favorable.accionar(auto);
        assertEquals(8, auto.cantidadDeMovimientos());
    }

    @Test
    public void Test05TodoTerrenoPisaUnaSorpresaFavorableSinNingunMovimiento(){
        Vehiculo todoTerreno = new TodoTerreno(new Posicion(1, 1));
        Accionable favorable = new Favorable();
        favorable.accionar(todoTerreno);
        assertEquals(0, todoTerreno.cantidadDeMovimientos());
    }

    @Test
    public void Test06TodoTerrenoPisaUnaSorpresaFavorableDespuesDeHacer10Movimientos(){
        Vehiculo todoTerreno = new TodoTerreno(new Posicion(1, 1));
        todoTerreno.setearCantidadDeMovimientos(10);
        Accionable favorable = new Favorable();
        favorable.accionar(todoTerreno);
        assertEquals(8, todoTerreno.cantidadDeMovimientos());
    }

    @Test
    public void Test07MotoPisaUnaSorpresaDesfavorableSinNingunMovimiento(){
        Vehiculo moto = new Moto(new Posicion(1, 1));
        Accionable desfavorable = new Desfavorable();
        desfavorable.accionar(moto);
        assertEquals(0, moto.cantidadDeMovimientos());
    }

    @Test
    public void Test08MotoPisaUnaSorpresaDesfavorableDespuesDeHacer10Movimientos(){
        Moto moto = new Moto(new Posicion(1, 1));
        moto.setearCantidadDeMovimientos(10);
        Accionable desfavorable = new Desfavorable();
        desfavorable.accionar(moto);
        assertEquals(12, moto.cantidadDeMovimientos());
    }

    @Test
    public void Test09AutoPisaUnaSorpresaDesfavorableSinNingunMovimiento(){
        Vehiculo auto = new Auto(new Posicion(1, 1));
        Accionable desfavorable = new Desfavorable();
        desfavorable.accionar(auto);
        assertEquals(0, auto.cantidadDeMovimientos());
    }

    @Test
    public void Test10AutoPisaUnaSorpresaDesfavorableDespuesDeHacer10Movimientos(){
        Vehiculo auto = new Auto(new Posicion(1, 1));
        auto.setearCantidadDeMovimientos(10);
        Accionable desfavorable = new Desfavorable();
        desfavorable.accionar(auto);
        assertEquals(12, auto.cantidadDeMovimientos());
    }

    @Test
    public void Test11TodoTerrenoPisaUnaSorpresaDesfavorableSinNingunMovimiento(){
        Vehiculo todoTerreno = new TodoTerreno(new Posicion(1, 1));
        Accionable desfavorable = new Desfavorable();
        desfavorable.accionar(todoTerreno);
        assertEquals(0, todoTerreno.cantidadDeMovimientos());
    }

    @Test
    public void Test12TodoTerrenoPisaUnaSorpresaDesfavorableDespuesDeHacer10Movimientos(){
        Vehiculo todoTerreno = new TodoTerreno(new Posicion(1, 1));
        todoTerreno.setearCantidadDeMovimientos(10);
        Accionable desfavorable = new Desfavorable();
        desfavorable.accionar(todoTerreno);
        assertEquals(12, todoTerreno.cantidadDeMovimientos());
    }



}
