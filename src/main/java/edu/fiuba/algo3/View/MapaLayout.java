package edu.fiuba.algo3.View;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Accionable;
import edu.fiuba.algo3.modelo.GPS;
import edu.fiuba.algo3.modelo.Obstaculo.ControlPolicial;
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
    double separacionEntreCuadras = 26.83;
    double separacionEntreCuadrasInicio = 5;

    public MapaLayout(Stage window, App app, GPS gps){
        largoEjeX = gps.obtenerTamanioEjesMapa().get(0);
        largoEjeY = gps.obtenerTamanioEjesMapa().get(1);
        Canvas canvas = new Canvas(805, 805);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.strokeRect(5, 5, canvas.getWidth(), canvas.getHeight());
        crearLineasMatriz(gps, gc, largoEjeX, largoEjeY);
        insertarAccionablesEnGrilla(gps, gc, largoEjeX, largoEjeY);
        getChildren().add(canvas);
    }

    public void crearLineasMatriz(GPS gps, GraphicsContext gc, int largoEjeX, int largoEjeY){

        for (int i = 0; i <= largoEjeY; i++){

            if(i % 3 == 0) {
                gc.strokeLine(separacionEntreCuadrasInicio, separacionEntreCuadras * i, 805.0 , separacionEntreCuadras * i);
            }
        }
        for (int j = 0; j <= largoEjeX; j++){
            if(j % 3 == 0) {
                gc.strokeLine(separacionEntreCuadras * j , separacionEntreCuadrasInicio, separacionEntreCuadras * j, 805);
            }
        }

    }
    public void insertarAccionablesEnGrilla(GPS gps, GraphicsContext gc, int largoEjeX, int largoEjeY){

        System.out.println(largoEjeX);
        System.out.println(largoEjeY);
        for (int i = 0; i < largoEjeY; i++){
            for (int j = 0; j < largoEjeX; j++) {
                Accionable accionable = gps.obtenerAccionableEnPosicion(j, i);
                if(accionable.sosAccionable(new ControlPolicial())){
                    Button boton = new Button();
                    boton.setGraphic(new ImagenBoton("src/fotos/policia.png", 30, 30));
                    boton.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, new Insets(5))));
                    boton.setLayoutX(j * separacionEntreCuadras + separacionEntreCuadrasInicio);
                    boton.setLayoutY(i * separacionEntreCuadras + separacionEntreCuadrasInicio);
                    getChildren().add(boton);
                }
            }
        }

    }

    private boolean estaEnEsquina(int x, int y){
        return (x % 3 == 0 && y % 3 == 0);
    }
}
