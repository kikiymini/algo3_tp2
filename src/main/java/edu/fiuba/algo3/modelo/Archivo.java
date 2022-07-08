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

    private void escribirArchivo(String nombre, int puntaje){
        HashMap jugadores = obtenerJugadores();
        if(jugadores.containsKey(nombre)){
            jugadores.replace(nombre,puntaje);
        }
        else {
            jugadores.put(nombre,puntaje);
        }
        try{
            BufferedWriter buffer = new BufferedWriter(new FileWriter(this.nombre));
            jugadores.forEach((k,v) -> {
                try {
                    buffer.write(k + ";" + v + ";" + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            buffer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void agregarJugador(Jugador jugador) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.nombre));
            String linea;
            boolean encontrado = false;
            int puntajeTotal = jugador.puntajeObtenido();
            while ((linea = br.readLine()) != null && !encontrado) {
                String[] j = linea.split(";");
                if(j[0] == jugador.obtenerNombre()){
                    puntajeTotal = Integer.parseInt(j[1]);
                    encontrado = true;
                }
            }
            escribirArchivo(jugador.obtenerNombre(),puntajeTotal);
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
