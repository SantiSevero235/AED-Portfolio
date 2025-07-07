package uy.edu.ucu.aed.tas;

import uy.edu.ucu.aed.tdas.*;
import uy.edu.ucu.aed.utils.ManejadorArchivosGenerico;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class TA6_Ej3 {
    public static void main(String[] args) {
        TGrafoDirigido grafo = UtilGrafos.cargarGrafo("src/main/java/resources/tareas.txt", "src/main/java/resources/precedencias.txt", false, TGrafoDirigido.class);

        LinkedList<TVertice> ver = grafo.ordenParcial();
        for(TVertice v : ver){
            System.out.println(v.getEtiqueta());
        }
    }
}
