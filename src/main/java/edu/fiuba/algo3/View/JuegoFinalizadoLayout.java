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
import javafx.stage.Stage;

import java.io.IOException;
import java.time.format.TextStyle;

public class JuegoFinalizadoLayout extends StackPane {

    public JuegoFinalizadoLayout(Stage window, App a, GPS gps){
        Label label1 = new Label("Ingrese su nombre:");
        TextField textField = new TextField ();
        HBox hb = new HBox();
        hb.setSpacing(10);
        hb.setTranslateX(350);
        Button botonNombre = new Button("Enter");
        hb.getChildren().addAll(label1, textField, botonNombre);

        Button buttonStart = new Button("Presione Start para empezar a jugar");
        buttonStart.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, new Insets(5))));
        buttonStart.setGraphic(new ImagenBoton("src/fotos/play.png", 100, 100));
        HBox barraInicio = new HBox(buttonStart);
        barraInicio.setAlignment(Pos.CENTER);
        barraInicio.setTranslateY(400);
        getChildren().addAll(barraInicio, hb);
    }
}
