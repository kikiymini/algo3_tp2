package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Grilla.Grilla;
import edu.fiuba.algo3.modelo.Grilla.InicializadorGrilla;
import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Vehiculos.EstadoVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

import java.util.ArrayList;
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
        this.vehiculo = new Vehiculo(inicializador.conseguirPosIniValidaDeVehiculo());
        this.posIniVehiculo = vehiculo.obtenerPosVehiculo();
        inicializador.insertarAccionables();

    }

    public void moverVehiculo(Movimiento movimiento){
        boolean estaEnEsquina = false;
        int i = 0;
        while(i < 3 && !estaEnEsquina){
            vehiculo.movermeHacia(movimiento);
            grilla.moverVehiculo(vehiculo);
            estaEnEsquina = vehiculo.estasEnEsquiana();
            i++;
        }
    }

    public ArrayList<Integer> obtenerTamanioEjesMapa() {
        int tamanioEjeX = grilla.obtenerTamanioEjeX();
        int tamanioEjeY = grilla.obtenerTamanioEjeY();
        ArrayList<Integer> tamanioEjes = new ArrayList<>();
        tamanioEjes.add(tamanioEjeX);
        tamanioEjes.add(tamanioEjeY);
        return tamanioEjes;
    }

    public Accionable obtenerAccionableEnPosicion(int x, int y){
        return grilla.obtenerAccionableEnPosicion(new Posicion(x, y));
    }

    public Posicion obtenerPosiscionVehiculo() {
        return vehiculo.obtenerPosVehiculo();
    }

    public EstadoVehiculo otenerEstadoVehiculo() {
        return vehiculo.obtenerEstado();
    }

    public int obtenerCantidadDeMovimientosVehiculo() {
        return vehiculo.obtenerCantidadDeMovimientos();
    }

    public boolean juegoFinalizado() {
        return vehiculo.juegoFinalizado();
    }
}
