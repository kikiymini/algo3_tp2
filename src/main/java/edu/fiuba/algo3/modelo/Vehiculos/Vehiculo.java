package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.EstadoDeJuego.EnCurso;
import edu.fiuba.algo3.modelo.EstadoDeJuego.EstadoJuego;
import edu.fiuba.algo3.modelo.EstadoDeJuego.Ganado;
import edu.fiuba.algo3.modelo.Movimiento.Movimiento;
import edu.fiuba.algo3.modelo.Obstaculo.Obstaculo;
import edu.fiuba.algo3.modelo.Posicion;

import java.util.ArrayList;
import java.util.Random;

public class Vehiculo {

    protected Posicion posicion;
    protected int movimientos;
    protected static Random RNG = new Random(); //0-1 penalizacion
    protected EstadoVehiculo estado;
    private EstadoJuego estadoJuego = new EnCurso();

    public Vehiculo (Posicion pos){
        this.posicion = pos;
        estado = obtenerVehiculoAlAzar(posicion);
    }

    public void posicionarVehiculo(int posicionX, int posicionY){
        this.posicion = new Posicion(posicionX, posicionY);
    }

    public void movermeHacia(Movimiento movimiento){
        movimiento.mover(posicion);
    }

    public void modificarMovimientosSegunFactor(double factor) {
        this.movimientos *= factor;
    }

    public static EstadoVehiculo obtenerVehiculoAlAzar(Posicion posInicial){
        ArrayList <EstadoVehiculo> vehiculos = generarListaDeVehiculos(posInicial);
        int random = new Random().nextInt(3);
        return (vehiculos.get(random));
    }

    public void accionar(Obstaculo obstaculo){
        movimientos += estado.accionar(obstaculo);
    }

    public boolean estasEnEsquiana(){
        return posicion.estasEnEsquina();
    }

    public void cambiarVehiculo(){
        estado = estado.cambiarVehiculo();
    }

    public Posicion obtenerPosVehiculo(){
        return this.posicion;
    }

    public ArrayList<Integer> obtenerPos(){
        return posicion.obtenerPos();
    }

    private static ArrayList <EstadoVehiculo> generarListaDeVehiculos(Posicion posInicial){
        ArrayList <EstadoVehiculo> vehiculos = new ArrayList <>();
        vehiculos.add(new Auto(posInicial));
        vehiculos.add(new Moto(posInicial));
        vehiculos.add(new TodoTerreno(posInicial));
        return vehiculos;
    }
    //Metodos para probar (Hay que crear fake objects despues)

    public int obtenerCantidadDeMovimientos(){return movimientos;}

    public EstadoVehiculo obtenerEstado() {
        return estado;
    }

    public void ganaste() {
        estadoJuego = new Ganado();
    }

    public boolean juegoFinalizado() {
        return estadoJuego.juegoFinalizado();
    }
}
