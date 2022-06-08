package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Fakes.CiudadFake;
import edu.fiuba.algo3.modelo.Fakes.GrillaFake;
import edu.fiuba.algo3.modelo.Grilla.Grilla;
import edu.fiuba.algo3.modelo.Movimiento.Adelante;
import edu.fiuba.algo3.modelo.Movimiento.Derecha;
import edu.fiuba.algo3.modelo.Obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega1Test {

    @Test
    public void motoAtraviesaCiudadYSeEncuentraUnPozoEsPenalizadaPorTresMovimientos(){
        /*Ciudad ciudad = new Ciudad();
        Posicion posicion = ciudad.vehiculo.obtenerPosVehiculo();
        System.out.println(posicion.obtenerPosX()); // comentar esto
        System.out.println(posicion.obtenerPosY()); // comentar esto
        // HACERLO MAS LINDO
        Obstaculo pozo = new Pozo();
        Posicion posicionEsperada = new Posicion(1,ciudad.vehiculo.obtenerPosVehiculo().obtenerPosY()-1);
        ciudad.vehiculo.movermeHacia(new Derecha());
        ciudad.vehiculo.movermeHacia(new Derecha());
        assertEquals(5,ciudad.vehiculo.cantidadDeMovimientos());*/

        CiudadFake ciudad = new CiudadFake();
        ciudad.setearVehiculoOrigen();
        ciudad.colocarCallesEnGrilla();
        ciudad.setearVehiculo(new Moto(new Posicion(0,0)));
        ciudad.ponerAccionableEnPosicion(4, 0, new Pozo());
        for (int i = 0; i < 6 ; i++){
            ciudad.vehiculo.movermeHacia(new Adelante());// no deberiamos meternos con los atributos de ciudad.(creo)
        }
        assertEquals(9,ciudad.vehiculo.cantidadDeMovimientos());

    }
}
