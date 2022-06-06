package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.CampoJuego.Mapa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MapaTest {

    @Test
    public void test01CrearMapaVacio() {
        Mapa mapa = new Mapa();
        assertEquals(0,mapa.posicionesOcupadas());

    }

    @Test
    public void test02CrearMapaConObstaculos() {
        Mapa mapa = new Mapa();

        mapa.agregarObstaculos();

        assertEquals(true,mapa.conObstaculos());


    }

/*
    @Test
    public void test02CrearMapaConObstaculos() {
        Mapa mapa = new Mapa();

        mapa.cargarObstaculos();
    }*/



}
