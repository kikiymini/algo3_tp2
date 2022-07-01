package edu.fiuba.algo3.View;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.GPS;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JuegoFinalizadoLayout extends VBox {

    //private StackPane finalizado = new StackPane();
    public JuegoFinalizadoLayout(Stage window, App a, GPS gps){
        Label label1 = new Label();
        label1.setGraphic(new ImagenBoton("src/fotos/victoria.jpg", 100, 100));
        label1.setAlignment(Pos.CENTER);
        getChildren().addAll(label1);
    }
}
