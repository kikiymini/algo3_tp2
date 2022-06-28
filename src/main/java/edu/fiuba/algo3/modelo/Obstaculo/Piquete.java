package edu.fiuba.algo3.modelo.Obstaculo;

import edu.fiuba.algo3.modelo.Accionable;
import edu.fiuba.algo3.modelo.Vehiculos.EstadoVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public final class Piquete implements Obstaculo {
    public void aplicarPenalizacion(Vehiculo vehiculo) {
        vehiculo.accionar(this);
    }

    @Override
    public int accioname(EstadoVehiculo estado) {
        return estado.accionar(this);
    }

    public void accionar(Vehiculo vehiculo) {
        this.aplicarPenalizacion(vehiculo);
    }
    public boolean sosAccionable(Accionable accionable) {
        return this.getClass().equals(accionable.getClass());
    }
}

