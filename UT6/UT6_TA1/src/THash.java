package ut3_ta1;

import java.util.Arrays;

public class THash implements IHash {
    private int[] tabla;
    private int tamano;
    private int cantidadElementos;
    private static final int VACIO = -1;

    public THash(int tamano) {
        this.tamano = tamano;
        this.tabla = new int[tamano];
        Arrays.fill(this.tabla, VACIO);
        this.cantidadElementos = 0;
    }

    @Override
    public int buscar(int unaClave) {
        int i = 0;
        while (i < tamano) {
            int j = funcionHashing(unaClave, i);
            if (tabla[j] == unaClave) {
                return j;
            } else if (tabla[j] == VACIO) {
                return -1;
            } else {
                i++;
            }
        }
        return -1;
    }

    @Override
    public int insertar(int unaClave) {
        int i = 0;
        while (i < tamano) {
            int j = funcionHashing(unaClave, i);
            if (tabla[j] == VACIO) {
                tabla[j] = unaClave;
                cantidadElementos++;
                return j;
            } else if (tabla[j] == unaClave) {
                return j;
            } else {
                i++;
            }
        }
        System.out.println("Error: tabla llena");
        return -1; //
    }

    public int funcionHashing(int unaClave, int i) {
        return (unaClave % tamano + i) % tamano;
    }

    @Override
    public int funcionHashing(int unaClave) {
        return unaClave % tamano;
    }
}
