package edu.fiuba.algo3.modelo.Excepciones;

public class PosicionInvalidaError extends RuntimeException {
    public PosicionInvalidaError(){
        super(" La posición no es válida ");
    }
}
