package com.ut2.pd4;

/**
 * Hello world!
 *
 */
public class App 
{
    public static int busquedaBinaria(int[] list, int x) {
        int comienzo = 0;
        int fin = list.length - 1;

        while (comienzo <= fin) {
            int medio = comienzo + (fin - comienzo);

            if (list[medio] == x) {
                return medio;
            } else if (list[medio] < x) {
                comienzo = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return -1;
    }

    public static int elementoMayoritario(int[] list) {
        int n = list.length;
        int candidato = list[0];
        int contador = 1;

        for (int i = 1; i < n; i++) {
            if (list[i] == candidato) {
                contador++;
            } else {
                contador--;
            }
            if (contador == 0) {
                candidato = list[i];
                contador = 1;
            }
        }

        contador = 0;
        for (int i = 0; i < n; i++) {
            if (list[i] == candidato) {
                contador++;
            }
        }

        if (contador >= n/2) {
            return candidato;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] vector = new int[10];
        vector[0] = 0;
        vector[1] = 1;
        vector[2] = 2;
        vector[3] = 3;
        vector[4] = 4;
        vector[5] = 5;
        vector[6] = 6;
        vector[7] = 7;
        vector[8] = 8;
        vector[9] = 9;

        System.out.println(busquedaBinaria(vector,5));
        System.out.println(busquedaBinaria(vector, 10));

        int[] miLista = {5, 5, 4, 2, 4, 4, 2, 4, 4, 5, 5, 5, 5, 5, 5};
        System.out.println(elementoMayoritario(miLista));
    }
}