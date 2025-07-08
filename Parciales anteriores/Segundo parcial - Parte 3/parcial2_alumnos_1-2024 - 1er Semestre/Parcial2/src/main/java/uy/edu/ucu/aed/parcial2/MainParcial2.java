package uy.edu.ucu.aed.parcial2;

import uy.edu.ucu.aed.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Algoritmo y Estrucutras de Datos
 * Parcial 2 - Parte 3
 *
 */
public class MainParcial2 
{
    public static void main(String[] args) {
        TGrafoDeLaRed grafo = UtilGrafos.cargarGrafo(
                "./src/main/java/uy/edu/ucu/aed/parcial2/vertices.txt",
                "./src/main/java/uy/edu/ucu/aed/parcial2/aristas.txt",
                false,
                TGrafoDeLaRed.class,
                TVerticeDeLaRed.class
        );

        TCaminos<TNodoDeLaRed> caminos = grafo.todosLosCaminos("Vertice_3", "Vertice_4");

        List<TCamino<TNodoDeLaRed>> listaCaminos = (List<TCamino<TNodoDeLaRed>>) caminos.getCaminos();
        Collections.sort(listaCaminos, Comparator.comparingDouble(TCamino::getCostoTotal));

        String[] lineasSalida = new String[listaCaminos.size()];
        for (int i = 0; i < listaCaminos.size(); i++) {
            TCamino<TNodoDeLaRed> camino = listaCaminos.get(i);
            lineasSalida[i] = camino.imprimirEtiquetas() + " - Costo: " + camino.getCostoTotal();
        }

        ManejadorArchivosGenerico.escribirArchivo("salida.txt", lineasSalida);
        System.out.println("Archivo salida.txt generado correctamente.");
    }
}

