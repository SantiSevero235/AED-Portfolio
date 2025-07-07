package uy.edu.ucu.aed.tas;

import uy.edu.ucu.aed.tdas.*;
import uy.edu.ucu.aed.utils.ManejadorArchivosGenerico;

import java.util.ArrayList;
import java.util.Collection;

public class TA6 {
    public static void main(String[] args) {
        TGrafoDirigido grafo = UtilGrafos.cargarGrafo("src/main/java/resources/aeropuertos_2.txt", "src/main/java/resources/conexiones_2.txt", false, TGrafoDirigido.class);

        System.out.println(grafo.tieneCiclo());
        grafo.calcularCaminoCritico("Rio_de_Janeiro", "Florianopolis");
    }
}
