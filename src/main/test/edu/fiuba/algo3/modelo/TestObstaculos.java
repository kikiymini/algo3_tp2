package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Obstaculo.Piquete;
import edu.fiuba.algo3.modelo.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestObstaculos {
    @Test
    public void Test01MotoPisaUnPozoSeIncrementan3Movimientos(){
        Vehiculo moto = new Moto(new Posicion(1, 1));
        Pozo pozo = new Pozo();
        pozo.accionar(moto);
        assertEquals(3, moto.cantidadDeMovimientos());
    }

    @Test
    public void Tes03MotoPisaUnAccionablePozoYLeSuma3Movimientos(){
        Vehiculo moto = new Moto(new Posicion(1, 1));
        Accionable pozo = new Pozo();
        pozo.accionar(moto);
        assertEquals(3, moto.cantidadDeMovimientos());
    }

    @Test
    public void Test04MotoPisaUnAccionablePozo2VecesYLeSuma6Movimientos(){
        Vehiculo moto = new Moto(new Posicion(1, 1));
        Accionable pozo = new Pozo();
        pozo.accionar(moto);
        pozo.accionar(moto);
        assertEquals(6, moto.cantidadDeMovimientos());
    }

    @Test
    public void Test05AutoPisaUnPozoYLeSuma3Movimientos(){
        Vehiculo auto = new Auto(new Posicion(1, 1));
        Accionable pozo = new Pozo();
        pozo.accionar(auto);
        assertEquals(3, auto.cantidadDeMovimientos());
    }

    @Test
    public void Test06AutoPisaUnPozoDosVecesYLeSuma6Movimientos(){
        Vehiculo auto = new Auto(new Posicion(1, 1));
        Accionable pozo = new Pozo();
        pozo.accionar(auto);
        pozo.accionar(auto);
        assertEquals(6, auto.cantidadDeMovimientos());
    }
    @Test
    public void Tes07MotoSeEncuentraUnPiqueteYLeSuma2Movimientos(){
        Vehiculo moto = new Moto(new Posicion(1, 1));
        Accionable piquete = new Piquete();
        piquete.accionar(moto);
        assertEquals(2, moto.cantidadDeMovimientos());
    }



}

