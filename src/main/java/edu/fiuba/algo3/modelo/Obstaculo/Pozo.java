package edu.fiuba.algo3.modelo.Obstaculo;

import edu.fiuba.algo3.modelo.Accionable;
import edu.fiuba.algo3.modelo.Constantes;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.TodoTerreno;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public final class Pozo implements Obstaculo {

    public int aplicarPenalizacion(Moto moto){
        return Constantes.penalizacionDeMovimientosPorPozoParaMotoYAuto;
    }

    public int aplicarPenalizacion(Auto auto) {
        return Constantes.penalizacionDeMovimientosPorPozoParaMotoYAuto;
    }

    public int aplicarPenalizacion(TodoTerreno todoTerreno) {
        todoTerreno.comerPozo();
        if (todoTerreno.seComioDemasiadosPozos()){
            return Constantes.penalizacionDeMovimientosPorPozoParaTodoterreno;
        } else {
            return Constantes.penalizacionDeMovimientosPorPozoEsquivadoParaTodoterreno;
        }
    }

    public int aplicarPenalizacion(Vehiculo vehiculo) {
        return vehiculo.incrementarMovimientosSegunObstaculo(this);
    }

    public void accionar(Vehiculo vehiculo) {
         aplicarPenalizacion(vehiculo);
    }

}
