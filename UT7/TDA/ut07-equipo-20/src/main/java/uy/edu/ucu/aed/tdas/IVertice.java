package uy.edu.ucu.aed.tdas;

import java.util.Collection;
import java.util.LinkedList;

public interface IVertice  {

    IAdyacencia buscarAdyacencia(IVertice verticeDestino);

    IAdyacencia buscarAdyacencia(Comparable etiquetaDestino);

    boolean eliminarAdyacencia(Comparable nomVerticeDestino);

    LinkedList<IAdyacencia> getAdyacentes();

    Object getDatos();

    Comparable getEtiqueta();

    boolean getVisitado();

    boolean insertarAdyacencia(Double costo, IVertice verticeDestino);

    Double obtenerCostoAdyacencia(IVertice verticeDestino);

    IVertice primerAdyacente();

    void setVisitado(boolean valor);

    TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos);

    boolean tieneCiclo(TCamino unCamino);

    void ordenParcial(LinkedList<TVertice> orden);

    // MÉTODOS AGREGADOS PARA UT08

    void bea(Collection<TVertice> visitados); // BFS

    void bpf(Collection<TVertice> visitados); // DFS

    void puntosArticulacion(LinkedList<IVertice> puntos, int prof); // Articulación

    int getBacon(); // Para UT05 (Kevin Bacon)

    void setBacon(int newBacon); // Para UT05

    boolean tieneCicloNoDirigido(TCamino camino, TVertice padre);
 // Para UT08
}
