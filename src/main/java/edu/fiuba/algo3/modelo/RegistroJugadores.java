package edu.fiuba.algo3.modelo;

import java.io.File;
import java.io.IOException;

public class RegistroJugadores {

    private Archivo registro;

    public RegistroJugadores(String nombreArchivo) {
        File myfile = new File(nombreArchivo).getAbsoluteFile();
        String s = myfile.getAbsolutePath();
        this.registro = new Archivo(s);
    }

    public int obtenerPuntajeJugador(Jugador jugador) throws IOException {
        return registro.obtenerPuntajeJugador(jugador.obtenerNombre());
    }

    public void agregarJugadorAlRegistro(Jugador jugador) throws IOException {
        registro.agregarJugador(jugador);
    }

    public int cantidadDeJugadores() throws IOException {
        return registro.cantidadDeJugadores();
    }

    protected boolean existeJugador(String nombre) throws IOException {
        return registro.existeJugador(nombre);
    }

    public int obtenerPuntajeJugador(String nombre) throws IOException {
        return registro.obtenerPuntajeJugador(nombre);
    }


}
