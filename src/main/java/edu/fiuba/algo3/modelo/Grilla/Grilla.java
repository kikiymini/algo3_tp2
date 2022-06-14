package edu.fiuba.algo3.modelo.Grilla;

        import edu.fiuba.algo3.modelo.Accionable;
        import edu.fiuba.algo3.modelo.Calle;
        import edu.fiuba.algo3.modelo.Constantes;
        import edu.fiuba.algo3.modelo.Posicion;
        import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

        import java.util.ArrayList;
        import java.util.Random;

public class Grilla {

    protected ArrayList<ArrayList<Accionable>> grilla;
    protected int tamanioEjeX;
    protected int tamanioEjeY;
    protected int cantEsquinasEjeX;
    protected int cantEsquinasEjeY;

    private static Random RNG = new Random();


    public Grilla(){
        this.asignarCantidadesDeEsquinas();
        this.asignarTamaniosEjes();
        this.grilla = crearGrilla(tamanioEjeX, tamanioEjeY);
    }


    public int obtenerTamanioEjeX(){
        return this.tamanioEjeX;
    }

    public int obtenerTamanioEjeY(){
        return this.tamanioEjeY;
    }

    private int obtenerCantTotalDePosiciones(){
        return this.tamanioEjeX * this.tamanioEjeY;
    }

    private int obtenerCantTotalDeEsquinas(){
        return this.cantEsquinasEjeX * this.cantEsquinasEjeY;
    }

    public int obtenerCantTotalDePosValidas(){
        return this.obtenerCantTotalDePosiciones() - this.obtenerCantTotalDeEsquinas();
    }

    public Accionable obtenerAccionableEnPosicion(Posicion pos){
        ArrayList<Accionable> calle = grilla.get(pos.obtenerPosY());
        return calle.get(pos.obtenerPosX());
    }

    public void insertarAccionableEnPosicion(Posicion pos, Accionable objeto){
        ArrayList<Accionable> calle = grilla.get(pos.obtenerPosY());
        calle.set(pos.obtenerPosX(), objeto);
    }

    private void asignarCantidadesDeEsquinas(){
        this.cantEsquinasEjeX = this.conseguirUnaCantEsquinasPorEje();
        this.cantEsquinasEjeY = this.cantEsquinasEjeX;
    }

    private void asignarTamaniosEjes(){
        this.tamanioEjeX = (this.cantEsquinasEjeX * 3) + 2;
        this.tamanioEjeY = this.tamanioEjeX;
    }


    private static int conseguirUnaCantEsquinasPorEje(){
        return RNG.nextInt(Constantes.cantidadMaximaDeEsquinasPorEje - Constantes.cantidadMinimaDeEsquinasPorEje) + Constantes.cantidadMinimaDeEsquinasPorEje;// numero entre cantidad maxima y cantidad minima
    }

    public void moverVehiculo(Vehiculo vehiculo) {
        Posicion pos = vehiculo.obtenerPosVehiculo(); // esta mal
        ArrayList<Accionable> calle = grilla.get(pos.obtenerPosY());
        Accionable accionable = calle.get(pos.obtenerPosX());
        accionable.accionar(vehiculo);
    }

    public static ArrayList<ArrayList<Accionable>> crearGrilla(int tamanioEjeX, int tamanioEjeY){
        ArrayList<ArrayList<Accionable>> grilla = new ArrayList<>();
        for (int i = 0 ; i < tamanioEjeY; i++){
            ArrayList<Accionable> calle = new ArrayList<>();
            for(int j = 0; j < tamanioEjeX; j++){
                calle.add(new Calle());
            }
            grilla.add(calle);
        }
        return grilla;
    }
}








