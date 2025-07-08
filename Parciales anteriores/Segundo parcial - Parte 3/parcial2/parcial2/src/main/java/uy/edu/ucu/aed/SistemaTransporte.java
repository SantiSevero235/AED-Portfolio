package uy.edu.ucu.aed;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class SistemaTransporte { 
    private Map<String, List<Ruta>> grafo;
    private TGrafoDirigido grafoDirigido;
    private TGrafoNoDirigido grafoNoDirigido;

    public SistemaTransporte() {
        this.grafo = new HashMap<>();
        this.grafoDirigido = new TGrafoDirigido(new LinkedList<>(), new LinkedList<>());
        this.grafoNoDirigido = new TGrafoNoDirigido(new LinkedList<>(), new LinkedList<>());
    }
    // Clase interna para representar una ruta 
    private static class Ruta { 
        String destino; 
        int tiempo; 
    } 

    // Clase interna para representar una estación en la consulta de tiempo mínimo 
    private static class Estacion {
        String nombre; 
    } 

    // Clase interna para representar una ruta conectada en el árbol generador mínimo 
    public static class RutaConectada {
        String origen; 
        String destino; 
        int tiempo;
    }

    public void agregarRuta(String origen, String destino, int tiempo) {
        Ruta nuevaRuta = new Ruta();
        nuevaRuta.destino = destino;
        nuevaRuta.tiempo = tiempo;
        List<Ruta> rutas = new LinkedList<Ruta>();
        rutas.add(nuevaRuta);
        this.grafo.put(origen, rutas);
        grafoDirigido.insertarVertice(origen);
        grafoDirigido.insertarVertice(destino);
        TArista arista = new TArista(origen, destino, tiempo);
        grafoDirigido.insertarArista(arista);
        grafoNoDirigido.insertarVertice(origen);
        grafoNoDirigido.insertarVertice(destino);
        grafoNoDirigido.insertarArista(arista);
    }

    /** 
     * Encuentra el tiempo mínimo de viaje entre dos estaciones.
     * @param origen  Nombre de la estación de origen.
     * @param destino Nombre de la estación de destino.
     * @return Tiempo mínimo necesario para viajar entre las estaciones, o -1 si no hay camino. 
     */ 
     public int consultaTiempoMinimo(String origen, String destino) {
        if (!grafoDirigido.getVertices().containsKey(origen) || !grafoDirigido.getVertices().containsKey(destino)) {
            return -1;
        }
        Map<Comparable, Double> distancias = grafoDirigido.dijkstra(origen);
        Double distanciaMinima = distancias.get(destino);
        if (distanciaMinima == Double.POSITIVE_INFINITY) {
            return -1;
        }
        return distanciaMinima.intValue();
     }

     /** 
     * Encuentra un subconjunto mínimo de rutas para conectar todas las estaciones. 
     * @return Lista de rutas seleccionadas en el formato (origen, destino, tiempo). 
     */ 
    public List<RutaConectada> redDeMantenimiento() {
        TGrafoNoDirigido grafoNoDirigidoResult = grafoNoDirigido.Kruskal();
        return grafoNoDirigidoResult.parcial(grafoNoDirigidoResult);
    };


} 

