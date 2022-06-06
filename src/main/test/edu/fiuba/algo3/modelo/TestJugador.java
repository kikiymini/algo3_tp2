package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJugador {

        @Test
        public void Test01SeCreaUnJugadorYElNombreEsElCorrecto() {
                Posicion posicion = new Posicion(5, 5);
                Jugador j1 = new Jugador("Felipe");
                assertEquals("Felipe", j1.obtenerNombre());
        }
}

        //No se como comparar una clase generica con una instancia de una clase.
        /*@Test
        public void Test02SeCreaUnJugadorYTieneUnVehiculo(){
                Posicion posicion = new Posicion(5, 5);
                Jugador j1 = new Jugador("Felipe", posicion);
                Vehiculo moto = new Moto(posicion);
                assertEquals(moto, j1.obtenerVehiculo());
        }

        @Test
        public void Test03JugadorSeMueveHaciaLaDerecha(){
                Posicion posicion = new Posicion(5, 5);
                Jugador j1 = new Jugador("Felipe", posicion);
                j1.moverDerecha();
                assertEquals(6, posicion.obtenerPosX());
        }

        @Test
        public void Test04JugadorSeMueveHaciaLaIzquierda(){
                Posicion posicion = new Posicion(5, 5);
                Jugador j1 = new Jugador("Felipe", posicion);
                j1.moverIzquierda();
                assertEquals(4, posicion.obtenerPosX());
        }

        @Test
        public void Test04JugadorSeMueveHaciaArriba(){
                Posicion posicion = new Posicion(5, 5);
                Jugador j1 = new Jugador("Felipe", posicion);
                j1.moverArriba();
                assertEquals(6, posicion.obtenerPosY());
        }

        @Test
        public void Test04JugadorSeMueveHaciaAbajo(){
                Posicion posicion = new Posicion(5, 5);
                Jugador j1 = new Jugador("Felipe", posicion);
                j1.moverAbajo();
                assertEquals(4, posicion.obtenerPosY());
        }

}

*/
