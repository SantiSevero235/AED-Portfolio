package uy.edu.ucu.aed;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class TGrafoDirigido implements IGrafoDirigido {

    private Map<Comparable, IVertice> vertices; // vertices del grafo.-

    public TGrafoDirigido(Collection<IVertice> vertices, Collection<IArista> aristas) {
        this.vertices = new HashMap<>();
        for (IVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (IArista arista : aristas) {
            insertarArista(arista);
        }
    }

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino. En
     * caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean invalidas, retorna falso.
     *
     */
    @Override
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            IVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            if (vertOrigen != null) {
                return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
        }
        return false;
    }

    
    /**
     * Metodo encargado de verificar la existencia de una arista. Las etiquetas
     * pasadas por par�metro deben ser v�lidas.
     *
     * @return True si existe la adyacencia, false en caso contrario
     */
    @Override
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        IVertice vertOrigen = buscarVertice(etiquetaOrigen);
        IVertice vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de un vertice dentro del
     * grafo.-
     *
     * La etiqueta especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
     */
    @Override
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    private IVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Metodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea valida,
     * se deben cumplir los siguientes casos: 1) Las etiquetas pasadas por
     * parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    @Override
    public boolean insertarArista(IArista arista) {
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            IVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            IVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            if ((vertOrigen != null) && (vertDestino != null)) {
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de insertar un vertice en el grafo.
     *
     * No pueden ingresarse vertices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    public boolean insertarVertice(Comparable unaEtiqueta) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            IVertice vert = new TVertice(unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    @Override
    public boolean insertarVertice(IVertice vertice) {
        Comparable unaEtiqueta = vertice.getEtiqueta();
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            getVertices().put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, IVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }

    /**
     * @return the vertices
     */
    @Override
    public Map<Comparable, IVertice> getVertices() {
        return vertices;
    }

    public Comparable centroDelGrafo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public Double[][] floyd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean[][] warshall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void desvisitarVertices() {
        for (IVertice vertice : this.vertices.values()) {
            vertice.setVisitado(false);
        }
        
    }

    /**
     * Aplica el algoritmo de Dijkstra para encontrar las distancias más cortas desde el origen
     * a todos los demás vértices. Devuelve un mapa con la distancia mínima desde el origen
     * a cada vértice.
     */
    public Map<Comparable, Double> dijkstra(Comparable etiquetaOrigen) {
        // Verificar que el vértice origen exista en el grafo
        IVertice verticeOrigen = vertices.get(etiquetaOrigen);
        if (verticeOrigen == null) {
            throw new IllegalArgumentException("El vértice de origen no existe: " + etiquetaOrigen);
        }

        // Inicializamos las estructuras
        Map<Comparable, Double> distancias = new HashMap<>();
        Map<Comparable, IVertice> predecesores = new HashMap<>();
        PriorityQueue<IVertice> colaPrioridad = new PriorityQueue<>(Comparator.comparingDouble(v -> distancias.getOrDefault(v.getEtiqueta(), Double.POSITIVE_INFINITY)));

        // Inicializamos todas las distancias como infinito
        for (Comparable etiqueta : vertices.keySet()) {
            distancias.put(etiqueta, Double.POSITIVE_INFINITY);
        }
        distancias.put(etiquetaOrigen, 0.0); // La distancia al origen es 0

        // Agregar el vértice origen a la cola
        if (distancias.get(verticeOrigen.getEtiqueta()) != null) {
            colaPrioridad.add(verticeOrigen);
        }

        while (!colaPrioridad.isEmpty()) {
            IVertice actual = colaPrioridad.poll();

            // Verificamos si `actual` es nulo antes de continuar
            if (actual == null) continue;

            // Iterar sobre los adyacentes utilizando casting
            for (Object obj : actual.getAdyacentes()) {
                TAdyacencia adyacencia = (TAdyacencia) obj;
                if (adyacencia == null) continue;

                IVertice destino = adyacencia.getDestino();
                double nuevaDistancia = distancias.get(actual.getEtiqueta()) + adyacencia.getCosto();

                // Si encontramos un camino más corto, actualizamos la distancia
                if (nuevaDistancia < distancias.get(destino.getEtiqueta())) {
                    distancias.put(destino.getEtiqueta(), nuevaDistancia);
                    predecesores.put(destino.getEtiqueta(), actual);

                    // Añadimos el destino a la cola de prioridad si tiene una distancia válida
                    if (distancias.get(destino.getEtiqueta()) != null) {
                        colaPrioridad.add(destino);
                    }
                }
            }
        }

        return distancias;
    }

    /**
     * Recupera el camino mínimo desde el origen al destino usando Dijkstra.
     * Devuelve una lista de etiquetas de vértices que representan el camino mínimo.
     */
    public List<Comparable> recuperarCaminoDijkstra(Comparable origen, Comparable destino) {
        Map<Comparable, Comparable> predecesores = new HashMap<>();
        dijkstraConCamino(origen, predecesores);

        LinkedList<Comparable> camino = new LinkedList<>();
        Comparable actual = destino;

        // Construimos el camino desde el destino hacia el origen
        while (actual != null && !actual.equals(origen)) {
            camino.addFirst(actual);
            actual = predecesores.get(actual);
        }

        // Si no se alcanzó el origen, significa que no hay un camino
        if (actual == null) {
            return Collections.emptyList();
        } else {
            camino.addFirst(origen);
            return camino;
        }
    }

    private void dijkstraConCamino(Comparable origen, Map<Comparable, Comparable> predecesores) {
        Map<Comparable, Double> distancias = new HashMap<>();
        PriorityQueue<IVertice> colaPrioridad = new PriorityQueue<>(Comparator.comparingDouble(v -> distancias.getOrDefault(v.getEtiqueta(), Double.POSITIVE_INFINITY)));

        // Inicialización de distancias
        for (Comparable etiqueta : vertices.keySet()) {
            distancias.put(etiqueta, Double.POSITIVE_INFINITY);
            predecesores.put(etiqueta, null);
        }
        distancias.put(origen, 0.0);

        IVertice verticeOrigen = vertices.get(origen);
        if (verticeOrigen == null) {
            throw new IllegalArgumentException("El vértice de origen no existe: " + origen);
        }

        // Agregar el vértice origen a la cola
        colaPrioridad.add(verticeOrigen);

        while (!colaPrioridad.isEmpty()) {
            IVertice actual = colaPrioridad.poll();

            // Si actual es nulo, continuamos
            if (actual == null) continue;

            // Iteramos sobre sus adyacentes
            for (Object obj : actual.getAdyacentes()) {
                TAdyacencia adyacencia = (TAdyacencia) obj;
                IVertice destino = adyacencia.getDestino();

                double nuevaDistancia = distancias.get(actual.getEtiqueta()) + adyacencia.getCosto();

                // Si encontramos un camino más corto al destino, actualizamos
                if (nuevaDistancia < distancias.get(destino.getEtiqueta())) {
                    distancias.put(destino.getEtiqueta(), nuevaDistancia);
                    predecesores.put(destino.getEtiqueta(), actual.getEtiqueta());

                    // Agregamos a la cola o actualizamos su prioridad
                    colaPrioridad.remove(destino);
                    colaPrioridad.add(destino);
                }
            }
        }
    }

}
