package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Accionable;
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

<<<<<<< HEAD
    public abstract void incrementarMovimientosSegunObstaculo(Obstaculo obstaculo);

    public abstract Vehiculo cambiarVehiculo();

    public void incrementarMovimientosSegunObstaculo(int penalizacion){
        movimientos += penalizacion;
    }

<<<<<<< HEAD

    //mejorar
    public static Vehiculo obtenerVehiculoAlAzar(Posicion posInicial){ //ver
        if (RNG.nextDouble() < Constantes.probabilidadDeObtenerUnaMoto){
            return new Moto(posInicial);
        } else if (RNG.nextDouble() < Constantes.probabilidadDeObtenerUnAuto){
            return new Auto(posInicial);
        } else {
            return new TodoTerreno(posInicial);
        }
=======
    private static ArrayList <Vehiculo> generarListaDeVehiculos(Posicion posInicial){
        ArrayList <Vehiculo> vehiculos = new ArrayList <>();
        vehiculos.add(new Auto(posInicial));
        vehiculos.add(new Moto(posInicial));
        vehiculos.add(new TodoTerreno(posInicial));
        return vehiculos;
    }

    public static Vehiculo obtenerVehiculoAlAzar(Posicion posInicial){
        ArrayList <Vehiculo> vehiculos = generarListaDeVehiculos(posInicial);
=======
    public static EstadoVehiculo obtenerVehiculoAlAzar(Posicion posInicial){
        ArrayList <EstadoVehiculo> vehiculos = generarListaDeVehiculos(posInicial);
>>>>>>> 4f798889e50c50dc81b0bb7cd5f8bda6c5a3dc9f
        int random = new Random().nextInt(3);
        return (vehiculos.get(random));
>>>>>>> 0d9bda11ee442cd1debf8d4aa98fc884b76330bf
    }

    public void accionar(Obstaculo obstaculo){
        movimientos += estado.accionar(obstaculo);
    }

    public boolean estasEnEsquiana(){
        return posicion.estasEnEsquina();
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
