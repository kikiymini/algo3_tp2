package edu.fiuba.algo3.modelo.Obstaculo;

import edu.fiuba.algo3.modelo.Constantes;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.TodoTerreno;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

import java.util.Random;


public final class ControlPolicial implements Obstaculo {

    private final Random RNG = new Random();

    public void aplicarPenalizacion(Moto moto) {
        if (RNG.nextDouble() < Constantes.probabilidadDePenalizarEnControlPolicialParaMoto) {
            moto.incrementarMovimientosSegunObstaculo(Constantes.penalizacionDeMovimientosPorControlPolicial);
        }
        else {
            moto.incrementarMovimientosSegunObstaculo(Constantes.penalizacionDeMovimientosPorControlPolicialEsquivado);
        }

    }

    public void aplicarPenalizacion(Auto auto) {
        if (RNG.nextDouble() < Constantes.probabilidadDePenalizarEnControlPolicialParaAuto) {
            auto.incrementarMovimientosSegunObstaculo(Constantes.penalizacionDeMovimientosPorControlPolicial);
        }
        else {
            auto.incrementarMovimientosSegunObstaculo(Constantes.penalizacionDeMovimientosPorControlPolicialEsquivado);
        }

    }

    public void aplicarPenalizacion(TodoTerreno todoTerreno) {
        if (RNG.nextDouble() < Constantes.probabilidadDePenalizarEnControlPolicialParaTodoterreno) {
            todoTerreno.incrementarMovimientosSegunObstaculo(Constantes.penalizacionDeMovimientosPorControlPolicial);
        }
        else{
            todoTerreno.incrementarMovimientosSegunObstaculo(Constantes.penalizacionDeMovimientosPorControlPolicialEsquivado);
        }

    }

    public void aplicarPenalizacion(Vehiculo vehiculo) {
        vehiculo.incrementarMovimientosSegunObstaculo(this);
    }

    public void accionar(Vehiculo vehiculo) {
        aplicarPenalizacion(vehiculo);
    }

}
