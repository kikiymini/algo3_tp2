package edu.fiuba.algo3.View;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImagenBoton extends ImageView {
    public ImagenBoton(String rutaImagen, int alto, int ancho){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(rutaImagen);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image img = new Image(fileInputStream);
        this.setImage(img);
        this.setFitHeight(alto);
        this.setFitWidth(ancho);
    }
}
