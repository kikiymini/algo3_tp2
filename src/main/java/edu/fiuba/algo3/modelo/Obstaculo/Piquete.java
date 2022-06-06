package edu.fiuba.algo3.modelo.Obstaculo;

import edu.fiuba.algo3.modelo.Accionable;
import edu.fiuba.algo3.modelo.Constantes;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.TodoTerreno;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public final class Piquete implements Obstaculo {

    public int aplicarPenalizacion(Moto moto) {
        return Constantes.penalizacionDeMovimientosPorPiqueteParaMoto;
    }

    public int aplicarPenalizacion(Auto auto) {
        auto.darVuelta();

        return Constantes.penalizacionDeMovimientosPorPiqueteParaAutoYTodoterreno;
    }

    public int aplicarPenalizacion(TodoTerreno todoTerreno) {
        todoTerreno.darVuelta();

        return Constantes.penalizacionDeMovimientosPorPiqueteParaAutoYTodoterreno;
    }

    public int aplicarPenalizacion(Vehiculo vehiculo) {
        return vehiculo.incrementarMovimientosSegunObstaculo(this);
    }

    public void accionar(Vehiculo vehiculo) {
        aplicarPenalizacion(vehiculo);
    }

}
