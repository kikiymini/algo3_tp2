package edu.fiuba.algo3.modelo.Obstaculo;

import edu.fiuba.algo3.modelo.Accionable;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.TodoTerreno;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public interface Obstaculo extends Accionable {

    int aplicarPenalizacion(Vehiculo vehiculo);

    int aplicarPenalizacion(Moto moto);

    int aplicarPenalizacion(Auto auto);

    int aplicarPenalizacion(TodoTerreno todoTerreno);

}
