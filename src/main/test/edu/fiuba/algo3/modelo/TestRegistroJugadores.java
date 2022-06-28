package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.io.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestRegistroJugadores {

    @Test
    public void puedoRegistrarJugadoresCorrectamente() throws IOException {
        RegistroJugadores registro = new RegistroJugadores("registroPuntaje.txt");

        registro.agregarJugadorAlRegistro(new Jugador("lloojsojso"));

        assertEquals(true,registro.existeJugador("lloojsojso"));
    }
}
