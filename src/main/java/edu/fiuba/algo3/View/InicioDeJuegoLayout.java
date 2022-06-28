package edu.fiuba.algo3.View;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.GPS;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class InicioDeJuegoLayout extends VBox {

    public InicioDeJuegoLayout(Stage window, App app, GPS gps){
        Button buttonStart = new Button();
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
        getChildren().addAll(barraInicio);
    }

}
