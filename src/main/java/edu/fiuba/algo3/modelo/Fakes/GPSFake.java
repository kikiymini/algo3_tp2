package edu.fiuba.algo3.modelo.Fakes;

import edu.fiuba.algo3.modelo.*;

import java.io.IOException;

public class GPSFake {

    protected Jugador jugador;
    protected RegistroJugadores registro;

    public GPSFake(String nombre){
        this.jugador = null;
        this.registro = new RegistroJugadores("src/main/test/edu/fiuba/algo3/modelo/recursos/"+nombre);

    }

    public void agregarJugador(Jugador jugador) throws IOException {
        registro.agregarJugadorAlRegistro(jugador);
        this.jugador = jugador;
    }

    public int cantidadJugadores() throws IOException {
        return registro.cantidadDeJugadores();
    }




}
