package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.Posicion;

public class Auto extends Vehiculo{

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

    public Vehiculo cambiarVehiculo(){
        return new TodoTerreno(this.posicion);
     }

}
