package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Constantes;
import edu.fiuba.algo3.modelo.Obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.Posicion;

import java.util.ArrayList;
import java.util.Random;

public abstract class Vehiculo {

    protected Posicion posicion;
    protected int movimientos;


    protected static Random RNG = new Random();


    public Vehiculo (Posicion pos){
        this.posicion = pos;
    }

    public void posicionarVehiculo(int posicionX, int posicionY){
        this.posicion = new Posicion(posicionX, posicionY);
    }

    public void moverArriba(){
        this.posicion.incrementarY();
    }

    public void moverAbajo(){
        this.posicion.decrementarY();
    }

    public void moverDerecha(){
        this.posicion.incrementarX();
    }

    public void moverIzquierda(){
        this.posicion.decrementarX();
    }

    public void modificarMovimientosSegunFactor(double factor) {
        this.movimientos *= factor;
    }

    public abstract void incrementarMovimientosSegunObstaculo(Obstaculo obstaculo);

    public abstract Vehiculo cambiarVehiculo();

    public void incrementarMovimientosSegunObstaculo(int penalizacion){
        movimientos += penalizacion;
    }


    //mejorar
    public static Vehiculo obtenerVehiculoAlAzar(Posicion posInicial){ //ver
        if (RNG.nextDouble() < Constantes.probabilidadDeObtenerUnaMoto){
            return new Moto(posInicial);
        } else if (RNG.nextDouble() < Constantes.probabilidadDeObtenerUnAuto){
            return new Auto(posInicial);
        } else {
            return new TodoTerreno(posInicial);
        }
    }

    public ArrayList<Integer> obtenerPos(){
        return posicion.obtenerPos();
    }

    public boolean estasEnEsquiana(){
        return posicion.estasEnEsquina();
    }
    //Metodos para probar (Hay que crear fake objects despues)
    public int cantidadDeMovimientos(){return movimientos;}
    public void setearCantidadDeMovimientos(int cant){movimientos = cant;}
    public Posicion obtenerPosVehiculo(){
        return this.posicion;
    }

}
