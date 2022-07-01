package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Movimiento.Abajo;
import edu.fiuba.algo3.modelo.Movimiento.Arriba;
import edu.fiuba.algo3.modelo.Movimiento.Derecha;
import edu.fiuba.algo3.modelo.Movimiento.Izquierda;

import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Vehiculos.EstadoVehiculo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GPS {

    protected Jugador jugador;
    private Ciudad ciudad;
    private Posicion posMeta;
    public RegistroJugadores registro;

    public GPS(String nombreJuagdor) throws IOException {
        this.ciudad = new Ciudad();
        this.registro = new RegistroJugadores("registroPuntaje.txt");
        this.jugador = new Jugador(nombreJuagdor);
    }

    public ArrayList<Integer> obtenerTamanioEjesMapa() {
        return ciudad.obtenerTamanioEjesMapa();
    }

    public int obtenerPuntaje(String nombre) throws IOException {
        return registro.obtenerPuntajeJugador(nombre);
    }

    public void movermeHacia(Movimiento movimiento) {
        ciudad.moverVehiculo(movimiento);
    }

    public Accionable obtenerAccionableEnPosicion(int x, int y){
        return ciudad.obtenerAccionableEnPosicion(x, y);
    }

    public Posicion obtenerPosicionVehiculo() {
        return ciudad.obtenerPosiscionVehiculo();
    }

    public EstadoVehiculo obtenerEstadoVehiculo() {
        return ciudad.otenerEstadoVehiculo();

    }

    public void moverVehiculoIzquierda() {
        ciudad.moverVehiculo(new Izquierda());
    }
    public void moverVehiculoDerecha() {
        ciudad.moverVehiculo(new Derecha());
    }
    public void moverVehiculoArriba() {
        ciudad.moverVehiculo(new Arriba());
    }
    public void moverVehiculoAbajo() {
        ciudad.moverVehiculo(new Abajo());
    }


    public int obtenerMovimientos() {
        return ciudad.obtenerCantidadDeMovimientosVehiculo();
    }

    public boolean juegoTermiando() {
       boolean bol = ciudad.juegoFinalizado();
       return bol;
    }

    public void guardarJugador() throws IOException {
        jugador.calcularPuntaje(obtenerMovimientos());
        registro.agregarJugadorAlRegistro(jugador);
    }
}
