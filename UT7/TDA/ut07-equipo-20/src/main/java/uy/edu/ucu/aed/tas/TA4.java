package uy.edu.ucu.aed.tas;

import uy.edu.ucu.aed.tdas.*;
import uy.edu.ucu.aed.utils.ManejadorArchivosGenerico;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class TA4 {
    public static void main(String[] args){

        String[] Aeropuertos = ManejadorArchivosGenerico.leerArchivo("src\\main\\java\\resources\\aeropuertos2", false);
        String[] Conexiones = ManejadorArchivosGenerico.leerArchivo("src\\main\\java\\resources\\conexiones2", false);

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

        System.out.println(">> bpf()");
        //Debido al toString() en TVertice, los vértices se imprimen por su etiqueta.
        System.out.println(grafo.bpf());

        TVertice montevideo = (TVertice) grafo.getVertices().get("Montevideo");
        System.out.println(">> bpf(TVertice)");
        Collection<TVertice> resultado = grafo.bpf(montevideo);
        System.out.println("Visitados: " + resultado);

        System.out.println(">> bpf(Comparable)");
        Collection<TVertice> resultado2 = grafo.bpf("Atlantis");
        System.out.println("Visitados: " + resultado2);

    }
}
