package edu.fiuba.algo3;

public class JugadorArchivo {
    private String nombre;
    private String puntos;

    public JugadorArchivo(String nombre, String puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public String getPuntos() {
        return this.puntos;
    }

    public String getNombre() {
        return  this.nombre;
    }
}
