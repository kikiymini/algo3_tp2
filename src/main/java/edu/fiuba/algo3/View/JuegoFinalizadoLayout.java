package edu.fiuba.algo3.View;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.GPS;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JuegoFinalizadoLayout extends VBox {

    private StackPane finalizado = new StackPane();
    public JuegoFinalizadoLayout(Stage window, App a, GPS gps){

        Label label1 = new Label("Llegaste a la Meta");
        label1.setFont(new Font("Serif", 50));
        Label meta = new Label();
        meta.setGraphic(new ImagenBoton("src/fotos/meta.png", 100, 100));
        HBox barraInicio = new HBox(meta,label1);
        barraInicio.setAlignment(Pos.CENTER);
        barraInicio.setTranslateY(400);
        getChildren().addAll(barraInicio);
    }

}
