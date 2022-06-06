package edu.fiuba.algo3.CampoJuego;

import edu.fiuba.algo3.Cosas.Posicion;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Mapa {

    public HashMap<Integer, Posicion> mapa = new HashMap<>();

    public int posicionesOcupadas(){
        List<Posicion> posiciones = new ArrayList<>(mapa.values());
        List<Posicion> posicionesOcupadas = posiciones.stream().filter(a -> a.devolverEstado()).collect(Collectors.toList());
        return (posicionesOcupadas.size());
    }

    public void agregarObstaculos(){
        //RANDOM

    }

    public void mover(Posicion posicion){
        //obtenerContenido(posicion,vehiculo) ver lo de celdas
    }



}
