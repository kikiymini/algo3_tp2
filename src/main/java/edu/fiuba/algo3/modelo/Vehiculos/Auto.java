package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Constantes;
import edu.fiuba.algo3.modelo.Obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.Posicion;

import java.util.Random;

public class Auto implements EstadoVehiculo{
    private final Random RNG = new Random();
    private Posicion posicion;

    public Auto(Posicion pos){
        posicion = pos;
    }

    public int pisarPozo(){
        return Constantes.penalizacionDeMovimientosPorPozoParaMotoYAuto;
    }

    public int encontrarsePiquete() {
        posicion.establecerEnUltimaPos();
        return Constantes.penalizacionDeMovimientosPorPiqueteParaAutoYTodoterreno;

    }

    public int encontrarseControlPolicial() {
        if (RNG.nextDouble() < Constantes.probabilidadDePenalizarEnControlPolicialParaAuto) {
            return Constantes.penalizacionDeMovimientosPorControlPolicial;
        }
        return Constantes.penalizacionDeMovimientosPorControlPolicialEsquivado;
    }

    public EstadoVehiculo cambiarVehiculo(){
        return new TodoTerreno(posicion);
    }


}
