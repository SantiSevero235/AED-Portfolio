package uy.edu.ucu.aed;

import static uy.edu.ucu.aed.TClasificador.*;

public class Main {
    public static void main(String args[]) {
        TClasificador clasif = new TClasificador();

        int[] datos = {5,-2, 3, -1, 17, 10, -5, 84, 19, 6, 22, 9, 1, 2};
        int[] resultado = clasif.clasificar(datos, METODO_CLASIFICACION_RADIXSORT);

        System.out.println("Resultado ordenado por HeapSort:");
        for (int num : resultado) {
            System.out.print(num + " ");
        }
    }

}
