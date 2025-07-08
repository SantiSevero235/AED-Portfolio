package uy.edu.ucu.aed;


/*
 * NO LICENCE 
 * Author: Ing. Agustin Paredes
 */

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author agustinp
 */
public class TGrafoRedDatos extends TGrafoNoDirigido implements ITGrafoRedDatos
{

    public TGrafoRedDatos(Collection<TVertice> vertices, Collection<TArista> aristas)
    {

        super(vertices, aristas);
    }

    @Override
    public boolean conectados(Comparable a, Comparable b)
    {
        Collection<TVertice> alcanzados = bea(a);

        for (TVertice v : alcanzados) {
            if (v.getEtiqueta().equals(b)) {
                return true;
            }
        }
        return false;
    }

    public Collection<TVertice> bpf(TVertice vertice) {
        Collection<TVertice> visitados = new LinkedList<>();

        //Nos aseguramos que todos los vertices no esten visitado
        for (TVertice v : vertices.values()){
            v.setVisitado(false);
        }

        vertice.bpf((List<TVertice>) visitados);

        return visitados;
    }

    public Collection<TVertice> bpf() {
        Collection<TVertice> visitados = new LinkedList<>();

        //Nos aseguramos que todos los vertices no esten visitado
        for (TVertice v : vertices.values()){
            v.setVisitado(false);
        }

        //Ahora si recorremos todos los vertices una ves desmarcados todos los nodos
        for (IVertice vertice : vertices.values()){
            TVertice unVertice = (TVertice) vertice;
            if (!unVertice.getVisitado()){
                unVertice.bpf((List<TVertice>) visitados);
            }
        }

        return visitados;
    }

    public Collection<TVertice> bpf(Comparable etiquetaOrigen) {
        Collection<TVertice> visitados = new LinkedList<>();

        /* Accedo directamenete por la clave al vertice que estoy buscando, me evito recorrer todo.
        esto gracias al Map<Collection, IVertices> vertices */
        TVertice vertice = (TVertice) vertices.get(etiquetaOrigen);

        if (vertice == null) {
            System.out.println("No existe ningún vértice con la etiqueta dada.");
            return new LinkedList<>();
        }

        return bpf(vertice); //Llamo al otro metodo
    }

    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        if (this.getVertices().isEmpty()) return null;

        this.desvisitarVertices();
        if (this.existeVertice(etiquetaOrigen)) {
            TVertice vert = buscarVertice(etiquetaOrigen);
            List<TVertice> visitados = new LinkedList<>();
            vert.bea(visitados); // BFS desde vértice dado
            return visitados;
        }
        return null;
    }

    public Collection<TVertice> bea() {
        this.desvisitarVertices();
        List<TVertice> lista = new LinkedList<>();
        for (TVertice vertice : this.getVertices().values()) {
            if (!vertice.getVisitado()) {
                vertice.bea(lista); // BFS desde todos los vértices no visitados
            }
        }
        return lista;
    }


}
