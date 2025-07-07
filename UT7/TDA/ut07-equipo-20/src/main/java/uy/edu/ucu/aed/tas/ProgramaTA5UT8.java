package uy.edu.ucu.aed.tas;

import uy.edu.ucu.aed.tdas.TGrafoNoDirigido;
import uy.edu.ucu.aed.tdas.UtilGrafos;

public class ProgramaTA5UT8 {

    /**
     * @param args the command line arguments
     */

        public static void main(String[] args) {
    // cargar grafo con actores y relaciones
    TGrafoNoDirigido kevin = (TGrafoNoDirigido) UtilGrafos.cargarGrafo(
            "src/main/java/resources/actores.csv",
            "src/main/java/resources/en_pelicula.csv",
 false, TGrafoNoDirigido.class);

    String[] actores = { "Harrison_Ford", "Peter_Stormare", "Tom_Hanks" };
        for (String actor : actores) {
            System.out.println("El actor " + actor + " tiene un Kevin_Bacon de: " + kevin.numBacon(actor));
        }

}
        

    }


