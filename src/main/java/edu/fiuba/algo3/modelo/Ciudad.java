package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Grilla.Grilla;
import edu.fiuba.algo3.modelo.Grilla.InicializadorGrilla;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

import java.util.Random;

public class Ciudad {

    protected Grilla grilla;
    protected Posicion posIniVehiculo;
    protected Vehiculo vehiculo;
    protected InicializadorGrilla inicializador;

    private static Random RNG = new Random();


    public Ciudad(){
        this.grilla = new Grilla();
        this.inicializador = new InicializadorGrilla(grilla);
        this.vehiculo = Vehiculo.obtenerVehiculoAlAzar(inicializador.conseguirPosIniValidaDeVehiculo());
        this.posIniVehiculo = vehiculo.obtenerPosVehiculo();
        inicializador.insertarAccionables();

    }

    public void moverVehiculoArriba(){
        Boolean estaEnEsquina = false;
        int i = 0;
        while(i < 3 && !estaEnEsquina){
            vehiculo.moverArriba();
            grilla.moverVehiculo(vehiculo);
            estaEnEsquina = vehiculo.estasEnEsquiana();
            i++;
        }
    }

    public void moverVehiculoAbajo(){
        Boolean estaEnEsquina = false;
        int i = 0;
        while(i < 3 && !estaEnEsquina){
            vehiculo.moverAbajo();
            grilla.moverVehiculo(vehiculo);
            estaEnEsquina = vehiculo.estasEnEsquiana();
            i++;
        }
    }

    public void moverVehiculoIzquierda(){
        Boolean estaEnEsquina = false;
        int i = 0;
        while(i < 3 && !estaEnEsquina){
            vehiculo.moverIzquierda();
            grilla.moverVehiculo(vehiculo);
            estaEnEsquina = vehiculo.estasEnEsquiana();
            i++;
        }
    }

    public void moverVehiculoDerecha(){
        Boolean estaEnEsquina = false;
        int i = 0;
        while(i < 3 && !estaEnEsquina){
            vehiculo.moverDerecha();
            grilla.moverVehiculo(vehiculo);
            estaEnEsquina = vehiculo.estasEnEsquiana();
            i++;
        }
    }
}
