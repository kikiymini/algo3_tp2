package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestArchivo {

    @Test
    public void testPuedoLeerUnArchivoDeJugadoresCorrectamente() throws IOException {
        File myFile = new File("src/main/test/edu/fiuba/algo3/modelo/recursos/archivo1.json");
        String path = myFile.getAbsolutePath();
        Archivo a = new Archivo(path);
        String resultado = a.leer();

        assertEquals(true,resultado.contains("{    \"nombre\": \"Carolina\",    \"cantMovimientos\": 10,    \"puntaje\": 1000  }"));
    }

    @Test
    public void testPuedoAgregarDosJugadoresAMiArchivoCorrectamente() throws IOException {
        File myFile = new File("src/main/test/edu/fiuba/algo3/modelo/recursos/archivo2.json");
        String path = myFile.getAbsolutePath();
        Archivo a = new Archivo(path);

        File myfile = new File("archivo2.json").getAbsoluteFile();
        String s = myfile.getAbsolutePath();
        System.out.println(s);


        a.agregarJugador(new Jugador("Penelope"));
        a.agregarJugador(new Jugador("Carolina"));
        boolean res = a.existeJugador("Carolina") && a.existeJugador("Penelope");

        assertEquals(true,res);

    }

    @Test
    public void testPuedoObtenerElPuntajeDeUnJugador() throws IOException {
        File myFile = new File("src/main/test/edu/fiuba/algo3/modelo/recursos/archivo2.json");
        String path = myFile.getAbsolutePath();
        Archivo a = new Archivo(path);

        assertEquals(0,a.obtenerPuntajeJugador("Penelope"));
    }
}
