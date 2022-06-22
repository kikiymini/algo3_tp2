package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Obstaculo.Obstaculo;

public interface EstadoVehiculo {

    int pisarPozo();

    int encontrarsePiquete();

    int encontrarseControlPolicial();

    EstadoVehiculo cambiarVehiculo();
}