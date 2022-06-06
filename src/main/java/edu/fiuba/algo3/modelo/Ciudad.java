package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.Obstaculo.Piquete;
import edu.fiuba.algo3.modelo.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

import java.util.Random;

public class Ciudad {

    protected Grilla grilla;
    protected int cantSorpresas;
    protected int cantControlesPoliciales;
    protected int cantPozos;
    protected int cantPiquetes;
    protected Posicion posIniVehiculo;
    protected Posicion posMeta;
    protected Vehiculo vehiculo;


    private static Random RNG = new Random();


    public Ciudad(){
        this.grilla = new Grilla();
        this.vehiculo = Vehiculo.obtenerVehiculoAlAzar(this.conseguirPosIniValidaDeVehiculo());
        this.posIniVehiculo = vehiculo.obtenerPosVehiculo();
    }

    public void insertarAccionablesSegunPosVehiculoYPosMeta(Posicion posMeta){
        this.posMeta = posMeta;
        this.calcularCantidadesDeAccionables();
        this.insertarAccionablesEnGrilla();
    }

    private void calcularCantidadesDeAccionables(){
        int cantPosVal = this.grilla.obtenerCantTotalDePosValidas();
        this.cantSorpresas = (int) (cantPosVal * Constantes.cantidadDeSorpresasPorPosicionValida);
        this.cantControlesPoliciales = (int) (cantPosVal * Constantes.cantidadDePoliciasPorPosicionValida);
        this.cantPozos = (int) (cantPosVal * Constantes.cantidadDePozosPorPosicionValida);
        this.cantPiquetes = (int) (cantPosVal * Constantes.cantidadDePiquetesPorPosicionValida);
    }

    private void insertarAccionablesEnGrilla(){
        this.insertarSorpresasEnGrilla();
        this.insertarControlesPolicialesEnGrilla();
        this.insertarPozosEnGrilla();
        this.insertarPiquetesEnGrilla();
    }

    private void insertarSorpresasEnGrilla(){
        // No lo hice por temas que deberiamos acordar en discord.
    }

    private void insertarControlesPolicialesEnGrilla(){
        ControlPolicial controlPolicial;
        int cantControlesPolicialesEjeX = (int) (this.cantControlesPoliciales * Constantes.porcentajeDeAccionablesEnEjeX);
        int cantControlesPolicialesEjeY = this.cantControlesPoliciales - cantControlesPolicialesEjeX;

        for (int i = 0; i < cantControlesPolicialesEjeX; i++){
            controlPolicial = new ControlPolicial();
            this.insertarAccionableEnEjeXDeGrilla(controlPolicial);
        }
        for (int j = 0; j < cantControlesPolicialesEjeY; j++){
            controlPolicial = new ControlPolicial();
            this.insertarAccionableEnEjeYDeGrilla(controlPolicial);
        }

    }

    private void insertarPozosEnGrilla(){
        Pozo pozo;
        int cantPozosEjeX = (int) (this.cantPozos * Constantes.porcentajeDeAccionablesEnEjeX);
        int cantPozosEjeY = this.cantPozos - cantPozosEjeX;

        for (int i = 0; i < cantPozosEjeX; i++){
            pozo = new Pozo();
            this.insertarAccionableEnEjeXDeGrilla(pozo);
        }
        for (int j = 0; j < cantPozosEjeY; j++){
            pozo = new Pozo();
            this.insertarAccionableEnEjeYDeGrilla(pozo);
        }
    }

    private void insertarPiquetesEnGrilla(){
        Piquete piquete;
        int cantPiquetesEjeX = (int) (this.cantPiquetes * Constantes.porcentajeDeAccionablesEnEjeX);
        int cantPiquetesY = this.cantPiquetes - cantPiquetesEjeX;

        for (int i = 0; i < cantPiquetesEjeX; i++){
            piquete = new Piquete();
            this.insertarAccionableEnEjeXDeGrilla(piquete);
        }
        for (int j = 0; j < cantPiquetesY; j++){
            piquete = new Piquete();
            this.insertarAccionableEnEjeYDeGrilla(piquete);
        }
    }

    private void insertarAccionableEnEjeXDeGrilla(Accionable accionable){
        Posicion posAInsertar;
        do {
            posAInsertar = this.conseguirAzarPosEnCalleHorizontal();
        } while (this.esPosYaOcupada(posAInsertar));

        this.grilla.insertarAccionableEnPosicion(posAInsertar, accionable);
    }

    private void insertarAccionableEnEjeYDeGrilla(Accionable accionable){
        Posicion posAInsertar;
        do {
            posAInsertar = this.conseguirAzarPosEnCalleVertical();
        } while (this.esPosYaOcupada(posAInsertar));

        this.grilla.insertarAccionableEnPosicion(posAInsertar, accionable);
    }

    // Las calles son horizontales cuando Y es multiplo de 3.
    private Posicion conseguirAzarPosEnCalleHorizontal(){
        return new Posicion(Ciudad.conseguirPosConMaxYNoMultiplo(this.grilla.obtenerTamanioEjeX(), 3),
                Ciudad.conseguirPosConMaxYMultiplo(this.grilla.obtenerTamanioEjeY(), 3));
    }

    // Las calles son verticales cuando X es multiplo de 3.
    private Posicion conseguirAzarPosEnCalleVertical(){
        return new Posicion(Ciudad.conseguirPosConMaxYMultiplo(this.grilla.obtenerTamanioEjeX(), 3),
                Ciudad.conseguirPosConMaxYNoMultiplo(this.grilla.obtenerTamanioEjeY(), 3));
    }

    private boolean esPosYaOcupada(Posicion pos){
        return (this.grilla.obtenerAccionableEnPosicion(pos) == null)
                || Posicion.posicionesCoincidenEnCoords(this.posIniVehiculo, pos)
                || Posicion.posicionesCoincidenEnCoords(this.posMeta, pos);
    }

    public Posicion conseguirPosIniValidaDeVehiculo(){
        return new Posicion(Constantes.posIniEnXDeVehiculo,
                Ciudad.conseguirPosConMaxYMultiplo(this.grilla.obtenerTamanioEjeY(), 3));
    }

    public Posicion conseguirPosValidaDeMeta(){
        return new Posicion(this.grilla.obtenerTamanioEjeX(),
                Ciudad.conseguirPosConMaxYMultiplo(this.grilla.obtenerTamanioEjeY(), 3));
    }

    // Una pos va a ser multiplo de un valor, cuando pos%valorMultiplo == 0.
    private static int conseguirPosConMaxYMultiplo(int valorMaximo, int valorMultiplo){
        int pos = RNG.nextInt(valorMaximo) + 1;
        while ( ( pos %valorMultiplo ) != 0){
            pos = RNG.nextInt(valorMaximo) + 1;
        }

        return pos;
    }

    // Una pos va a no ser multiplo de un valor, cuando pos%valorNoMultiplo != 0.
    private static int conseguirPosConMaxYNoMultiplo(int valorMaximo, int valorNoMultiplo){
        int pos = RNG.nextInt(valorMaximo) + 1;
        while ( ( pos %valorNoMultiplo ) == 0){
            pos = RNG.nextInt(valorMaximo) + 1;
        }

        return pos;
    }

    public void moverVehiculoArriba(){
        for(int i = 0; i < 2; i++){
            vehiculo.moverArriba();
            grilla.moverVehiculo(vehiculo);
            if (vehiculo.estasEnEsquiana()) break; // esto rompe pilares poo. No se como manejar caso de piquete
        }
    }

    public void moverVehiculoAbajo(){
        for(int i = 0; i < 2; i++){
            vehiculo.moverAbajo();
            grilla.moverVehiculo(vehiculo);
            if (vehiculo.estasEnEsquiana()) break; // esto rompe pilares poo. No se como manejar caso de piquete
        }
    }

    public void moverVehiculoIzquierda(){
        for(int i = 0; i < 2; i++){
            vehiculo.moverIzquierda();
            grilla.moverVehiculo(vehiculo);
            if (vehiculo.estasEnEsquiana()) break; // esto rompe pilares poo. No se como manejar caso de piquete
        }
    }

    public void moverVehiculoDerecha(){
        for(int i = 0; i < 2; i++){
            vehiculo.moverDerecha();
            grilla.moverVehiculo(vehiculo);
            if (vehiculo.estasEnEsquiana()) break; // esto rompe pilares poo. No se como manejar caso de piquete
        }
    }
}
