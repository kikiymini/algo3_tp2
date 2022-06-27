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

public class MapaLayout extends VBox {
    int largoEjeX;
    int largoEjeY;
    double separacion = 33.0;

    public MapaLayout(Stage window, App app, GPS gps){
        largoEjeX = gps.obtenerTamanioEjesMapa().get(0);
        largoEjeY = gps.obtenerTamanioEjesMapa().get(1);
        Canvas canvas = new Canvas(800, 800);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.strokeRect(20, 20, canvas.getWidth(), canvas.getHeight());
        gc.setStroke(Paint.valueOf("BLACK"));
        crearLineasMatriz(gps, gc, largoEjeX, largoEjeY);
        insertarAccionablesEnGrilla(gps, gc, largoEjeX, largoEjeY);
        getChildren().add(canvas);


    }

    public void crearLineasMatriz(GPS gps, GraphicsContext gc, int largoEjeX, int largoEjeY){
        for (int i = 0; i < largoEjeY; i++){
            if(i % 3 == 0) {
                gc.strokeLine(20.0, separacion * i, 800.0, separacion * i);
            }
        }
        for (int j = 0; j < largoEjeX; j++){
            if(j % 3 == 0) {
                gc.strokeLine(separacion * j, 20, separacion * j, 800);
            }
        }

    }
    public void insertarAccionablesEnGrilla(GPS gps, GraphicsContext gc, int largoEjeX, int largoEjeY){
        Image imagenPolicia = new Image(getClass().getClassLoader().getResource("src/fotos/policia.png").toString(), true);// no lo encuentra
        for (int i = 0; i < largoEjeY; i++){
            for (int j = 0; j < largoEjeX; j++) {
                Accionable accionable = gps.obtenerAccionableEnPosicion(i, j);
                if(!accionable.getClass().equals(new ControlPolicial())){
                }
            }
        }

    }
}
