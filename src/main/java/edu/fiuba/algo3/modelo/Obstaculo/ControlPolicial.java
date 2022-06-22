package edu.fiuba.algo3.modelo.Obstaculo;

import edu.fiuba.algo3.modelo.Constantes;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.TodoTerreno;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

import java.util.Random;


public final class ControlPolicial implements Obstaculo {

    public void aplicarPenalizacion(Vehiculo vehiculo) {
        vehiculo.encontrarseControlPolicial();
    }

    public void accionar(Vehiculo vehiculo) {
        aplicarPenalizacion(vehiculo);
    }

}
