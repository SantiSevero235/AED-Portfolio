package uy.edu.ucu.aed.tdas;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import uy.edu.ucu.aed.tas.IGrafoKevinBacon;

/**
 * Clase que modela un grafo no dirigido extendiendo la funcionalidad de un grafo dirigido,
 * incluyendo algoritmos como Prim, Kruskal, BEA, detección de ciclos, puntos de articulación,
 * y número de Bacon.
 */
public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido, IGrafoKevinBacon { //el kevin es el del ta5, basicamente el factor de kevin bacon es el num de actores que hay entre kevin bacon y el actor que se le pasa como parametro
    protected TAristas lasAristas = new TAristas();

    public TGrafoNoDirigido(Collection<IVertice> vertices, Collection<IArista> aristas) {
        super(vertices, new LinkedList<>()); // el super constructor inicializa las aristas como una lista vacía

        this.lasAristas = new TAristas(); // se inicializa antes, para que no de null pointer

        if (aristas != null) {
            for (IArista arista : aristas) {
                this.insertarArista(arista); // este ya maneja ambos sentidos y actualiza lasAristas
            }
        }
    }




    @Override
    public boolean tieneCiclo() {
        this.desvisitarVertices();

        for (IVertice vertice : this.getVertices().values()) {
            if (!vertice.getVisitado()) {
                TCamino camino = new TCamino((TVertice) vertice);
                if (((TVertice) vertice).tieneCicloNoDirigido(camino, null)) {
                    return true;
                }
            }
        }

        return false;
    }




        @Override
    public boolean insertarArista(IArista arista) {
        if (arista == null || arista.getEtiquetaOrigen() == null || arista.getEtiquetaDestino() == null) {
            return false;
        }

        IArista aristaInversa = arista.aristaInversa();

        boolean insertada1 = super.insertarArista(arista);        // Inserta en un sentido
        boolean insertada2 = super.insertarArista(aristaInversa); // Inserta en el otro

        if (insertada1 && insertada2) {
            // Solo si ambas fueron insertadas con éxito, las agregamos a lasAristas
            lasAristas.add(arista);
        }

        return insertada1 && insertada2;
    }


/* 
    @Override
    public boolean insertarArista(IArista arista) {
        boolean tempbool = false;
        IArista arInv = arista.aristaInversa();
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));

        
        Collection<IArista> aristasAdd = new LinkedList<>();
        aristasAdd.add(arista);
        lasAristas.insertarAmbosSentidos(aristasAdd);

        return tempbool;
    }

    public boolean insertarAristaManual(IArista arista) {
        boolean tempbool = false;
        IArista arInv = arista.aristaInversa();
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        Collection<IArista> aristasAdd = new LinkedList<>();
        aristasAdd.add(arista);
        lasAristas.insertarAmbosSentidos(aristasAdd);
        return tempbool;
    }*/

    public TAristas getLasAristas() {
        return lasAristas; // Devuelve la lista de aristas auxiliares
    }

    @Override
    public TGrafoNoDirigido Prim() {
        LinkedList<IArista> aristasTotal = new LinkedList<>(); // Resultado MST
        LinkedList<Comparable> verticesV = new LinkedList<>(); // Vertices por visitar
        LinkedList<Comparable> verticesU = new LinkedList<>(); // Vertices ya incluidos
        LinkedList<IVertice> verticesCrear = new LinkedList<>(); // Vertices para nuevo grafo MST
        double costoPrim = 0.0d;

        for (IVertice v : this.getVertices().values()) {
            verticesV.add(v.getEtiqueta());
            verticesCrear.add(new TVertice<>(v.getEtiqueta())); // Se clonan los vértices
        }

        verticesU.add(verticesV.removeFirst()); // Se arranca con un vértice cualquiera

        while (!verticesV.isEmpty()) {
            IArista aristaMin = lasAristas.buscarMin(verticesU, verticesV); // Busca arista mínima entre conjuntos
            aristasTotal.add(aristaMin);
            verticesV.remove(aristaMin.getEtiquetaDestino());
            verticesU.add(aristaMin.getEtiquetaDestino());
            costoPrim += aristaMin.getCosto();
        }

        System.out.println("Costo: " + costoPrim);
        return new TGrafoNoDirigido(verticesCrear, aristasTotal);
    }

        @Override
    public TGrafoNoDirigido Kruskal() {
        LinkedList<IArista> aristasKruskal = new LinkedList(); // Aqui se almacenaran las aristas seleccionadas.
        Map<Comparable, IVertice> vertices = getVertices();

        if (!vertices.isEmpty()) {
            desvisitarVertices();
            HashMap<Comparable, LinkedList<IVertice>> colecciones = new HashMap(vertices.size());
            LinkedList<IVertice> colTemp;

            // Creamos una "coleccion" para cada arista
            for (IVertice v : vertices.values()) {
                colTemp = new LinkedList();
                colTemp.add(v);
                colecciones.put(v.getEtiqueta(), colTemp);
            }

            // Ordenamos todas las aristas del grafo de menor costo a mayor
            LinkedList<IArista> aristasOrdenadas = new LinkedList();
            forAristas: for (IArista a : lasAristas) {
                if (aristasOrdenadas.isEmpty() || aristasOrdenadas.getFirst().getCosto() > a.getCosto()) {
                    aristasOrdenadas.addFirst(a);
                    continue;
                }
                for (int i = 1; i < aristasOrdenadas.size(); i++) {
                    if (aristasOrdenadas.get(i).getCosto() > a.getCosto()) {
                        aristasOrdenadas.add(i - 1, a);
                        continue forAristas;
                    }
                }
                aristasOrdenadas.add(a);
            }

            // Conectamos las colecciones de vertices (no conectados) mediante la arista de
            // menor costo posible
            TArista menorArista;
            LinkedList<IVertice> colOrigen, colDestino;
            while (!aristasOrdenadas.isEmpty()) {
                menorArista = (TArista) aristasOrdenadas.pollFirst();
                colOrigen = colecciones.get(menorArista.etiquetaOrigen);
                colDestino = colecciones.get(menorArista.etiquetaDestino);
                if (colOrigen != colDestino) {
                    colOrigen.addAll(colDestino);
                    for (IVertice v : colDestino) {
                        if (colecciones.get(v.getEtiqueta()) != colOrigen) {
                            colecciones.replace(v.getEtiqueta(), colOrigen);
                        }
                    }
                    aristasKruskal.add(menorArista);
                }
            }
        }

        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices.values(), aristasKruskal);
        return grafo;
    }

    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        Collection<TVertice> visitados = new LinkedList<>();

        if (this.getVertices().isEmpty()) return visitados;

        this.desvisitarVertices();

        if (this.existeVertice(etiquetaOrigen)) {
            IVertice vert = buscarVertice(etiquetaOrigen);
            vert.bea(visitados); // BFS desde vértice dado
        }

        return visitados; // Si no existía el vértice, se devuelve lista vacía
    }

    @Override
    public Collection<TVertice> bea() {
        Collection<TVertice> lista = new LinkedList<>();

        if (this.getVertices().isEmpty()) return lista;

        this.desvisitarVertices();

        for (IVertice vertice : this.getVertices().values()) {
            if (!vertice.getVisitado()) {
                vertice.bea(lista); // BFS desde todos los vértices no visitados
            }
        }

        return lista;
    }


    @Override
    public int numBacon(Comparable actor) {
        this.desvisitarVertices();
        if (this.getVertices().isEmpty()) return -1;

        if (this.existeVertice("Kevin_Bacon")) {
            IVertice raiz = this.getVertices().get("Kevin_Bacon");
            LinkedList<IVertice> lista = new LinkedList<>();
            raiz.setVisitado(true);
            lista.add(raiz);

            while (!lista.isEmpty()) {
                IVertice actual = lista.removeFirst();
                for (IAdyacencia ady : actual.getAdyacentes()) {
                    if (!ady.getDestino().getVisitado()) {
                        TVertice destino = (TVertice) ady.getDestino();
                        destino.setBacon(((TVertice) actual).getBacon() + 1); // Incrementa distancia
                        destino.setVisitado(true);
                        lista.add(destino);
                        if (destino.getEtiqueta().compareTo(actor) == 0) {
                            return destino.getBacon(); // Actor encontrado
                        }
                    }
                }
            }
        }
        return -1; // Si no se encontró camino
    }

        public LinkedList<IVertice> puntosArticulacion() {
        this.desvisitarVertices();
        LinkedList<IVertice> puntos = new LinkedList<>();
        LinkedList<TVertice> verticesRecorrer = new LinkedList<>();

        Map<Comparable, IVertice> verticesMap = this.getVertices();

        for (Map.Entry<Comparable, IVertice> entry : verticesMap.entrySet()) {
            TVertice vertice = (TVertice) entry.getValue();
            verticesRecorrer.add(vertice);
        }

        for (TVertice vertice : verticesRecorrer) {
            if (!vertice.getVisitado()) {
                vertice.puntosArticulacion(puntos, 0);
            }

        }
        return puntos;

    }
}
