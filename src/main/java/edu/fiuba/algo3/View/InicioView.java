package edu.fiuba.algo3.View;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.GPS;
import javafx.stage.Stage;

public class InicioView {
    private Stage window;

    public InicioView(Stage stage){
        window = stage;
    }

    public void inicioJuego(Stage window, App app){
        InicioDeJuegoScene inicioJuego = new InicioDeJuegoScene(window, app);
        window.setScene(inicioJuego);
        window.show();
    }
}
