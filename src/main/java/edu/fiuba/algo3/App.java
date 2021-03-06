package edu.fiuba.algo3;

import edu.fiuba.algo3.View.JuegoFinalizadoScene;
import edu.fiuba.algo3.modelo.GPS;
import edu.fiuba.algo3.View.InicioView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX  App
 */
public class App extends Application {

    private Stage window;
    private InicioView inicio;


    @Override
    public void start(Stage stage) throws IOException {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 640, 480);
        window = stage;
        window.setTitle("GPS");
        inicio = new InicioView(window);
        inicio.inicioJuego(window, this);
        //stage.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void terminarJuego(GPS gps) {
        JuegoFinalizadoScene  jf = new JuegoFinalizadoScene(window, this, gps);
        window.setScene(jf);
        window.toFront();
        window.show();
    }
}