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

    public Vehiculo cambiarVehiculo(){
        proxVehiculo = new Auto(this.posicion);
        proxVehiculo.incrementarMovimientosSegunObstaculo(movimientos);
        return new Auto(this.posicion); // hay que borrar no es necesario devolcer un vehivulo con este planteo
    }

    @Override
    public Vehiculo cambiasteVehiculo() {
        return proxVehiculo;
    }

}
