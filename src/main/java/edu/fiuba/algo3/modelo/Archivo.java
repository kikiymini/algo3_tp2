package edu.fiuba.algo3.modelo;

import com.google.gson.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
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
        //poner Exepciones
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return puntaje;
    }
    public HashMap leer2() throws IOException {
        HashMap jugadores = new HashMap();
        String fileContent = new String(Files.readAllBytes(Path.of(this.nombre)));
        String[] array = fileContent.split("}}");
        JsonArray json = new JsonArray();
        if(!fileContent.isEmpty()){
            for (String a : array ){
                a = a+"}}";
                JsonElement element = new JsonParser().parse(a);
                json.add(element);
            }
        }

       for (JsonElement jugador : json){
            Jugador j = new Jugador(jugador.getAsJsonObject().get("nombre").getAsString());
            j.puntaje = new Puntaje(jugador.getAsJsonObject().get("puntaje").getAsJsonObject().get("puntaje").getAsInt());
            j.cantMovimientos = jugador.getAsJsonObject().get("cantMovimientos").getAsInt();
            jugadores.put(j.obtenerNombre(),j);
       }
       return jugadores;
    }

    public void agregarJugador(Jugador jugador) throws IOException {

       HashMap jugadores = this.leer2();
       jugadores.put(jugador.obtenerNombre(),jugador);


        try (BufferedWriter out = new BufferedWriter(new FileWriter(this.nombre))) {
            jugadores.forEach((k,v) -> {
                Gson gson = new Gson();
                gson.toJson(v,out);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public boolean existeJugador(String nombre) throws IOException {

        return this.leer2().containsKey(nombre);

    }

    public int obtenerPuntajeJugador(String nombre) throws IOException {
        HashMap jugadores = this.leer2();
        Jugador j = (Jugador) jugadores.get(nombre);

        return j.puntajeObtenido();
    }

    public int cantidadDeJugadores() throws IOException {
        return this.leer2().size();
    }


}
