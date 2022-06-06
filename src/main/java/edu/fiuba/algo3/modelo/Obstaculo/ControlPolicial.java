package edu.fiuba.algo3.modelo.Obstaculo;

import edu.fiuba.algo3.modelo.Constantes;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.TodoTerreno;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

import java.util.Random;


public final class ControlPolicial implements Obstaculo {

    private final Random RNG = new Random();

    public int aplicarPenalizacion(Moto moto) {
        if (RNG.nextDouble() < Constantes.probabilidadDePenalizarEnControlPolicialParaMoto) {
            return Constantes.penalizacionDeMovimientosPorControlPolicial;
        }

        return Constantes.penalizacionDeMovimientosPorControlPolicialEsquivado;
    }

    public int aplicarPenalizacion(Auto auto) {
        if (RNG.nextDouble() < Constantes.probabilidadDePenalizarEnControlPolicialParaAuto) {
            return Constantes.penalizacionDeMovimientosPorControlPolicial;
        }

        return Constantes.penalizacionDeMovimientosPorControlPolicialEsquivado;
    }

    public int aplicarPenalizacion(TodoTerreno todoTerreno) {
        if (RNG.nextDouble() < Constantes.probabilidadDePenalizarEnControlPolicialParaTodoterreno) {
            return Constantes.penalizacionDeMovimientosPorControlPolicial;
        }

        return Constantes.penalizacionDeMovimientosPorControlPolicialEsquivado;
    }

    public int aplicarPenalizacion(Vehiculo vehiculo) {
        return vehiculo.incrementarMovimientosSegunObstaculo(this);
    }

    public void accionar(Vehiculo vehiculo) {
        aplicarPenalizacion(vehiculo);
    }

}
