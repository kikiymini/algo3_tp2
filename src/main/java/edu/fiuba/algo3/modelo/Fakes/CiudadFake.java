package edu.fiuba.algo3.modelo.Fakes;

import edu.fiuba.algo3.modelo.Accionable;
import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

import java.util.ArrayList;

public class CiudadFake extends Ciudad {

    GrillaFake grilla;

    public CiudadFake(){
        grilla = new GrillaFake();
    }

    public ArrayList<Integer> obtenerPosVehiculo(){
        return vehiculo.obtenerPos();
    }

    public void setearVehiculoOrigen() {
        Posicion pos = vehiculo.obtenerPosVehiculo();
        pos.establecerPosX(0);
        pos.establecerPosY(0);
    }

    public int obtenerPosVehiculoEnX(){
        return obtenerPosVehiculo().get(0);
    }

    public int obtenerPosVehiculoEnY(){
        return obtenerPosVehiculo().get(1);
    }

    public void moverVehiculoDerecha(int cantidad){
        for(int i = 0; i < cantidad; i++){
            vehiculo.moverDerecha();
        }
    }
    public void setearVehiculoEn(int x , int y){
        Posicion pos = vehiculo.obtenerPosVehiculo();
        pos.establecerPosX(x);
        pos.establecerPosY(y);
    }

    public void colocarCallesEnGrilla(){
        grilla.colocarCallesEnGrilla();
    }

    public void ponerAccionableEnPosicion(int posX, int posY, Accionable accionable){
        grilla.insertarAccionableEnPosicion(new Posicion(posX, posY), accionable);
    }

    public int obtenerCantidadDeMovVehiculo() {
        return vehiculo.obtenerCantidadDeMovimientos();
    }

    public void setearVehiculo(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }
}
