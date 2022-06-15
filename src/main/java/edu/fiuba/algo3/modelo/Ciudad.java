package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Grilla.Grilla;
import edu.fiuba.algo3.modelo.Grilla.InicializadorGrilla;
import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
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

    // patron state, strategy, double

    public void moverVehiculo(Movimiento movimiento){
        boolean estaEnEsquina = false;
        int i = 0;
        while(i < 3 && !estaEnEsquina){
            vehiculo.movermeHacia(movimiento);
            grilla.moverVehiculo(vehiculo);
            vehiculo = vehiculo.cambiasteVehiculo();
            estaEnEsquina = vehiculo.estasEnEsquiana();
            i++;
        }
    }
}
