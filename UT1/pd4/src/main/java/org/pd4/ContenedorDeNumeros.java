package org.pd4;

public class ContenedorDeNumeros {
    public int anInt;
    public float aFloat;

    public static void main(String[] args) {
       ContenedorDeNumeros contNumeros = new ContenedorDeNumeros();
       contNumeros.anInt = 17;
       contNumeros.aFloat = 1.50f;

       int unInt = contNumeros.anInt;
       float unFloat = contNumeros.aFloat;

       System.out.println("Valor de anInt: " + unInt);
       System.out.println("Valor de aFloat: " + unFloat);

    }
}
