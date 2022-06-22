package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGps {
    @Test
    public void Test01SeCreaUnJugadorYElNombreEsElCorrecto() {
        Posicion posicion = new Posicion(5, 5);
        Jugador j1 = new Jugador("Felipe");
        assertEquals("Felipe", j1.obtenerNombre());
    }
}
