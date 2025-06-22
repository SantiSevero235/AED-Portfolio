package uy.edu.ucu.aed.ta6;

import java.util.LinkedList;

public class TA6_Ej3 {
    public static void main(String[] args) {
        TGrafoDirigido grafo = UtilGrafos.cargarGrafo("src/tareas.txt", "src/precedencias.txt", false, TGrafoDirigido.class);

        LinkedList<TVertice> vertices = grafo.ordenParcial();
        for (TVertice vertice : vertices) {
            System.out.println(vertice.getEtiqueta());
        }

    }
}
