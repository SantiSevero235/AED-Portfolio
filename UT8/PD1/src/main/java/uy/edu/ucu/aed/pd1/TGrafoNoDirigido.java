package uy.edu.ucu.aed.pd1;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
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
