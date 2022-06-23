package edu.fiuba.algo3.modelo.Entrega3;

import edu.fiuba.algo3.modelo.Fakes.CiudadFake;
import edu.fiuba.algo3.modelo.Fakes.GPSFake;
import edu.fiuba.algo3.modelo.GPS;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Movimiento.Abajo;
import edu.fiuba.algo3.modelo.Movimiento.Derecha;
import edu.fiuba.algo3.modelo.Obstaculo.Piquete;
import edu.fiuba.algo3.modelo.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.RegistroJugadores;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.TodoTerreno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEntrega3 {

    @Test
    public void alCrearUnJugadorSeCreaConIdentificadorUnico(){
        Jugador j1 = new Jugador("Caro");
        Jugador j2 = new Jugador("Jorge");
        RegistroJugadores jugadores = new RegistroJugadores();
        jugadores.agregarJugadorAlRegistro(j1);
        jugadores.agregarJugadorAlRegistro(j2);

        assertEquals(2,jugadores.cantidadDeJugadores());
    }

    @Test
    public void NoPuedoTenerEnMiGPSDosJugadoresConIgualNombre(){
        Jugador j1 = new Jugador("Caro");
        Jugador j2 = new Jugador("Caro");
        GPSFake gps = new GPSFake();

        gps.agregarJugador(j1);
        gps.agregarJugador(j2);

        assertEquals(1,gps.cantidadJugadores());

    }
}
