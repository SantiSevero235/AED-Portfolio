
import java.util.Collection;
import java.util.LinkedList;

public class TAristas extends LinkedList<TArista> {

    private final static String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArista buscar(Comparable etOrigen, Comparable etDestino) {
        for (TArista laa : this) {
            if ((laa.getEtiquetaOrigen().equals(etOrigen)) && laa.getEtiquetaDestino().equals(etDestino)) {
                return laa;
            }
        }
        return null;
    }

    public TArista buscarMin(Collection<Comparable> VerticesU, Collection<Comparable> VerticesV) {
        TArista tempArista;
        TArista tAMin = null;
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
    void insertarAmbosSentidos(Collection<TArista> aristas) {
        for (TArista ta : aristas) {
            this.add(ta);
            this.add(ta.aristaInversa());
        }
    }

}
