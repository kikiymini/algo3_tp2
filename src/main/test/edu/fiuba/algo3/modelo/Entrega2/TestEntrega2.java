package edu.fiuba.algo3.modelo.Entrega2;

import edu.fiuba.algo3.modelo.Fakes.CiudadFake;
import edu.fiuba.algo3.modelo.Fakes.VehiculoFake;
import edu.fiuba.algo3.modelo.Movimiento.Derecha;
import edu.fiuba.algo3.modelo.Obstaculo.Pozo;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Sorpresa.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.Sorpresa.Desfavorable;
import edu.fiuba.algo3.modelo.Sorpresa.Favorable;
import edu.fiuba.algo3.modelo.TestPosicion;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.TodoTerreno;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import javafx.geometry.Pos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEntrega2 {

    @Test
    public void autoAtraviesaLaCiudadYSeEncuentraUnaSorpresaFavorable(){
        Posicion pos = new Posicion(3, 3);
        CiudadFake ciudad = new CiudadFake(new VehiculoFake(pos, new Auto(pos)));
        ciudad.ponerAccionableEnPosicion(14, 3, new Favorable());
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculo(new Derecha());
        }
        assertEquals(4, ciudad.obtenerCantidadDeMovVehiculo());
    }

    @Test
    public void motoAtraviesaLaCiudadYSeEncuentraUnaSorpresaFavorable(){
        Posicion pos = new Posicion(3, 3);
        CiudadFake ciudad = new CiudadFake(new VehiculoFake(pos, new Moto(pos)));
        ciudad.ponerAccionableEnPosicion(14, 3, new Favorable());
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculo(new Derecha());
        }
        assertEquals(4, ciudad.obtenerCantidadDeMovVehiculo());
    }

    @Test
    public void todoTerrenoAtraviesaLaCiudadYSeEncuentraUnaSorpresaFavorable(){
        Posicion pos = new Posicion(3, 3);
        CiudadFake ciudad = new CiudadFake(new VehiculoFake(pos, new TodoTerreno(pos)));
        ciudad.ponerAccionableEnPosicion(14, 3, new Favorable());
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculo(new Derecha());
        }
        assertEquals(4, ciudad.obtenerCantidadDeMovVehiculo());
    }

    @Test
    public void autoAtraviesaLaCiudadYSeEncuentraUnaSorpresaDesfavorable(){
        Posicion pos = new Posicion(3, 3);
        CiudadFake ciudad = new CiudadFake(new VehiculoFake(pos, new Auto(pos)));
        ciudad.ponerAccionableEnPosicion(16, 3, new Desfavorable());
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculo(new Derecha());
        }
        assertEquals(6, ciudad.obtenerCantidadDeMovVehiculo());
    }

    @Test
    public void motoAtraviesaLaCiudadYSeEncuentraUnaSorpresaDesfavorable(){
        Posicion pos = new Posicion(3, 3);
        CiudadFake ciudad = new CiudadFake(new VehiculoFake(pos, new Moto(pos)));
        ciudad.ponerAccionableEnPosicion(16, 3, new Desfavorable());
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculo(new Derecha());
        }
        assertEquals(6, ciudad.obtenerCantidadDeMovVehiculo());
    }

    @Test
    public void todoTerrenoAtraviesaLaCiudadYSeEncuentraUnaSorpresaDesfavorable(){
        Posicion pos = new Posicion(3, 3);
        CiudadFake ciudad = new CiudadFake(new VehiculoFake(pos, new TodoTerreno(pos)));
        ciudad.ponerAccionableEnPosicion(16, 3, new Desfavorable());
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculo(new Derecha());
        }
        assertEquals(6, ciudad.obtenerCantidadDeMovVehiculo());
    }

    @Test
    public void autoAtraviesaLaCiudadYSeEncuentraUnaCambioDeVehiculoYSeTransformaEnTodoTerreno(){
        Posicion pos = new Posicion(3, 3);
        VehiculoFake vehiculo = new VehiculoFake(pos, new Auto(pos));
        CiudadFake ciudad = new CiudadFake(vehiculo);
        ciudad.ponerAccionableEnPosicion(14, 3, new CambioDeVehiculo());
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculo(new Derecha());
        }
        assertEquals(new TodoTerreno(new Posicion(0, 0)).getClass(), vehiculo.obtenerEstado().getClass());
    }

    @Test
    public void motoAtraviesaLaCiudadYSeEncuentraUnaCambioDeVehiculoYSeTransformaEnAuto(){
        Posicion pos = new Posicion(3, 3);
        VehiculoFake vehiculo = new VehiculoFake(pos, new Moto(pos));
        CiudadFake ciudad = new CiudadFake(vehiculo);
        ciudad.ponerAccionableEnPosicion(14, 3, new CambioDeVehiculo());
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculo(new Derecha());
        }
        assertEquals(new Auto(new Posicion(0, 0)).getClass(), vehiculo.obtenerEstado().getClass());
    }

    @Test
    public void todoTerrenoAtraviesaLaCiudadYSeEncuentraUnaCambioDeVehiculoYSeTransformaEnMoto(){
        Posicion pos = new Posicion(3, 3);
        VehiculoFake vehiculo = new VehiculoFake(pos, new TodoTerreno(pos));
        CiudadFake ciudad = new CiudadFake(vehiculo);
        ciudad.ponerAccionableEnPosicion(14, 3, new CambioDeVehiculo());
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculo(new Derecha());
        }
        assertEquals(new Moto(new Posicion(0, 0)).getClass(), vehiculo.obtenerEstado().getClass());
    }


    // propios
    @Test
    public void autoAtraviesaLaCiudadYSeEncuentraDosCambioDeVehiculoYSeTransformaEnMoto(){
        Posicion pos = new Posicion(3, 3);
        VehiculoFake vehiculo = new VehiculoFake(pos, new Auto(pos));
        CiudadFake ciudad = new CiudadFake(vehiculo);
        ciudad.ponerAccionableEnPosicion(14, 3, new CambioDeVehiculo());
        ciudad.ponerAccionableEnPosicion(13, 3, new CambioDeVehiculo());
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculo(new Derecha());
        }
        assertEquals(new Moto(new Posicion(0, 0)).getClass(), vehiculo.obtenerEstado().getClass());
    }

    @Test
    public void motoAtraviesaLaCiudadYSeEncuentraDosCambioDeVehiculoYSeTransformaEnTodoTerreno(){
        Posicion pos = new Posicion(3, 3);
        VehiculoFake vehiculo = new VehiculoFake(pos, new Moto(pos));
        CiudadFake ciudad = new CiudadFake(vehiculo);
        ciudad.ponerAccionableEnPosicion(14, 3, new CambioDeVehiculo());
        ciudad.ponerAccionableEnPosicion(13, 3, new CambioDeVehiculo());
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculo(new Derecha());
        }
        assertEquals(new TodoTerreno(new Posicion(0, 0)).getClass(), vehiculo.obtenerEstado().getClass());
    }

    @Test
    public void todoTerrenoAtraviesaLaCiudadYSeEncuentraDosCambioDeVehiculoYSeTransformaEnAuto(){
        Posicion pos = new Posicion(3, 3);
        VehiculoFake vehiculo = new VehiculoFake(pos, new TodoTerreno(pos));
        CiudadFake ciudad = new CiudadFake(vehiculo);
        ciudad.ponerAccionableEnPosicion(14, 3, new CambioDeVehiculo());
        ciudad.ponerAccionableEnPosicion(13, 3, new CambioDeVehiculo());
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculo(new Derecha());
        }
        assertEquals(new Auto(new Posicion(0, 0)).getClass(), vehiculo.obtenerEstado().getClass());
    }

    @Test
    public void autoAtraviesaLaCiudadYSeEncuentraUnaSorpresaFavorableYOtraDesfavorable(){
        Posicion pos = new Posicion(3, 3);
        CiudadFake ciudad = new CiudadFake(new VehiculoFake(pos, new Auto(pos)));
        ciudad.ponerAccionableEnPosicion(17, 3, new Favorable());
        ciudad.ponerAccionableEnPosicion(16, 3, new Desfavorable());
        for (int i = 0; i < 5; i++){
            ciudad.moverVehiculo(new Derecha());
        }
        assertEquals(5, ciudad.obtenerCantidadDeMovVehiculo());
    }


}
