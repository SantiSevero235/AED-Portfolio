package uy.edu.ucu.aed.medibles;

import java.util.TreeMap;

public class MedicionBuscarTreeMap extends Medible { 
    
    // Atributo que almacena la LinkedList sobre la cual se realizarán las búsquedas
    private TreeMap<String, String> treeMap;

    /**
     * Constructor de la clase MedicionBuscarLinkedList.
     * Inicializa la LinkedList sobre la cual se realizarán las búsquedas.
     *
     * @param linkedList LinkedList que se utilizará para las búsquedas.
     */
    public MedicionBuscarTreeMap(TreeMap<String, String> TreeMap) {
        this.treeMap = TreeMap;
    }

    @Override
    public void ejecutar(Object... params) {
        // La operación a medir es la búsqueda de elementos en la LinkedList.
        // Se espera que params contenga dos elementos: el número de repeticiones y un arreglo de palabras a buscar.
        
        if (params.length != 2 || !(params[0] instanceof Integer) || !(params[1] instanceof String[])) {
            throw new IllegalArgumentException("Parámetros inválidos. Se esperan: (int repeticion, String[] palabras)");
        }
        
        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];
        for (int i = 0; i < repeticion; i++) {
            for (String palabra : palabras) {
                treeMap.get(palabra);
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        // El objeto cuyo tamaño en memoria se medirá es la LinkedList utilizada para las búsquedas.
        return this.treeMap;
    }
}

