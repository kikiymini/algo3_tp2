package edu.fiuba.algo3.View;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Accionable;
import edu.fiuba.algo3.modelo.GPS;
import edu.fiuba.algo3.modelo.Obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.Obstaculo.Piquete;
import edu.fiuba.algo3.modelo.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Sorpresa.Desfavorable;
import edu.fiuba.algo3.modelo.Sorpresa.Favorable;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.EstadoVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.File;
import java.nio.InvalidMarkException;

public class MapaLayout extends Pane {
    int largoEjeX;
    int largoEjeY;
    double separacionEntreCuadras = 32;
    double separacionEntreCuadrasInicio = 20;

    public MapaLayout(Stage window, App app, GPS gps){
        largoEjeX = gps.obtenerTamanioEjesMapa().get(0);
        largoEjeY = gps.obtenerTamanioEjesMapa().get(1);
        Canvas canvas = new Canvas(900, 900);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        crearLineasMatriz(gps, gc, largoEjeX, largoEjeY);
        insertarPoliciasEnGrilla(gps, largoEjeX, largoEjeY);
        insertarPozosEnGrilla(gps, largoEjeX, largoEjeY);
        insertarPiquetesEnGrilla(gps, largoEjeX, largoEjeY);
        insertarSorpresasEnGrilla(gps, largoEjeX, largoEjeY);
        insertarVehiculo(gps);
        getChildren().add(canvas);
    }
    public void crearLineasMatriz(GPS gps, GraphicsContext gc, int largoEjeX, int largoEjeY){
        for(int i = 0; i <= largoEjeX; i++){
            if(i % 3 == 0){
                gc.strokeLine((separacionEntreCuadras * i) + separacionEntreCuadrasInicio, separacionEntreCuadrasInicio, (separacionEntreCuadras * i) + separacionEntreCuadrasInicio, (largoEjeY * separacionEntreCuadras) + separacionEntreCuadrasInicio);
            }
        }
        for(int j = 0; j <= largoEjeY; j++){
            if(j % 3 == 0){
                gc.strokeLine(separacionEntreCuadrasInicio, (separacionEntreCuadras * j) + separacionEntreCuadrasInicio, (largoEjeX * separacionEntreCuadras) + separacionEntreCuadrasInicio, (separacionEntreCuadras * j) + separacionEntreCuadrasInicio);
            }
        }
    }

    public void insertarPoliciasEnGrilla(GPS gps, int largoEjeX, int largoEjeY){
        for (int i = 0; i < largoEjeX; i++){
            for (int j = 0; j < largoEjeY; j++) {
                Accionable accionable = gps.obtenerAccionableEnPosicion(i, j);
                if(accionable.sosAccionable(new ControlPolicial())){
                    Button boton = new Button();
                    boton.setGraphic(new ImagenBoton("src/fotos/policia.jpg", 36, 36));
                    boton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, new Insets(5))));
                    boton.setLayoutX(separacionEntreCuadras * i);
                    boton.setLayoutY(separacionEntreCuadras * j);
                    getChildren().add(boton);
                }
            }
        }

    }

    public void insertarPozosEnGrilla(GPS gps, int largoEjeX, int largoEjeY){
        for (int i = 0; i < largoEjeX; i++){
            for (int j = 0; j < largoEjeY; j++) {
                Accionable accionable = gps.obtenerAccionableEnPosicion(i, j);
                if(accionable.sosAccionable(new Pozo())){
                    Button boton = new Button();
                    boton.setGraphic(new ImagenBoton("src/fotos/pozo.jpg", 36, 36));
                    boton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, new Insets(5))));
                    boton.setLayoutX(separacionEntreCuadras * i);
                    boton.setLayoutY(separacionEntreCuadras * j);
                    getChildren().add(boton);
                }
            }
        }

    }

    public void insertarPiquetesEnGrilla(GPS gps, int largoEjeX, int largoEjeY){
        for (int i = 0; i < largoEjeX; i++){
            for (int j = 0; j < largoEjeY; j++) {
                Accionable accionable = gps.obtenerAccionableEnPosicion(i, j);
                if(accionable.sosAccionable(new Piquete())){
                    Button boton = new Button();
                    boton.setGraphic(new ImagenBoton("src/fotos/piquete.jpg", 36, 36));
                    boton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, new Insets(5))));
                    boton.setLayoutX(separacionEntreCuadras * i);
                    boton.setLayoutY(separacionEntreCuadras * j);
                    getChildren().add(boton);
                }
            }
        }

    }

    public void insertarSorpresasEnGrilla(GPS gps, int largoEjeX, int largoEjeY){
        for (int i = 0; i < largoEjeX; i++){
            for (int j = 0; j < largoEjeY; j++) {
                Accionable accionable = gps.obtenerAccionableEnPosicion(i, j);
                if(accionable.sosAccionable(new Favorable()) || accionable.sosAccionable(new Desfavorable()) || accionable.sosAccionable(new Desfavorable())){
                    Button boton = new Button();
                    boton.setGraphic(new ImagenBoton("src/fotos/sorpresa2.jpeg", 36, 36));
                    boton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, new Insets(5))));
                    boton.setLayoutX(separacionEntreCuadras * i);
                    boton.setLayoutY(separacionEntreCuadras * j);
                    getChildren().add(boton);
                }
            }
        }

    }
    public void insertarVehiculo(GPS gps){
        Posicion posVehiculo = gps.obtenerPosicionVehiculo();
        EstadoVehiculo estado = gps.otenerEstadoVehiculo();
        Button boton = new Button();
        if (estado.sosEstado(new Auto(posVehiculo))){
            boton.setGraphic(new ImagenBoton("src/fotos/auto.png", 36, 36));
        }
        else if (estado.sosEstado(new Moto(posVehiculo))){
            boton.setGraphic(new ImagenBoton("src/fotos/moto.jpg", 36, 36));
        }
        else{
            boton.setGraphic(new ImagenBoton("src/fotos/4x4.jpg", 36, 36));
        }
        boton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, new Insets(5))));
        boton.setLayoutX(separacionEntreCuadras * posVehiculo.obtenerPosX());
        boton.setLayoutY(separacionEntreCuadras * posVehiculo.obtenerPosY());
        getChildren().add(boton);
    }

    private boolean estaEnEsquina(int x, int y){
        return (x % 3 == 0 && y % 3 == 0);
    }
}
