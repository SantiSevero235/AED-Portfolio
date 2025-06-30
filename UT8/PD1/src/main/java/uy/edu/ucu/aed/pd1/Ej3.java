package uy.edu.ucu.aed.pd1;

public class Ej3 {
    public static void main(String[] args) {
        TGrafoNoDirigido grafo = UtilGrafos.cargarGrafo("src/vertices.txt", "src/grafo_ej3.txt", false, TGrafoNoDirigido.class);

        Comparable[][] matriz = UtilGrafos.obtenerMatrizCostos(grafo.getVertices());

        UtilGrafos.imprimirMatrizMejorado(matriz, grafo.getVertices(), "Matriz");

        System.out.println(grafo.bea("b"));
    }
}
