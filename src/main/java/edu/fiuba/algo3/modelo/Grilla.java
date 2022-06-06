package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

import java.util.ArrayList;
import java.util.Random;

public class Grilla {

    protected Accionable[][] grilla;
    private int cantEsquinasEjeX;
    private int cantEsquinasEjeY;
    private int tamanioEjeX;
    private int tamanioEjeY;


    private static Random RNG = new Random();


    public Grilla(){
        this.asignarCantidadesDeEsquinas();
        this.asignarTamaniosEjes();
        this.grilla = new Accionable[this.tamanioEjeX][this.tamanioEjeY];
    }

    public int obtenerTamanioEjeX(){
        return this.tamanioEjeX;
    }

    public int obtenerTamanioEjeY(){
        return this.tamanioEjeY;
    }

    private int obtenerCantTotalDePosiciones(){
        return this.tamanioEjeX * this.tamanioEjeY;
    }

    private int obtenerCantTotalDeManzanas(){
        return (this.cantEsquinasEjeX + 1) * (this.cantEsquinasEjeY + 1);
    }

    private int obtenerCantTotalPosicionesDeManzanas(){
        return this.obtenerCantTotalDeManzanas() * 4;
    }

    private int obtenerCantTotalDeEsquinas(){
        return this.cantEsquinasEjeX * this.cantEsquinasEjeY;
    }

    public int obtenerCantTotalDePosValidas(){
        return this.obtenerCantTotalDePosiciones() - this.obtenerCantTotalPosicionesDeManzanas() - this.obtenerCantTotalDeEsquinas();
    }

    public Accionable obtenerAccionableEnPosicion(Posicion pos){
        return grilla[pos.obtenerPosX() - 1][pos.obtenerPosY() - 1];
    }

    public void insertarAccionableEnPosicion(Posicion pos, Accionable objeto){
        grilla[pos.obtenerPosX() - 1][pos.obtenerPosY() - 1] = objeto;
    }

    private void asignarCantidadesDeEsquinas(){
        this.cantEsquinasEjeX = Grilla.conseguirUnaCantEsquinasPorEje();
        this.cantEsquinasEjeY = Grilla.conseguirUnaCantEsquinasPorEje();
    }

    private void asignarTamaniosEjes(){
        this.tamanioEjeX = (this.cantEsquinasEjeX * 3) + 2;
        this.tamanioEjeY = (this.cantEsquinasEjeY * 3) + 2;
    }


    private static int conseguirUnaCantEsquinasPorEje(){
        return RNG.nextInt(Constantes.cantidadMaximaDeEsquinasPorEje - Constantes.cantidadMinimaDeEsquinasPorEje) + Constantes.cantidadMinimaDeEsquinasPorEje;
    }

    public void moverVehiculo(Vehiculo vehiculo) {
        ArrayList<Integer> pos = vehiculo.obtenerPos();
        grilla[pos.get(0)][pos.get(1)].accionar(vehiculo);
    }


}
