package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestArchivo {

    @Test
    public void testPuedoAgregarJugadoresAMiArchivoCorrectamente() throws IOException {
        File myFile = new File("src/main/test/edu/fiuba/algo3/modelo/recursos/archivo.txt");
        String path = myFile.getAbsolutePath();
        Archivo a = new Archivo(path);

        a.agregarJugador(new Jugador("Carolina"));
        a.agregarJugador(new Jugador("Penelope"));
        String lectura = a.leer();
        String res = "Carolina;0;Penelope;0;";

        assertEquals(true,lectura.contains(res));
    }

    @Test
    public void testPuedoObtenerElPuntajeDeUnJugadorCorrectamente(){
        File myFile = new File("src/main/test/edu/fiuba/algo3/modelo/recursos/archivo1.txt");
        String path = myFile.getAbsolutePath();
        Archivo a = new Archivo(path);
        int puntaje = a.obtenerPuntajeJugador("Mateo");

        assertEquals(10,puntaje);

    }
}
