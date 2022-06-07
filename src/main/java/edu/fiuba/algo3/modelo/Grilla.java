package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

import java.util.ArrayList;
import java.util.Random;

public class Grilla {

    protected ArrayList<ArrayList<Accionable>> grilla;
    private int tamanioEjeX;
    private int tamanioEjeY;
    private int cantEsquinasEjeX;
    private int cantEsquinasEjeY;

    private static Random RNG = new Random();


    public Grilla(){
        this.asignarCantidadesDeEsquinas();
        this.asignarTamaniosEjes();
        this.grilla = crearGrilla(tamanioEjeX, tamanioEjeY);
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


    private int obtenerCantTotalPosicionesDeManzanas(){
        return  0;//this.obtenerCantTotalDeManzanas() * 4;
    }

    private int obtenerCantTotalDeEsquinas(){
        return  0; //this.cantEsquinasEjeX * this.cantEsquinasEjeY;
    }

    public int obtenerCantTotalDePosValidas(){
        return this.obtenerCantTotalDePosiciones() - this.obtenerCantTotalPosicionesDeManzanas() - this.obtenerCantTotalDeEsquinas();
    }

    public Accionable obtenerAccionableEnPosicion(Posicion pos){
        return grilla.get(pos.obtenerPosY() - 1).get(pos.obtenerPosX());
    }

    public void insertarAccionableEnPosicion(Posicion pos, Accionable objeto){
        ArrayList<Accionable> calle = grilla.get(pos.obtenerPosY() - 1);
        calle.add(pos.obtenerPosX() - 1, objeto);
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
        ArrayList<Integer> pos = vehiculo.obtenerPos(); // esta mal
        Accionable accionable = grilla.get(pos.get(0)).get(pos.get(1));
        accionable.accionar(vehiculo);
    }


    public ArrayList<ArrayList<Accionable>> crearGrilla(int tamanioEjeX, int tamanioEjeY){
        ArrayList<ArrayList<Accionable>> grilla = new ArrayList<>();
        for (int i = 0 ; i < Grilla.this.tamanioEjeY; i++){
            ArrayList<Accionable> calle = new ArrayList<>();
            for(int j = 0; j < tamanioEjeX; j++){
                calle.add(i, new Pozo());
            }
            grilla.add(calle);
        }
        return grilla;
    }
}
