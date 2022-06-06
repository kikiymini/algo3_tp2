package edu.fiuba.algo3.modelo.Fakes;

import edu.fiuba.algo3.modelo.Accionable;
import edu.fiuba.algo3.modelo.Grilla;
import edu.fiuba.algo3.modelo.Obstaculo.Pozo;

public class GrillaFake extends Grilla {

    public GrillaFake(){
        grilla = new Accionable[10][10];
    }
    public void crearGrillaConAccionables() {
        for(int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                grilla[i][j] = new Pozo();
            }
        }
    }
}
