package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Constantes;
import edu.fiuba.algo3.modelo.Posicion;

import java.util.Random;

public class TodoTerreno implements EstadoVehiculo{

    private int pozosComidos;
    private final Random RNG = new Random();
    private Posicion posicion;

    public TodoTerreno(Posicion pos){
        posicion = pos;
    }

    public int pisarPozo(){
        this.pozosComidos++;
        if (seComioDemasiadosPozos())
            return Constantes.penalizacionDeMovimientosPorPozoParaTodoterreno;
        return 0;
    }

    public int encontrarsePiquete() {
        posicion.establecerEnUltimaPos();
        return Constantes.penalizacionDeMovimientosPorPiqueteParaAutoYTodoterreno;
    }

    public int encontrarseControlPolicial() {
        if (RNG.nextDouble() < Constantes.probabilidadDePenalizarEnControlPolicialParaTodoterreno) {
            return (Constantes.penalizacionDeMovimientosPorControlPolicial);
        }
        return (Constantes.penalizacionDeMovimientosPorControlPolicialEsquivado);
    }

    public boolean seComioDemasiadosPozos(){
        return (pozosComidos % Constantes.cantidadDePozosParaAplicarPenalizacionTodoterreno) == 0;
    }

    public EstadoVehiculo cambiarVehiculo(){
        return new Moto(posicion);
    }


}
