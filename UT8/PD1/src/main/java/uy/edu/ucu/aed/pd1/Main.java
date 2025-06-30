package uy.edu.ucu.aed.pd1;

import java.util.Collection;
import java.util.LinkedList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TGrafoNoDirigido[] grafos = new TGrafoNoDirigido[4];

        grafos[0] = UtilGrafos.cargarGrafo("src/verticesBEA.txt", "src/aristasBEA.txt", false, TGrafoNoDirigido.class);
        grafos[1] = UtilGrafos.cargarGrafo("src/vertices.txt", "src/aristas_0.txt", false, TGrafoNoDirigido.class);
        grafos[2] = UtilGrafos.cargarGrafo("src/vertices.txt", "src/aristas_1.txt", false, TGrafoNoDirigido.class);
        grafos[3] = UtilGrafos.cargarGrafo("src/vertices.txt", "src/aristas_2.txt", false, TGrafoNoDirigido.class);


        for (int i = 0; i < grafos.length; i++) {
            TGrafoNoDirigido grafoPrim = grafos[i].Prim();
            UtilGrafos.imprimirMatrizMejorado(UtilGrafos.obtenerMatrizCostos(grafoPrim.getVertices()),grafoPrim.getVertices(), "Matriz Prim " + (i+1));
            System.out.println("Recorrido bpf:\n" + grafoPrim.bpf());
        }


    }
}