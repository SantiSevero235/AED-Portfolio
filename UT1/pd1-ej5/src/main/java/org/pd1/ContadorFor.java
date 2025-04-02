package org.pd1;

public class ContadorFor {
    private int incremento = 1;
    private static final int MAX_CONT = 50;

    public void displayCount() {
        for (int contador = 1; contador <= MAX_CONT; contador += incremento) {
            System.out.println(contador);
        }
    }

    public static void main (String[] args) {
        ContadorFor contFor = new ContadorFor();
        contFor.displayCount();
    }
}
