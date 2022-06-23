package edu.fiuba.algo3.modelo.Fakes;

import edu.fiuba.algo3.modelo.Accionable;
import edu.fiuba.algo3.modelo.Grilla.Grilla;
import edu.fiuba.algo3.modelo.Obstaculo.Calle;

import java.util.ArrayList;

public class GrillaFake extends Grilla {

    public void colocarCallesEnGrilla(){
        for(int i = 0; i < tamanioEjeY; i++){
            ArrayList<Accionable> calle = grilla.get(i);
            for(int j = 0; j < tamanioEjeX; j++){
                calle.add(j, new Calle());
            }
        }
    }

}
