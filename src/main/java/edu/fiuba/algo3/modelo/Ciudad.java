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
        for(int i = 0; i < 3; i++){
            vehiculo.moverArriba();
            grilla.moverVehiculo(vehiculo);
            if (vehiculo.estasEnEsquiana()) break; // esto rompe pilares poo. No se como manejar caso de piquete
        }
    }

    public void moverVehiculoAbajo(){
        for(int i = 0; i < 3; i++){
            vehiculo.moverAbajo();
            grilla.moverVehiculo(vehiculo);
            if (vehiculo.estasEnEsquiana()) break; // esto rompe pilares poo. No se como manejar caso de piquete
        }
    }

    public void moverVehiculoIzquierda(){
        for(int i = 0; i < 3; i++){
            vehiculo.moverIzquierda();
            grilla.moverVehiculo(vehiculo);
            if (vehiculo.estasEnEsquiana()) break; // esto rompe pilares poo. No se como manejar caso de piquete
        }
    }

    public void moverVehiculoDerecha(){
        for(int i = 0; i < 3; i++){
            vehiculo.moverDerecha();
            grilla.moverVehiculo(vehiculo);
            if (vehiculo.estasEnEsquiana()) break; // esto rompe pilares poo. No se como manejar caso de piquete
        }
    }
}
