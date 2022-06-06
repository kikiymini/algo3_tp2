package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.TodoTerreno;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

import java.util.Random;

public class Jugador{

    private String nombre;
    private int cantMovimientos;

    public Jugador(String nombre){
        this.nombre = nombre;
    }

    public String obtenerNombre(){
        return this.nombre;
    }

}
