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
import java.io.File;
import java.util.Scanner;

public class JuegoFinalizadoLayout extends VBox {

    private StackPane finalizado = new StackPane();
    public JuegoFinalizadoLayout(Stage window, App a, GPS gps){

        Label label1 = new Label("Llegaste a la Meta");
        label1.setFont(new Font("Serif", 50));
        Label meta = new Label();
        meta.setGraphic(new ImagenBoton("src/fotos/meta.png", 100, 100));
        HBox barraInicio = new HBox(meta,label1);
        barraInicio.setAlignment(Pos.CENTER);
        barraInicio.setTranslateY(100);
        getChildren().addAll(barraInicio);
        leerArchivoExterno("src/main/java/edu/fiuba/algo3/recursos/registroPuntaje.txt");
    }
    public void leerArchivoExterno(String rutaArchivo) {
        try {
            Scanner input = new Scanner(new File(rutaArchivo));
            int i = 0;
            while (input.hasNextLine() && i<=10) {
                //String linea = input.nextLine();
                //String [] partes = linea.split(";");
                //String lineaCompleta = partes[0]+" "+partes[1];
                Label texto = new Label(input.nextLine());
                texto.setFont(new Font("Serif", 20));
                Label ranking = new Label();
                HBox barraRanking = new HBox(ranking,texto);
                barraRanking.setAlignment(Pos.CENTER);
                barraRanking.setTranslateY(110);
                getChildren().addAll(barraRanking);
                i++;
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


