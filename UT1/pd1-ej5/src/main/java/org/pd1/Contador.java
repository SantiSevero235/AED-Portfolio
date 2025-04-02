package org.pd1;

public class Contador {
    private int contador = 1;
    private int incremento = 1;
    private static final int MAX_CONT = 50;

    public void displayCount() {
        while (contador <= MAX_CONT) {
            System.out.println("Contador: " + contador);
            contador += incremento;
        }
    }

    public static void main(String[] args) {
        Contador contador1 = new Contador();
        contador1.displayCount();
    }
}
