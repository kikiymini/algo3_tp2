package edu.fiuba.algo3.View;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.GPS;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
<<<<<<< HEAD
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
=======
>>>>>>> 8fdcb0c35fad31efc2b0dc50fe5e6c99fcda5b67
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JuegoFinalizadoLayout extends VBox {

    private StackPane finalizado = new StackPane();
    public JuegoFinalizadoLayout(Stage window, App a, GPS gps){
<<<<<<< HEAD
        Label label1 = new Label("Llegaste a la ");
        label1.setFont(new Font("Serif", 50));
        Label meta = new Label();
        meta.setGraphic(new ImagenBoton("src/fotos/meta.png", 100, 100));
        HBox barraInicio = new HBox(meta);
        barraInicio.setAlignment(Pos.CENTER);
        barraInicio.setTranslateY(400);
        getChildren().addAll(barraInicio);

=======
        Label label1 = new Label();
        label1.setGraphic(new ImagenBoton("src/fotos/victoria.jpg", 100, 100));
        label1.setAlignment(Pos.CENTER);
        getChildren().addAll(label1);
>>>>>>> 8fdcb0c35fad31efc2b0dc50fe5e6c99fcda5b67
    }
}
