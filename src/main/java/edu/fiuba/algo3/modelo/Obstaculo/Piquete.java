package edu.fiuba.algo3.modelo.Obstaculo;

import edu.fiuba.algo3.modelo.Accionable;
import edu.fiuba.algo3.modelo.Constantes;
import edu.fiuba.algo3.modelo.Vehiculos.*;

public final class Piquete implements Obstaculo {
<<<<<<< HEAD
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
=======
>>>>>>> 4f798889e50c50dc81b0bb7cd5f8bda6c5a3dc9f
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
}
