package uy.edu.ucu.aed.pd2;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido {

    protected TAristas lasAristas = new TAristas();

    /**
     *
     * @param vertices
     * @param aristas
     */
    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
        lasAristas.insertarAmbosSentidos(aristas);

    }

    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
    }

    public TAristas getLasAristas() {
        return lasAristas;
    }

    @Override
    public TGrafoNoDirigido Prim() {
        LinkedList<TArista> aristasTotal = new LinkedList<>(); // Resultado MST
        LinkedList<Comparable> verticesV = new LinkedList<>(); // Vertices por visitar
        LinkedList<Comparable> verticesU = new LinkedList<>(); // Vertices ya incluidos
        LinkedList<TVertice> verticesCrear = new LinkedList<>(); // Vertices para nuevo grafo MST
        double costoPrim = 0.0d;

        for (TVertice v : this.getVertices().values()) {
            verticesV.add(v.getEtiqueta());
            verticesCrear.add(new TVertice<>(v.getEtiqueta())); // Se clonan los vértices
        }

        verticesU.add(verticesV.removeFirst()); // Se arranca con un vértice cualquiera

        while (!verticesV.isEmpty()) {
            TArista aristaMin = lasAristas.buscarMin(verticesU, verticesV); // Busca arista mínima entre conjuntos
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
        LinkedList<TArista> aristasKruskal = new LinkedList(); // Aqui se almacenaran las aristas seleccionadas.
        Map<Comparable, TVertice> vertices = getVertices();

        if (!vertices.isEmpty()) {
            desvisitarVertices();
            HashMap<Comparable, LinkedList<TVertice>> colecciones = new HashMap(vertices.size());
            LinkedList<TVertice> colTemp;

            // Creamos una "coleccion" para cada arista
            for (TVertice v : vertices.values()) {
                colTemp = new LinkedList();
                colTemp.add(v);
                colecciones.put(v.getEtiqueta(), colTemp);
            }

            // Ordenamos todas las aristas del grafo de menor costo a mayor
            LinkedList<TArista> aristasOrdenadas = new LinkedList();
            forAristas: for (TArista a : lasAristas) {
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
            LinkedList<TVertice> colOrigen, colDestino;
            while (!aristasOrdenadas.isEmpty()) {
                menorArista = aristasOrdenadas.pollFirst();
                colOrigen = colecciones.get(menorArista.etiquetaOrigen);
                colDestino = colecciones.get(menorArista.etiquetaDestino);
                if (colOrigen != colDestino) {
                    colOrigen.addAll(colDestino);
                    for (TVertice v : colDestino) {
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
        if (this.getVertices().isEmpty()) return null;

        this.desvisitarVertices();
        if (this.existeVertice(etiquetaOrigen)) {
            IVertice vert = buscarVerticePublic(etiquetaOrigen);
            Collection<TVertice> visitados = new LinkedList<>();
            vert.bea(visitados); // BFS desde vértice dado
            return visitados;
        }
        return null;
    }

    @Override
    public Collection<TVertice> bea() {
        this.desvisitarVertices();
        Collection<TVertice> lista = new LinkedList<>();
        for (TVertice vertice : this.getVertices().values()) {
            if (!vertice.getVisitado()) {
                vertice.bea(lista); // BFS desde todos los vértices no visitados
            }
        }
        return lista;
    }
	 
	@Override
	public LinkedList<TVertice> puntosArticulacion(Comparable etOrigen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
	@Override
	public boolean esConexo(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
