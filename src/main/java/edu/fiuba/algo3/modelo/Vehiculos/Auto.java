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

public class Auto implements EstadoVehiculo{
    private final Random RNG = new Random();
    private Posicion posicion;

    public Auto(Posicion pos){
        posicion = pos;
    }

    @Override
    public int accionar(Obstaculo obstaculo) {
        return obstaculo.accioname(this);
    }

    public int accionar(Pozo pozo){
        return Constantes.penalizacionDeMovimientosPorPozoParaMotoYAuto;
    }

    public int accionar(Piquete piquete) {
        posicion.establecerEnUltimaPos();
        return Constantes.penalizacionDeMovimientosPorPiqueteParaAutoYTodoterreno;

    }

    public int accionar(ControlPolicial control) {
        if (RNG.nextDouble() < Constantes.probabilidadDePenalizarEnControlPolicialParaAuto) {
            return Constantes.penalizacionDeMovimientosPorControlPolicial;
        }
        return Constantes.penalizacionDeMovimientosPorControlPolicialEsquivado;
    }

    public int accionar(Calle calle){
        return 0;
    }

    @Override
    public int accionar(Esquina esquina) {
        return 1;
    }

    @Override
    public boolean sosEstado(EstadoVehiculo estado) {
        return this.getClass().equals(estado.getClass());
    }

    public EstadoVehiculo cambiarVehiculo(){
        return new TodoTerreno(posicion);
    }


}
