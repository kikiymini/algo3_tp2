package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.Posicion;

public final class Moto extends Vehiculo{

    public Moto(Posicion posInicial){
        super(posInicial);
    }

    @Override
    public int incrementarMovimientosSegunObstaculo(Obstaculo obstaculo){
        int movimientosIncrementados = obstaculo.aplicarPenalizacion(this);
        movimientos += movimientosIncrementados;

        return movimientosIncrementados;
    }

    public Vehiculo cambiarVehiculo(){
        return new Auto(this.posicion);
    }

}
