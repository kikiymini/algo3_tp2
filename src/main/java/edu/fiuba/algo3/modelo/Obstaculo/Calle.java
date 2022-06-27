package edu.fiuba.algo3.modelo.Obstaculo;

import edu.fiuba.algo3.modelo.Accionable;
import edu.fiuba.algo3.modelo.Obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.Vehiculos.EstadoVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public class Calle implements Obstaculo {
    @Override
    public void accionar(Vehiculo vehiculo){
        aplicarPenalizacion(vehiculo);
    }

    @Override
    public boolean sosAccionable(Accionable accionable) {
        return this.getClass().equals(accionable.getClass());
    }

    @Override
    public void aplicarPenalizacion(Vehiculo vehiculo) {
        vehiculo.accionar(this);
    }

    @Override
    public int accioname(EstadoVehiculo estado) {
        return estado.accionar(this);
    }
}
