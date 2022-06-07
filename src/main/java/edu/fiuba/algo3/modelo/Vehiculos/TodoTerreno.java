package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Constantes;
import edu.fiuba.algo3.modelo.Obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.Posicion;

public class TodoTerreno extends Vehiculo{

    private int pozosComidos;


    public TodoTerreno(Posicion posInicial){
        super(posInicial);
    }

    @Override
    public void incrementarMovimientosSegunObstaculo(Obstaculo obstaculo){
        obstaculo.aplicarPenalizacion(this);
    }

    public void darVuelta(){
        posicion.establecerEnUltimaPos();
    }

    public void comerPozo(){
        this.pozosComidos++;
    }

    public boolean seComioDemasiadosPozos(){
        return (pozosComidos % Constantes.cantidadDePozosParaAplicarPenalizacionTodoterreno) == 0;
    }

    public Vehiculo cambiarVehiculo(){
        return new Moto(this.posicion);
    }

}
