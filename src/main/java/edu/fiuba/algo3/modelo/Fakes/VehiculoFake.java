package edu.fiuba.algo3.modelo.Fakes;

import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Vehiculos.EstadoVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public class VehiculoFake extends Vehiculo {

    public VehiculoFake(Posicion pos, EstadoVehiculo estadoVehiculo) {
        super(pos);
        estado = estadoVehiculo;
    }
    public int cantidadDeMovimientos(){
        return movimientos;
    }

    public void setearCantidadDeMovimientos(int unaCantidadMovimientos){
        movimientos = unaCantidadMovimientos;
    }

    public EstadoVehiculo obtenerEstado(){
        return estado;
    }

    public Posicion obtenerPosVehiculo(){
        return posicion;

    }

    public int obtenerCantidadDeMovimientos(){return movimientos;}

}
