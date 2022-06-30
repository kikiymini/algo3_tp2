package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public class Meta implements Accionable{
    @Override
    public void accionar(Vehiculo vehiculo) {
        vehiculo.ganaste();
    }

    @Override
    public boolean sosAccionable(Accionable accionable) {
        return this.getClass().equals(accionable.getClass());
    }
}
