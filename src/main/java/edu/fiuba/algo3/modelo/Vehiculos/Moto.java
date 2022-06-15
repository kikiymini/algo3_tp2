package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.Posicion;

public class Moto extends Vehiculo{
    private Vehiculo proxVehiculo = this;

    public Moto(Posicion posInicial){
        super(posInicial);
    }

    @Override
    public void incrementarMovimientosSegunObstaculo(Obstaculo obstaculo){
        obstaculo.aplicarPenalizacion(this);
    }

    // Hacer Patron State ( ejemplo ajedrez cuando cambia de estado (instancia) )
    public void cambiarVehiculo(){
        proxVehiculo = new Auto(this.posicion);
        proxVehiculo.incrementarMovimientosSegunObstaculo(movimientos);
    }

    @Override
    public Vehiculo cambiasteVehiculo() {
        return proxVehiculo;
    }

}
