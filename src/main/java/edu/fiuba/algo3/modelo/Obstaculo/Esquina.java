package edu.fiuba.algo3.modelo.Obstaculo;

import edu.fiuba.algo3.modelo.Obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.Vehiculos.EstadoVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public class Esquina implements Obstaculo {

    @Override
    public void aplicarPenalizacion(Vehiculo vehiculo) {
        vehiculo.accionar(this);
    }

    @Override
    public int accioname(EstadoVehiculo estado) {
        return estado.accionar(this);
    }

    @Override
    public void accionar(Vehiculo vehiculo) {
        aplicarPenalizacion(vehiculo);
    }
}
