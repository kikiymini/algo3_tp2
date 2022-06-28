package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Movimiento.Abajo;
import edu.fiuba.algo3.modelo.Movimiento.Arriba;
import edu.fiuba.algo3.modelo.Movimiento.Derecha;
import edu.fiuba.algo3.modelo.Movimiento.Izquierda;
import edu.fiuba.algo3.modelo.Vehiculos.EstadoVehiculo;

import java.util.ArrayList;
import java.util.Scanner;

public class GPS {

    private Jugador jugador;
    private Ciudad ciudad;
    private Posicion posMeta;

    public GPS(){
        this.ciudad = new Ciudad();
        //this.jugador = new Jugador(GPS.obtenerNombreJugador());
    }
    /*
    private static String obtenerNombreJugador() {
        Scanner lectorComandos = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");

        return lectorComandos.nextLine();
    }
    */
    public ArrayList<Integer> obtenerTamanioEjesMapa(){
       return ciudad.obtenerTamanioEjesMapa();
    }

    public Accionable obtenerAccionableEnPosicion(int x, int y){
        return ciudad.obtenerAccionableEnPosicion(x, y);
    }

    public Posicion obtenerPosicionVehiculo() {
        return ciudad.obtenerPosiscionVehiculo();
    }

    public EstadoVehiculo otenerEstadoVehiculo() {
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


}
