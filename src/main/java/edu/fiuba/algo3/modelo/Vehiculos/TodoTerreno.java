package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Obstaculo.Calle;
import edu.fiuba.algo3.modelo.Constantes;
import edu.fiuba.algo3.modelo.Obstaculo.Esquina;
import edu.fiuba.algo3.modelo.Obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.Obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.Obstaculo.Piquete;
import edu.fiuba.algo3.modelo.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Posicion;

import java.util.Random;

public class TodoTerreno implements EstadoVehiculo{

    private int pozosComidos;
    private final Random RNG = new Random();
    private Posicion posicion;

    public TodoTerreno(Posicion pos){
        posicion = pos;
    }

    @Override
    public int accionar(Obstaculo obstaculo) {
        return obstaculo.accioname(this);
    }

    public int accionar(Pozo pozo){
        this.pozosComidos++;
        if (seComioDemasiadosPozos())
            return Constantes.penalizacionDeMovimientosPorPozoParaTodoterreno;
        return 0;
    }

    public int accionar(Piquete piquete) {
        posicion.establecerEnUltimaPos();
        return Constantes.penalizacionDeMovimientosPorPiqueteParaAutoYTodoterreno;
    }

    public int accionar(ControlPolicial control) {
        if (RNG.nextDouble() < Constantes.probabilidadDePenalizarEnControlPolicialParaTodoterreno) {
            return (Constantes.penalizacionDeMovimientosPorControlPolicial);
        }
        return (Constantes.penalizacionDeMovimientosPorControlPolicialEsquivado);
    }

    public int accionar(Calle calle){
        return 0;
    }

    @Override
    public int accionar(Esquina esquina) {
        return 1;
    }

    public boolean seComioDemasiadosPozos(){
        return (pozosComidos % Constantes.cantidadDePozosParaAplicarPenalizacionTodoterreno) == 0;
    }

    public EstadoVehiculo cambiarVehiculo(){
        return new Moto(posicion);
    }


}
