package edu.fiuba.algo3.modelo.Excepciones;

public class NoExisteJugadorConNombre extends RuntimeException{

    public NoExisteJugadorConNombre(){
        super(" El nombre del jugador no puede ser vacio ");
    }
}
