package org.example;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        TGrafoNoDirigido gnd = (TGrafoNoDirigido) UtilGrafos.cargarGrafo(
                "src/main/java/org/example/vertices.txt",
                "src/main/java/org/example/aristas.txt",
                false, TGrafoNoDirigido.class);

        TGrafoNoDirigido grafoKruskal = gnd.Kruskal();
        System.out.println("cantidad de vertices del grafo por kruskal:"  + grafoKruskal.getVertices().size());
        LinkedList<TArista> a2 = grafoKruskal.getAristas();
        for (TArista arista : a2){
            System.out.println(arista.getEtiquetaOrigen() + " " + arista.getEtiquetaDestino() + " " + arista.getCosto());
        }


    }
}
