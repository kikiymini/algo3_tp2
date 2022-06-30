package edu.fiuba.algo3.View;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.GPS;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JuegoFinalizadoScene extends Scene {
    public JuegoFinalizadoScene(Stage window, App app, GPS gps) {
            super(new JuegoFinalizadoLayout(window, app, gps), 1000, 1000);
        }
}

