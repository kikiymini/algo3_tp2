package edu.fiuba.algo3.modelo;

import java.util.Scanner;

public class GPS {

    private Jugador jugador;
    private Ciudad ciudad;
    private Posicion posMeta;

    public GPS(){
        this.ciudad = new Ciudad();
        this.jugador = new Jugador(GPS.obtenerNombreJugador());
        this.posMeta = ciudad.conseguirPosValidaDeMeta();
        ciudad.insertarAccionablesSegunPosVehiculoYPosMeta(this.posMeta);
    }

    private static String obtenerNombreJugador() {
        Scanner lectorComandos = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");

        return lectorComandos.nextLine();
    }

}
