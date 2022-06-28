package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Vehiculos.EstadoVehiculo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GPS {

    protected Jugador jugador;
    private Ciudad ciudad;
    private Posicion posMeta;
    protected RegistroJugadores registro;

    public GPS() throws IOException {
        this.ciudad = new Ciudad();
        this.jugador = new Jugador(obtenerJugadadorUnico());
        this.registro = new RegistroJugadores("registroPuntaje.txt");
        this.registro.agregarJugadorAlRegistro(this.jugador);
    }

    private static String obtenerNombreJugador() {
        Scanner lectorComandos = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");

        return lectorComandos.nextLine();
    }

    public ArrayList<Integer> obtenerTamanioEjesMapa(){
       return ciudad.obtenerTamanioEjesMapa();
    }

    private String obtenerJugadadorUnico() throws IOException {
        String nombre = obtenerNombreJugador();
        while (registro.existeJugador(nombre)){
            System.out.println("Ya existe un jugador con ese nombre: ");
            nombre = obtenerNombreJugador();
        }
        return nombre;
    }

    public void agregarJugador(Jugador j1) throws IOException {
        String nombre = obtenerJugadadorUnico();
        registro.agregarJugadorAlRegistro(new Jugador(nombre));
    }

    public int obtenerPuntaje(String nombre) throws IOException {
        return registro.obtenerPuntajeJugador(nombre);
    }

    public void movermeHacia(Movimiento movimiento) {
        ciudad.moverVehiculo(movimiento);
        jugador.sumarMovimineto();
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
}
