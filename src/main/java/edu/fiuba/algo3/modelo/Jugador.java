package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Excepciones.NombreVacioError;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.TodoTerreno;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Jugador{

    private String nombre;
    private int cantMovimientos;
    //private String id;
    private Puntaje puntaje;

    public Jugador(String nombre){
        if( nombre.isEmpty() ){
            throw new NombreVacioError();
        }
        this.nombre = nombre;
       // this.id = generarCodigoJugador();
    }

    public String obtenerNombre(){
        return this.nombre;
    }

//    private String generarCodigoJugador(){
//        UUID uuid = UUID.randomUUID();
//        return uuid.toString();
//    }
//
//    protected String obtenerId(){
//        return this.id;
//    }

    protected int puntajeObtenido(){
        return puntaje.obtenerPuntaje();
    }

}
