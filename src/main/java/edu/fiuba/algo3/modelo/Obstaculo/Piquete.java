package edu.fiuba.algo3.modelo.Obstaculo;

import edu.fiuba.algo3.modelo.Accionable;
import edu.fiuba.algo3.modelo.Constantes;
import edu.fiuba.algo3.modelo.Vehiculos.*;

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
<<<<<<< HEAD
}
=======

    public boolean sosAccionable(Accionable accionable) {
        return this.getClass().equals(accionable.getClass());
    }
}
>>>>>>> 92413ca457ae992cfb80b7c5bb44ce236c71729b
