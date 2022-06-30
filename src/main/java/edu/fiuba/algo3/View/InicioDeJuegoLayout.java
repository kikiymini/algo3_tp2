package edu.fiuba.algo3.View;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.GPS;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class InicioDeJuegoLayout extends VBox {
    private GPS gps;

    public InicioDeJuegoLayout(Stage window, App app){


        Label label1 = new Label("Ingrese su nombre:");
        label1.setFont(new Font("Serif", 20));

        TextField textField = new TextField ();
        HBox hb = new HBox();
        hb.setSpacing(10);
        hb.setTranslateX(350);
        Button botonNombre = new Button("Enter");
        hb.getChildren().addAll(label1, textField, botonNombre);
        botonNombre.setOnAction( e ->{
            try {
                gps = new GPS(textField.getText());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        Button buttonStart = new Button("Presione Start para empezar a jugar");
        buttonStart.setFont(new Font("Serif", 25));
        buttonStart.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, new Insets(5))));
        buttonStart.setOnAction(e->{
            MapaLayout mapaLayout = new MapaLayout(window, app, gps);
            MapaScene mapaScene = new MapaScene(window, mapaLayout, gps);
            window.setScene(mapaScene);
        });
        buttonStart.setGraphic(new ImagenBoton("src/fotos/play.png", 100, 100));
        HBox barraInicio = new HBox(buttonStart);
        barraInicio.setAlignment(Pos.CENTER);
        barraInicio.setTranslateY(400);
        getChildren().addAll(barraInicio, hb);
    }

}
