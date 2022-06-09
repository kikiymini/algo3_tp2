package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public class Calle implements Accionable{
    @Override
    public void accionar(Vehiculo vehiculo){
        vehiculo.incrementarMovimientosSegunObstaculo(0);
    }
}
