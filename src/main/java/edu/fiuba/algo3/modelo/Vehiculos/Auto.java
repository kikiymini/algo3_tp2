package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.Posicion;

public class Auto extends Vehiculo{
    private Vehiculo proxVehiculo = this;
    public Auto(Posicion posInicial){
        super(posInicial);
    }

    @Override
    public void incrementarMovimientosSegunObstaculo(Obstaculo obstaculo){
        obstaculo.aplicarPenalizacion(this);

    }

    public void darVuelta(){
        posicion.establecerEnUltimaPos();
    }

    public void cambiarVehiculo(){
        proxVehiculo = new TodoTerreno(this.posicion);
        proxVehiculo.incrementarMovimientosSegunObstaculo(movimientos);
    }

    @Override
    public Vehiculo cambiasteVehiculo() {
        return proxVehiculo;
    }
}
