package uy.edu.ucu.aed.parcial1;

import uy.edu.ucu.aed.tdas.IElementoAB;
import java.util.LinkedList;

public class Genealogia {

    /**
     * Calcula el parentesco entre dos personas en un árbol genealógico invertido.
     *
     * @param raiz     Nodo raíz del árbol (persona más reciente en el linaje).
     * @param persona1 Nodo que representa a la primera persona.
     * @param persona2 Nodo que representa a la segunda persona.
     * @return ResultadoParentesco con los grados y el tipo ("consanguinidad" o "político").
     */
    public static ResultadoParentesco calcularParentesco(
            IElementoAB<Persona> raiz,
            IElementoAB<Persona> persona1,
            IElementoAB<Persona> persona2
    ) {
        LinkedList<IElementoAB<Persona>> ruta1 = new LinkedList<>();
        LinkedList<IElementoAB<Persona>> ruta2 = new LinkedList<>();

        boolean encontrada1 = encontrarRuta(raiz, persona1, ruta1);
        boolean encontrada2 = encontrarRuta(raiz, persona2, ruta2);

        if (!encontrada1 || !encontrada2) {
            return new ResultadoParentesco(-1, "desconocido");
        }

        // Buscar el índice donde divergen las rutas
        int i = 0;
        while (i < ruta1.size() && i < ruta2.size()
                && ruta1.get(i).getEtiqueta().equals(ruta2.get(i).getEtiqueta())) {
            i++;
        }

        int distancia1 = ruta1.size() - i;
        int distancia2 = ruta2.size() - i;
        int grados = distancia1 + distancia2;

        // Criterio de tipo de parentesco según el parcial
        String tipo;
        if (distancia1 == 0 || distancia2 == 0) {
            tipo = "consanguinidad"; // Uno es ancestro del otro
        } else {
            tipo = "político"; // Comparten un descendiente común, pero no están en la misma rama
        }

        return new ResultadoParentesco(grados, tipo);
    }

    /**
     * Encuentra la ruta desde la raíz hasta una persona específica.
     *
     * @param actual Nodo actual.
     * @param objetivo Persona buscada.
     * @param ruta Ruta acumulada desde la raíz.
     * @return true si se encontró la persona; false en caso contrario.
     */
    private static boolean encontrarRuta(
            IElementoAB<Persona> actual,
            IElementoAB<Persona> objetivo,
            LinkedList<IElementoAB<Persona>> ruta
    ) {
        if (actual == null) {
            return false;
        }

        ruta.add(actual);

        if (actual.getEtiqueta().equals(objetivo.getEtiqueta())) {
            return true;
        }

        if (encontrarRuta(actual.getHijoIzq(), objetivo, ruta)) {
            return true;
        }

        if (encontrarRuta(actual.getHijoDer(), objetivo, ruta)) {
            return true;
        }

        ruta.removeLast(); // backtracking
        return false;
    }
}
