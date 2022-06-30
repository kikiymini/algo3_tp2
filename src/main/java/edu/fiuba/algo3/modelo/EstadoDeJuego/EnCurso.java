package edu.fiuba.algo3.modelo.EstadoDeJuego;

public class EnCurso implements EstadoJuego{

    @Override
    public String obtenerMensajeJuego() {
        return "En Curso";
    }

    @Override
    public boolean juegoFinalizado() {
        return false;
    }
}
