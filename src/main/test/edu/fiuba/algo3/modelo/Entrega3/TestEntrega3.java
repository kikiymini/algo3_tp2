package edu.fiuba.algo3.modelo.Entrega3;

import edu.fiuba.algo3.modelo.Fakes.GPSFake;
import edu.fiuba.algo3.modelo.Jugador;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEntrega3 {

    @Test
    public void testNoPuedoTenerEnMiGPSDosJugadoresConIgualNombre() throws IOException {
        Jugador j1 = new Jugador("Caro");
        Jugador j2 = new Jugador("Caro");
        GPSFake gps = new GPSFake("archivo4.json");

        gps.agregarJugador(j1);
        gps.agregarJugador(j2);

        assertEquals(1,gps.cantidadJugadores());

    }





}
