package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Constantes;
import edu.fiuba.algo3.modelo.Obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.Posicion;

public class TodoTerreno extends Vehiculo{

    private int pozosComidos;
    private Vehiculo proxVehiculo = this;


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

    public void penalizarPorPozo(){
        this.pozosComidos++;
        if (seComioDemasiadosPozos()) this.incrementarMovimientosSegunObstaculo(Constantes.penalizacionDeMovimientosPorPozoParaTodoterreno);
    }

    public boolean seComioDemasiadosPozos(){
        return (pozosComidos % Constantes.cantidadDePozosParaAplicarPenalizacionTodoterreno) == 0;
    }

    public void cambiarVehiculo(){
        proxVehiculo = new Moto(this.posicion);
        proxVehiculo.incrementarMovimientosSegunObstaculo(movimientos);

    }

    @Override
    public Vehiculo cambiasteVehiculo() {
        return proxVehiculo;
    }

}
