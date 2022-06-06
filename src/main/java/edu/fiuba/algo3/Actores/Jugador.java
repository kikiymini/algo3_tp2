package edu.fiuba.algo3.Actores;

import edu.fiuba.algo3.CampoJuego.Mapa;
import edu.fiuba.algo3.Cosas.Movimiento;
import edu.fiuba.algo3.Cosas.Posicion;
import edu.fiuba.algo3.ElementosJuego.Vehiculo;

public class Jugador {

    private Vehiculo vehiculo;
    private Mapa mapa; //cuando lo creamos???


    public Jugador registrarJugador(Vehiculo vehiculo){
        Jugador jugador = new Jugador();
        jugador.vehiculo = vehiculo;
        return jugador;
    }

    public void moverHacia(Movimiento unMovimiento){
        Posicion posicion = vehiculo.nuevaPosicion(unMovimiento);
        mapa.mover(posicion);

    }
}
