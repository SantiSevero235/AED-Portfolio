package uy.edu.ucu.aed.tdas;

import java.util.Collection;
import java.util.LinkedList;

public class TAristas extends LinkedList<IArista> {

    private final static String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public IArista buscar(Comparable etOrigen, Comparable etDestino) {
        for (IArista laa : this) {
            if ((laa.getEtiquetaOrigen().equals(etOrigen)) && laa.getEtiquetaDestino().equals(etDestino)) {
                return laa;
            }
        }
        return null;
    }

    public IArista buscarMin(Collection<Comparable> VerticesU, Collection<Comparable> VerticesV) {
        IArista tempArista;
        IArista tAMin = null;
        Double costoMin = Double.POSITIVE_INFINITY;

        for (Comparable u : VerticesU) {
            for (Comparable v : VerticesV) {
                tempArista = buscar(u, v);
                if (tempArista != null) {
                    if (tempArista.getCosto() < costoMin) {
                        costoMin = tempArista.getCosto();
                        tAMin = tempArista;
                    }
                }
            }
        }
        return tAMin;
    }

    public String imprimirEtiquetas() {
        StringBuilder salida = new StringBuilder();
        for (IArista arista : this) {
            salida.append(arista.getEtiquetaOrigen())
                  .append(" - ")
                  .append(arista.getEtiquetaDestino())
                  .append(" - ")
                  .append(arista.getCosto())
                  .append("\n");
        }
        return salida.toString();
    }
   /*  void insertarAmbosSentidos(Collection<IArista> aristas) {
        for (IArista ta : aristas) {
            this.add(ta);
            this.add(ta.aristaInversa());
        }
    }*/

}
