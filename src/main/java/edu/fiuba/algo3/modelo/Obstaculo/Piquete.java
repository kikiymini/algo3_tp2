package edu.fiuba.algo3.modelo.Obstaculo;

import edu.fiuba.algo3.modelo.Accionable;
import edu.fiuba.algo3.modelo.Constantes;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.TodoTerreno;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public final class Piquete implements Obstaculo {
    public void aplicarPenalizacion(Vehiculo vehiculo) {
        vehiculo.encontrarsePiquete();
    }

    public void accionar(Vehiculo vehiculo) {
        this.aplicarPenalizacion(vehiculo);
    }
}
