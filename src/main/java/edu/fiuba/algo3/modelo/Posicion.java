package edu.fiuba.algo3.modelo;
import edu.fiuba.algo3.modelo.Excepciones.PosicionInvalidaError;
import java.util.ArrayList;

public class Posicion {
    private int posX;
    private int posY;
    private int ultimaPosEnEsquinaX;
    private int ultimaPosEnEsquinaY;

    private boolean esPosValida(int posX, int posY){
        return( posX >= 0 && posY >= 0);
    }

    public Posicion(int posX, int posY) {
        if( !esPosValida(posX, posY) ) throw new PosicionInvalidaError();

        this.posX = posX;
        this.posY = posY;
    }


    public void establecerPosX(int posX) {
        this.posX = posX;
        if (this.esMultiploDe3(posX)) ultimaPosEnEsquinaX = posX;
    }

    public void establecerPosY(int posY) {
        this.posY = posY;
        if (this.esMultiploDe3(posY)) ultimaPosEnEsquinaY = posY;
    }

    public void incrementarX(){
        this.establecerPosX(posX + Constantes.valorDeIncrementoDePosicion);
    }

    public void decrementarX(){
        //if(this.posX == 0) return;
        this.establecerPosX(posX - Constantes.valorDeIncrementoDePosicion);
    }

    public void incrementarY(){
        this.establecerPosY(posY + Constantes.valorDeIncrementoDePosicion);
    }

    public void decrementarY(){
        this.establecerPosY(posY - Constantes.valorDeIncrementoDePosicion);
    }

    public void establecerEnUltimaPos(){
        this.establecerPosX(ultimaPosEnEsquinaX);
        this.establecerPosY(ultimaPosEnEsquinaY);
    }


    public static boolean posicionesCoincidenEnCoords(Posicion pos1, Posicion pos2){
        return (pos1.posX == pos2.posX) && (pos1.posY == pos2.posY);
    }

    public ArrayList<Integer> obtenerPos(){
        ArrayList <Integer> pos = new ArrayList<>();
        pos.add(posX);
        pos.add(posY);
        return pos;
    }

    //ver
    public boolean estasEnEsquina(){
       return esMultiploDe3(posX) && esMultiploDe3(posY); // ver si funciona correctamente
    }

    private boolean esMultiploDe3(Integer num){
        return num % 3 == 0;
    }

    public int obtenerPosX() {
        return posX;
    }
    public int obtenerPosY() {
        return posY;
    }

    @Override
    public boolean equals(Object posicion){
        Posicion posicionTemp = (Posicion)posicion;
        if((posicionTemp.posX == this.posX) && posicionTemp.posY == this.posY) {
            return true;
        }

        return false;
    }
}
