package uy.edu.ucu.aed.tas;

import uy.edu.ucu.aed.tdas.*;
import uy.edu.ucu.aed.utils.ManejadorArchivosGenerico;

import java.util.ArrayList;
import java.util.Collection;

public class TA5 {
    public static void main(String[] args) {
        TGrafoDirigido grafo = UtilGrafos.cargarGrafo("src/main/java/resources/aeropuertos_2.txt", "src/main/java/resources/conexiones_2.txt", false, TGrafoDirigido.class);


        TCaminos caminos = grafo.todosLosCaminos("Buenos_Aires", "Montevideo");

        System.out.println("Caminos desde Buenos Aires hasta Montevideo");
        for (TCamino camino : caminos.getCaminos()) {
            System.out.println("Camino: " + camino.imprimirEtiquetas());
            System.out.println("Costo total: " + camino.getCostoTotal());
        }
    }
}
