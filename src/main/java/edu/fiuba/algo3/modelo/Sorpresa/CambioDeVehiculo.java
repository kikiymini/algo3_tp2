package edu.fiuba.algo3.modelo.Sorpresa;

import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public final class CambioDeVehiculo implements Sorpresa {

    public void sorprender(Vehiculo vehiculo) { vehiculo.cambiarVehiculo();}

    public void accionar(Vehiculo vehiculo) {
        sorprender(vehiculo);
    }

}

