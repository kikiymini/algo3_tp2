package edu.fiuba.algo3.modelo.Obstaculo;

import edu.fiuba.algo3.modelo.Accionable;
import edu.fiuba.algo3.modelo.Constantes;
import edu.fiuba.algo3.modelo.Vehiculos.*;

public final class Pozo implements Obstaculo {

    public void aplicarPenalizacion(Vehiculo vehiculo) {
        vehiculo.accionar(this);
    }

    @Override
    public int accioname(EstadoVehiculo estado) {
        return estado.accionar(this);
    }

    public void accionar(Vehiculo vehiculo) {
         aplicarPenalizacion(vehiculo);
    }

}
