package edu.fiuba.algo3.modelo.Obstaculo;

import edu.fiuba.algo3.modelo.Accionable;
import edu.fiuba.algo3.modelo.Vehiculos.*;

public interface Obstaculo extends Accionable {

    void aplicarPenalizacion(Vehiculo vehiculo);
    int accioname(EstadoVehiculo estado);
}
