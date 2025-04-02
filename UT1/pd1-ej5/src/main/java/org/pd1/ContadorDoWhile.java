package org.pd1;

public class ContadorDoWhile {
    private int contador = 1;
    private int incremento = 1;
    private static final int MAX_CONT = 50 ;

    public void displayCount() {
        do {
            System.out.println("Contador: " + contador);
            contador += incremento;
        } while (contador <= MAX_CONT);
    }
    public static void main (String[] args) {
        ContadorDoWhile contDoWhile = new ContadorDoWhile();
        contDoWhile.displayCount();
    }
}
