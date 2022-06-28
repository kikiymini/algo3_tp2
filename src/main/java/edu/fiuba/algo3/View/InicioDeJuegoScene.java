package edu.fiuba.algo3.View;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.GPS;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InicioDeJuegoScene extends Scene {
    public InicioDeJuegoScene(Stage window, App app, GPS gps) {
        super(new InicioDeJuegoLayout(window, app, gps), 1200, 900);
    }
}
