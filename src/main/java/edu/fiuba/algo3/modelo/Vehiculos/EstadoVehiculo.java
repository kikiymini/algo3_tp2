package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Obstaculo.Calle;
import edu.fiuba.algo3.modelo.Obstaculo.Esquina;
import edu.fiuba.algo3.modelo.Obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.Obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.Obstaculo.Piquete;
import edu.fiuba.algo3.modelo.Obstaculo.Pozo;

public interface EstadoVehiculo {
    int accionar(Obstaculo obstaculo);

    int accionar(Pozo pozo);

    int accionar(Piquete piquete);

    int accionar(ControlPolicial control);

    EstadoVehiculo cambiarVehiculo();

    int accionar(Calle calle);

    int accionar(Esquina esquina);
    boolean sosEstado(EstadoVehiculo estado);
    //boolean sosEstado(Auto auto);
    //boolean sosEstado(Moto moto);
    //boolean sosEstado(TodoTerreno todoTerreno);
}