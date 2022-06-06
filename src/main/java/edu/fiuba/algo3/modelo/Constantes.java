package edu.fiuba.algo3.modelo;

public final class Constantes {
    public static final short penalizacionDeMovimientosPorPozoParaMotoYAuto = 3;
    public static final int penalizacionDeMovimientosPorPozoParaTodoterreno = 2;
    public static final int penalizacionDeMovimientosPorPozoEsquivadoParaTodoterreno = 0;
    public static final int cantidadDePozosParaAplicarPenalizacionTodoterreno = 3;
    public static final int penalizacionDeMovimientosPorPiqueteParaMoto = 2;
    public static final int penalizacionDeMovimientosPorPiqueteParaAutoYTodoterreno = 0;
    public static final int penalizacionDeMovimientosPorControlPolicial = 3;
    public static final int penalizacionDeMovimientosPorControlPolicialEsquivado = 0;
    public static final double probabilidadDePenalizarEnControlPolicialParaMoto = 0.8;
    public static final double probabilidadDePenalizarEnControlPolicialParaAuto = 0.5;
    public static final double probabilidadDePenalizarEnControlPolicialParaTodoterreno = 0.3;
    public static final double factorDeModificacionDeMovimientosPorSorpresaFavorable = 0.8;
    public static final double factorDeModificacionDeMovimientosPorSorpresaDesfavorable = 1.25;
    public static final int valorDeIncrementoDePosicion = 1;
    public static final int cantidadDeMovimientosParaLlegarALaProximaEsquina = 3;
    public static final double probabilidadDeObtenerUnaMoto = 0.33;
    public static final double probabilidadDeObtenerUnAuto = probabilidadDeObtenerUnaMoto + 0.33;
    public static final int cantidadMinimaDeEsquinasPorEje = 10;
    public static final int cantidadMaximaDeEsquinasPorEje = 40;
    public static final double cantidadDeSorpresasPorPosicionValida = 0.0415;
    public static final double cantidadDePoliciasPorPosicionValida = 0.0415;
    public static final double cantidadDePozosPorPosicionValida = 0.0311;
    public static final double cantidadDePiquetesPorPosicionValida = 0.0249;
    public static final double porcentajeDeAccionablesEnEjeX = 0.5;
    public static final int posIniEnXDeVehiculo = 1;

    private Constantes() {
    }
}
