package uy.edu.ucu.aed.tas;

import uy.edu.ucu.aed.tdas.*;
import uy.edu.ucu.aed.utils.ManejadorArchivosGenerico;

import java.util.*;

public class TA3 {
    public static void main(String[] args){

        String[] Aeropuertos = ManejadorArchivosGenerico.leerArchivo("src\\main\\java\\resources\\aeropuertos.txt", false);
        String[] Conexiones = ManejadorArchivosGenerico.leerArchivo("src\\main\\java\\resources\\conexiones.txt", false);

        //Creamos los vertices qeue van a ser las ciudades
        Collection<IVertice> vertices = new ArrayList<>();
        for (String nombreCiudad : Aeropuertos){
            vertices.add(new TVertice(nombreCiudad));
        }

        //Creamos las aristas que van a ser las conxiones entre esos aeopuertos
        Collection<IArista> aristas = new ArrayList<>();
        for (String linea : Conexiones){
            String[] partes = linea.split(",");
            String origen = partes[0];
            String destino = partes[1];
            double costo = Double.parseDouble(partes[2]);

            aristas.add(new TArista(origen, destino, costo));
        }

        //Creamos el grafo con todo
        TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);

        //Como en un HashMAp el orden no esta garantizado transformamos el set en una list, para poder ordenarla y acceder por indice
        List<Comparable> etiquetas = new ArrayList<>(grafo.getVertices().keySet());
        Collections.sort(etiquetas);

        Double[][] matrizCostos = UtilGrafos.obtenerMatrizCostos(grafo.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matrizCostos, grafo.getVertices(), "Matriz de Caminos");


        Double[][] matriz2 = grafo.floyd();
        Map<Comparable, IVertice> vertices3 = grafo.getVertices();

        UtilGrafos.imprimirMatrizMejorado(matriz2, vertices3, "Matriz de Caminos Mínimos");

    }
}
