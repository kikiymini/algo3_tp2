package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Constantes;
import edu.fiuba.algo3.modelo.Movimiento.*;
import edu.fiuba.algo3.modelo.Obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.Posicion;

import java.util.ArrayList;
import java.util.Random;

public class Vehiculo {

    protected Posicion posicion;
    protected int movimientos;
    protected static Random RNG = new Random(); //0-1 penalizacion
    protected EstadoVehiculo estado;


    public Vehiculo (Posicion pos){
        this.posicion = pos;
        estado = obtenerVehiculoAlAzar(posicion);
    }

    public void posicionarVehiculo(int posicionX, int posicionY){
        this.posicion = new Posicion(posicionX, posicionY);
    }

    public void movermeHacia(Movimiento movimiento){
        movimiento.mover(posicion);
    }

    public void modificarMovimientosSegunFactor(double factor) {
        this.movimientos *= factor;
    }

    public void incrementarMovimientosSegunObstaculo(int penalizacion){
        movimientos += penalizacion;
    }

    public static EstadoVehiculo obtenerVehiculoAlAzar(Posicion posInicial){
        ArrayList <EstadoVehiculo> vehiculos = generarListaDeVehiculos(posInicial);
        int random = new Random().nextInt(3);
        return (vehiculos.get(random));
    }

    public boolean estasEnEsquiana(){
        return posicion.estasEnEsquina();
    }

   public void pisarPozo(){
        movimientos += estado.pisarPozo();
   }

   public void encontrarsePiquete(){
        movimientos += estado.encontrarsePiquete();
   }

   public void encontrarseControlPolicial(){
        movimientos += estado.encontrarseControlPolicial();
   }

    public void cambiarVehiculo(){
        estado = estado.cambiarVehiculo();
    }

    public Posicion obtenerPosVehiculo(){
        return this.posicion;
    }

    public ArrayList<Integer> obtenerPos(){
        return posicion.obtenerPos();
    }

    private static ArrayList <EstadoVehiculo> generarListaDeVehiculos(Posicion posInicial){
        ArrayList <EstadoVehiculo> vehiculos = new ArrayList <>();
        vehiculos.add(new Auto(posInicial));
        vehiculos.add(new Moto(posInicial));
        vehiculos.add(new TodoTerreno(posInicial));
        return vehiculos;
    }
    //Metodos para probar (Hay que crear fake objects despues)

    public int obtenerCantidadDeMovimientos(){return movimientos;}

}
