package uy.edu.ucu.aed.tas;

import uy.edu.ucu.aed.tdas.*;

import java.util.*;

public class Aeropuertos {
    public static void main(String[] args) {
        // Crear vértices
        TVertice mvd = new TVertice("Montevideo");
        TVertice poa = new TVertice("Porto Alegre");
        TVertice sp = new TVertice("San Pablo");
        TVertice pde = new TVertice("Punta del Este");

        // Lista de vértices
        Collection<IVertice> vertices = new ArrayList<>();
        vertices.add(mvd);
        vertices.add(poa);
        vertices.add(sp);
        vertices.add(pde);

        // Lista de vuelos (aristas)
        Collection<IArista> aristas = new ArrayList<>();
        aristas.add(new TArista("Montevideo", "Punta del Este", 150));
        aristas.add(new TArista("Porto Alegre", "Montevideo", 300));
        aristas.add(new TArista("Porto Alegre", "Punta del Este", 390));
        aristas.add(new TArista("San Pablo", "Montevideo", 400));
        aristas.add(new TArista("San Pablo", "Porto Alegre", 200));
        //Si quito esta arista podremos notar los infinitos en la amtriz ya que no hay caminos que pueda lograrse para las distintos vertices
        aristas.add(new TArista("Punta del Este", "San Pablo", 410));

        // Crear grafo
        TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);

        // Ejecutar Floyd
        Double[][] matriz = grafo.floyd();
        Map<Comparable, IVertice> vertices2 = grafo.getVertices();

        UtilGrafos.imprimirMatrizMejorado(matriz, vertices2, "Matriz de Caminos Mínimos");

        System.out.println(grafo.obtenerExcentricidad("Porto Alegre"));

        System.out.println(grafo.centroDelGrafo());
    }
}

