package edu.fiuba.algo3.modelo.Obstaculo;

import edu.fiuba.algo3.modelo.Accionable;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.TodoTerreno;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public interface Obstaculo extends Accionable {

    void aplicarPenalizacion(Vehiculo vehiculo);

    /*void aplicarPenalizacion(Moto moto);

    void aplicarPenalizacion(Auto auto);

    void aplicarPenalizacion(TodoTerreno todoTerreno);*/

}
