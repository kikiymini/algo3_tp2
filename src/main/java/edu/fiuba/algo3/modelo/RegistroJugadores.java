package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public class RegistroJugadores {

    private HashMap jugadores = new HashMap();

    public int obtenerPuntajeJugador(Jugador jugador){
        if(jugadores.get(jugador.obtenerNombre()) != null){
            return jugador.puntajeObtenido();
        }
        else{
            return 0;
        }
    }

    public void agregarJugadorAlRegistro(Jugador jugador){
        jugadores.put(jugador.obtenerNombre(),jugador);
    }

    public int cantidadDeJugadores(){
        return jugadores.size();
    }

    protected boolean existeJugador(String nombre){
        return jugadores.containsKey(nombre);
    }
}
