package edu.fiuba.algo3.modelo.Sorpresa;

import edu.fiuba.algo3.modelo.Accionable;
import edu.fiuba.algo3.modelo.Constantes;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public final class Favorable implements Sorpresa {

    public void sorprender(Vehiculo vehiculo) {
        vehiculo.modificarMovimientosSegunFactor(Constantes.factorDeModificacionDeMovimientosPorSorpresaFavorable);
    }

    public void accionar(Vehiculo vehiculo) {
       sorprender(vehiculo);
    }
}
