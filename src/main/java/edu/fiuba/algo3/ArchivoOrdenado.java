package edu.fiuba.algo3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ArchivoOrdenado {
    private ArrayList<JugadorArchivo> jugadores = new ArrayList<>();
    private String linea;
    private String[] partes = null;
    public void leerArchivo(String rutaArchivo) {
        try {
            Scanner input = new Scanner(new File(rutaArchivo));
            while (input.hasNextLine()) {
                linea = input.nextLine();
                partes = linea.split(";");
                jugadores.add(new JugadorArchivo(partes[0],partes[1]));
            }
            input.close();
            Collections.sort(jugadores, new Comparator<JugadorArchivo>() {
                @Override
                public int compare(JugadorArchivo j1, JugadorArchivo j2) {
                    return ((j1.getPuntos()).compareTo((j2.getPuntos())));
                }
            });
            borrarArchivo();
            for(JugadorArchivo aux: jugadores){
                escribirNuevoArchivo(aux);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void escribirNuevoArchivo(JugadorArchivo jugador) throws IOException {
        String ruta = "rankingPuntaje2.txt";
        BufferedWriter buffer = new BufferedWriter(new FileWriter(ruta,true));
        buffer.write(jugador.getNombre() +";" + jugador.getPuntos() + "\n");
        buffer.close();
    }

    private void borrarArchivo() throws IOException {
        String ruta = "rankingPuntaje2.txt";
        BufferedWriter buffer = new BufferedWriter(new FileWriter(ruta));
        buffer.write("");
        buffer.close();
    }
}
