package org.pd8;

public class Marcapasos {

    private short presionSanguinea;
    private short frecuenciaCardiaca;
    private short nivelAzucar;
    private long maximaFuerza;
    private float tiempoEntreLatidos;
    private double bateriaRestante;
    private char[] codigoFabricante = new char[8];

    // Constructor
    public Marcapasos(short presion, short frecuencia, short azucar, long fuerza, float tiempo, double bateria, char[] codigo) {
        this.presionSanguinea = presion;
        this.frecuenciaCardiaca = frecuencia;
        this.nivelAzucar = azucar;
        this.maximaFuerza = fuerza;
        this.tiempoEntreLatidos = tiempo;
        this.bateriaRestante = bateria;
        this.codigoFabricante = codigo;
    }

    public static int calcularMemoria() {
        int memoria = 0;
        memoria += 2;
        memoria += 2;
        memoria += 2;
        memoria += 8;
        memoria += 4;
        memoria += 8;
        memoria += 16;
        return memoria;
    }

    public static void main(String[] args) {
        System.out.println("Memoria usada por un objeto Marcapasos: " + calcularMemoria() + " bytes");
    }
}
