package edu.fiuba.algo3.modelo.Obstaculo;

import edu.fiuba.algo3.modelo.Accionable;
import edu.fiuba.algo3.modelo.Constantes;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.TodoTerreno;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public final class Piquete implements Obstaculo {
    public void aplicarPenalizacion(Moto moto) {
        moto.incrementarMovimientosSegunObstaculo(Constantes.penalizacionDeMovimientosPorPiqueteParaMoto);
    }
    public void aplicarPenalizacion(Auto auto) {
        auto.darVuelta();
        auto.incrementarMovimientosSegunObstaculo(Constantes.penalizacionDeMovimientosPorPiqueteParaAutoYTodoterreno);
    }
    public void aplicarPenalizacion(TodoTerreno todoTerreno) {
        todoTerreno.darVuelta();
        todoTerreno.incrementarMovimientosSegunObstaculo(Constantes.penalizacionDeMovimientosPorPiqueteParaAutoYTodoterreno);
    }
    public void aplicarPenalizacion(Vehiculo vehiculo) {
        vehiculo.incrementarMovimientosSegunObstaculo(this);
    }
    public void accionar(Vehiculo vehiculo) {
        vehiculo.incrementarMovimientosSegunObstaculo(this);
    }
}
