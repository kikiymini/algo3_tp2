package edu.fiuba.algo3.modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;


public class Archivo {

    private String nombre;

    public Archivo(String nombre){
        this.nombre = nombre;
    }

    public String leer(){
        String puntaje = "";

        try (BufferedReader br = new BufferedReader(new FileReader(this.nombre))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                puntaje += linea;
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return puntaje;
    }

    public void agregarJugador(Jugador jugador) throws IOException {
        try {
            BufferedWriter buffer = new BufferedWriter(new FileWriter(this.nombre,true));
            buffer.write(jugador.obtenerNombre() + ";" + jugador.puntajeObtenido() + ";" + "\n");
            buffer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public boolean existeJugador(String nombre){
        return this.leer().contains(nombre);
    }

    public HashMap obtenerJugadores(){
        String lectura = leer();
        String[] aux = lectura.split(";");
        HashMap jugadores = new HashMap();
        int i = 0;
        while ( i < aux.length){
            jugadores.put(aux[i],Integer.parseInt(aux[i+1]));
            i += 2;
        }
        return jugadores;
    }

    public int cantidadDeJugadores(){
        return obtenerJugadores().size();
    }
    public int obtenerPuntajeJugador(String nombre){
        HashMap jugadores = obtenerJugadores();
        Object ob = jugadores.get(nombre);
        return (int) ob;
    }

}
