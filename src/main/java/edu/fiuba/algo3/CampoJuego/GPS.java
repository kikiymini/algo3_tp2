package edu.fiuba.algo3.CampoJuego;
import edu.fiuba.algo3.Actores.Jugador;
import edu.fiuba.algo3.Cosas.Movimiento;
import edu.fiuba.algo3.ElementosJuego.Vehiculo;

public class GPS {

    private Vehiculo vehiculo;
    private Jugador jugador;

    public GPS crearGPSConNicknameYVehiculo(String unNickname,Vehiculo unVehiculo){ //ver
        GPS gps = new GPS();
        gps.vehiculo = unVehiculo;
        gps.jugador.registrarJugador(unVehiculo);
        return gps;
    }

    public void recibirMovimiento(Movimiento unMovimiento){
        jugador.moverHacia(unMovimiento);

    }
}
