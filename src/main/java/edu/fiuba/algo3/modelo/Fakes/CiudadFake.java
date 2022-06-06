package edu.fiuba.algo3.modelo.Fakes;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Grilla;
import edu.fiuba.algo3.modelo.Posicion;

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
        pos.establecerPosX(1);
        pos.establecerPosY(1);
    }

    public void crearGrillaConAccionables() {
        grilla.crearGrillaConAccionables();
    }
}
