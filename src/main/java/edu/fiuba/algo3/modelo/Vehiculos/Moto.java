package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Constantes;
import edu.fiuba.algo3.modelo.Obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.Posicion;

import java.util.Random;

public class Moto implements EstadoVehiculo{

    private Posicion posicion;
    private final Random RNG = new Random();

    public Moto(Posicion pos){
        posicion = pos;
    }

    public int pisarPozo(){
        return Constantes.penalizacionDeMovimientosPorPozoParaMotoYAuto;
    }

    public int encontrarsePiquete() {
        return Constantes.penalizacionDeMovimientosPorPiqueteParaMoto;
    }
    public int encontrarseControlPolicial() {
        if (RNG.nextDouble() < Constantes.probabilidadDePenalizarEnControlPolicialParaMoto) {
            return Constantes.penalizacionDeMovimientosPorControlPolicial;
        }
        return Constantes.penalizacionDeMovimientosPorControlPolicialEsquivado;
    }

    public EstadoVehiculo cambiarVehiculo(){
       return new Auto(posicion);
    }

}
