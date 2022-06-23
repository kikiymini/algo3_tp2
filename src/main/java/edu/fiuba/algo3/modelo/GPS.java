package edu.fiuba.algo3.modelo;

import java.util.Scanner;

public class GPS {

    protected Jugador jugador;
    private Ciudad ciudad;
    private Posicion posMeta;
    protected RegistroJugadores registro;

    public GPS(){
        this.ciudad = new Ciudad();
        this.jugador = new Jugador(obtenerJugadadorUnico());
        this.registro = new RegistroJugadores();
        this.registro.agregarJugadorAlRegistro(this.jugador);
    }

    private static String obtenerNombreJugador() {
        Scanner lectorComandos = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");

        return lectorComandos.nextLine();
    }

    private String obtenerJugadadorUnico(){
        String nombre = obtenerNombreJugador();
        while (registro.existeJugador(nombre)){
            System.out.println("Ya existe un jugador con ese nombre: ");
            nombre = obtenerNombreJugador();
        }
        return nombre;
    }

// id unico
//    public int obtenerPuntajeJugador(Jugador jugador){
//        return jugador.puntajeObtenido();
//    }

}
