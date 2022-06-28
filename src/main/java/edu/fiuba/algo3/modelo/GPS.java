package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Movimiento.Movimiento;

import java.io.IOException;
import java.util.Scanner;

public class GPS {

    protected Jugador jugador;
    private Ciudad ciudad;
    private Posicion posMeta;
    protected RegistroJugadores registro;

    public GPS() throws IOException {
        this.ciudad = new Ciudad();
        this.jugador = new Jugador(obtenerJugadadorUnico());
        this.registro = new RegistroJugadores("registroJugadores.json");
        this.registro.agregarJugadorAlRegistro(this.jugador);
    }

    private static String obtenerNombreJugador() {
        Scanner lectorComandos = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");

        return lectorComandos.nextLine();
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

    public void movermeHacia(Movimiento movimiento){
        ciudad.moverVehiculo(movimiento);
        jugador.sumarMovimineto();
    }
}
