package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Constantes;
import edu.fiuba.algo3.modelo.Movimiento.*;
import edu.fiuba.algo3.modelo.Obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.Posicion;

import java.util.ArrayList;
import java.util.Random;

public abstract class Vehiculo {

    protected Posicion posicion;
    protected int movimientos;
    protected static Random RNG = new Random(); //0-1 penalizacion

    //ver!!
    public Vehiculo (int maxGrillaX) {
        this.posicion = new Posicion(RNG.nextInt(maxGrillaX),0);
    }
    public Vehiculo (Posicion pos){
        this.posicion = pos;
    }

    public void posicionarVehiculo(int posicionX, int posicionY){
        this.posicion = new Posicion(posicionX, posicionY);
    }

    public void moverArriba(){
        Movimiento arriba = new Arriba();
        arriba.movermeHacia(posicion);
    }

    public void moverAbajo(){
        Movimiento abajo = new Abajo();
        abajo.movermeHacia(posicion);

    }

    public void moverDerecha() {
        Movimiento derecha = new Derecha();
        derecha.movermeHacia(posicion);
    }

    public void moverIzquierda(){;
        Movimiento izquierda = new Izquierda();
        izquierda.movermeHacia(posicion);
    }

    public void modificarMovimientosSegunFactor(double factor) {
        this.movimientos *= factor;
    }

    public abstract void incrementarMovimientosSegunObstaculo(Obstaculo obstaculo);

    public abstract void cambiarVehiculo();

    public void incrementarMovimientosSegunObstaculo(int penalizacion){
        movimientos += penalizacion;
    }

    private static ArrayList <Vehiculo> generarListaDeVehiculos(Posicion posInicial){
        ArrayList <Vehiculo> vehiculos = new ArrayList <>();
        vehiculos.add(new Auto(posInicial));
        vehiculos.add(new Moto(posInicial));
        vehiculos.add(new TodoTerreno(posInicial));
        return vehiculos;
    }

    public static Vehiculo obtenerVehiculoAlAzar(Posicion posInicial){
        ArrayList <Vehiculo> vehiculos = generarListaDeVehiculos(posInicial);
        int random = new Random().nextInt(3);
        return (vehiculos.get(random));
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
    public int obtenerCantidadDeMovimientos(){return movimientos;}

    //esta ultima funcion no se utiliza. es para un posible cambio de comportamiento. a futuro
    public void movermeHacia(Movimiento movimiento) {
        /* recibe una penalizacion? aplicarPenalizacion debe verificar si puedo moverme.
            Si es así, me penalizo. Aumento los movimientos.
            sino avanzo
         */
        movimiento.movermeHacia(this.posicion);
        movimientos++;
    }

    public abstract Vehiculo cambiasteVehiculo();

}
