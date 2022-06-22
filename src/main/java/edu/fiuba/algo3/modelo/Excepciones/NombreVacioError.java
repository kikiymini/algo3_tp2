package edu.fiuba.algo3.modelo.Excepciones;

public class NombreVacioError extends RuntimeException{
    public NombreVacioError(){
        super(" El nombre del jugador no puede ser vacio ");
    }
}
