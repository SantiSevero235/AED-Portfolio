package org.ta3;

public class Main {
    public static void main (String args[]) {
        // creamos una instancia de un ContadorPalabras
        String frase="Hola como estas 4";
        String frase2 = "h4la 666 hol3";
        String frase3 = "4";
        String frase4 = "Algoritmos y estructuras de datos.";
        String frase5 = "Hola soy una frase con espacio al final ";

        ContadorPalabras contador = new ContadorPalabras();
        // llamamos al método “contarPalabras” de la instancia creada
        System.out.println(contador.contarPalabras(frase));
        System.out.println(contador.contarPalabras(frase2));
        System.out.println(contador.contarPalabras(frase3));
        System.out.println(contador.contarPalabras(frase4));
        System.out.println(contador.contarPalabras(frase5));
        System.out.println("");
        int[] cont1 = contador.contarVocalCons("PalAbra");
        System.out.println("Consonantes: " + Integer.toString(cont1[0]));
        System.out.println("Vocales: " + Integer.toString(cont1[1]));

        //anteriormente.
        // mostramos el resultado en la consola.
    }
}
