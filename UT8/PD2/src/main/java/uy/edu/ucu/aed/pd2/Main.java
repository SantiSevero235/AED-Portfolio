package uy.edu.ucu.aed.pd2;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TGrafoNoDirigido[] grafos = new TGrafoNoDirigido[3];

        grafos[0] = UtilGrafos.cargarGrafo("src/vertices.txt", "src/aristas_0.txt", false, TGrafoNoDirigido.class);
        grafos[1] = UtilGrafos.cargarGrafo("src/vertices.txt", "src/aristas_1.txt", false, TGrafoNoDirigido.class);
        grafos[2] = UtilGrafos.cargarGrafo("src/vertices.txt", "src/aristas_2.txt", false, TGrafoNoDirigido.class);


        for (int i = 0; i < grafos.length; i++) {
            TGrafoNoDirigido grafoKruskal = grafos[i].Kruskal();
            UtilGrafos.imprimirMatrizMejorado(UtilGrafos.obtenerMatrizCostos(grafoKruskal.getVertices()),grafoKruskal.getVertices(), "Matriz Kruskal " + (i+1));
        }
    }
}