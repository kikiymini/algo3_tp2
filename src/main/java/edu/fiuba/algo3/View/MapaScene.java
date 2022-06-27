package edu.fiuba.algo3.View;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.GPS;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MapaScene extends Scene {

    public MapaScene(Stage window, MapaLayout mapaLayout, GPS gps) {
        super(mapaLayout,1200, 900 );
    }
}
