package edu.fiuba.algo3.modelo.Obstaculo;

import edu.fiuba.algo3.modelo.Accionable;
import edu.fiuba.algo3.modelo.Constantes;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.TodoTerreno;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public final class Pozo implements Obstaculo {

    public void aplicarPenalizacion(Moto moto){
        moto.incrementarMovimientosSegunObstaculo(Constantes.penalizacionDeMovimientosPorPozoParaMotoYAuto);
    }

    public void aplicarPenalizacion(Auto auto) {
        auto.incrementarMovimientosSegunObstaculo(Constantes.penalizacionDeMovimientosPorPozoParaMotoYAuto);
    }

    public void aplicarPenalizacion(TodoTerreno todoTerreno) {
        todoTerreno.comerPozo();
        if (todoTerreno.seComioDemasiadosPozos()){
             todoTerreno.incrementarMovimientosSegunObstaculo(Constantes.penalizacionDeMovimientosPorPozoParaTodoterreno);
        } else {
             todoTerreno.incrementarMovimientosSegunObstaculo(Constantes.penalizacionDeMovimientosPorPozoEsquivadoParaTodoterreno);
        }
    }

    public void aplicarPenalizacion(Vehiculo vehiculo) {
        vehiculo.incrementarMovimientosSegunObstaculo(this);
    }

    public void accionar(Vehiculo vehiculo) {
         aplicarPenalizacion(vehiculo);
    }

}
