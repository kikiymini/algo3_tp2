package edu.fiuba.algo3.modelo.Fakes;

import edu.fiuba.algo3.modelo.*;

public class GPSFake {

    protected Jugador jugador;
    protected RegistroJugadores registro;

    public GPSFake(){
        this.jugador = null;
        this.registro = new RegistroJugadores();

    }

    public void agregarJugador(Jugador jugador){
        registro.agregarJugadorAlRegistro(jugador);
        this.jugador = jugador;
    }

    public int cantidadJugadores(){
        return registro.cantidadDeJugadores();
    }
}
