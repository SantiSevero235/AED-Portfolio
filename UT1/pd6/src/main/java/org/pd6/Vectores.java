package org.pd6;

public class Vectores {
    public static boolean puedeMultiplicar(int[] vector1, int[] vector2) {
        return vector1.length == vector2.length;
    }

    public static int multiplicarVectores(int[] vector1, int[] vector2) {
        if (!puedeMultiplicar(vector1, vector2)) {
            System.out.println("No se pueden multiplicar los vectores.");
            return -1;
        }

        int resultado = 0;
        for (int i = 0; i < vector1.length; i++) {
            resultado += vector1[i] * vector2[i];
        }
        return resultado;
    }

    public static void main(String[] args) {
        int[] vector1 = {1, 2, 3, 4};
        int[] vector2 = {5, 6, 7, 8};

        int resultado = multiplicarVectores(vector1, vector2);
        if (resultado != -1) {
            System.out.println("El resultado de la multiplicación es: " + resultado);
        }
    }
}
