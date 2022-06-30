package edu.fiuba.algo3.modelo.Fakes;

import edu.fiuba.algo3.modelo.Accionable;
import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Grilla.Grilla;
import edu.fiuba.algo3.modelo.Obstaculo.Calle;
import edu.fiuba.algo3.modelo.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Sorpresa.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

import java.util.ArrayList;

public class CiudadFake extends Ciudad {

    public CiudadFake(){

    }
    public CiudadFake(VehiculoFake v){
        vehiculo = v;
        llenarGrillaDe(new Calle());
        inicializador.colocarEsquinasEnGrilla();
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

    public void setearVehiculoEn(int x , int y){
        Posicion pos = vehiculo.obtenerPosVehiculo();
        pos.establecerPosX(x);
        pos.establecerPosY(y);
    }
    public void llenarGrillaDe(Accionable accionable){
        for(int i = 0; i < grilla.obtenerTamanioEjeY(); i++){
            for(int j = 0; j < grilla.obtenerTamanioEjeX(); j++){
                grilla.insertarAccionableEnPosicion(new Posicion(j, i), accionable);
            }
        }
    }

    public void ponerAccionableEnPosicion(int posX, int posY, Accionable accionable){
        grilla.insertarAccionableEnPosicion(new Posicion(posX, posY), accionable);
    }

    public int obtenerCantidadDeMovVehiculo() {
        return vehiculo.obtenerCantidadDeMovimientos();
    }

    public void setearVehiculo(VehiculoFake vehiculo){
        this.vehiculo = vehiculo;
    }

    public int obtenerAnchoCiudad(){return grilla.obtenerTamanioEjeX();}

    public int obtenerLargoCiudad(){return grilla.obtenerTamanioEjeY();}

    public Vehiculo obtenerVehiculo(){
        return vehiculo;
    }

}
