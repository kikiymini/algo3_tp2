package edu.fiuba.algo3.modelo.EstadoDeJuego;

public class Ganado  implements EstadoJuego{

    @Override
    public String obtenerMensajeJuego() {
        return "Ganaste!";
    }

    @Override
    public boolean juegoFinalizado() {
        return true;
    }

}
