package uy.edu.ucu.aed.tas.ta3;

import uy.edu.ucu.aed.medibles.*;
import uy.edu.ucu.aed.tdas.TArbolTrie;
import uy.edu.ucu.aed.utils.*;
import java.util.*;

public class Main {

    private static final int REPETICIONES = 100;

    /**
     * Método principal que ejecuta las mediciones de tiempo y memoria al buscar palabras en diferentes estructuras de datos.
     * Crea instancias de LinkedList, ArrayList, HashMap y TreeMap, y realiza inserciones y búsquedas en cada una.
     * Finalmente, escribe los resultados de las mediciones en un archivo CSV.
     *
     * @param args Argumentos de línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args){
        TArbolTrie trie = new TArbolTrie(); // Descomentar esta línea luego de traer la implementación del TArbolTrie
        LinkedList<String> linkedList = new LinkedList<String>();
        ArrayList<String> arrayList = new ArrayList<String>();
        HashMap<String, String> hashMap = new HashMap<String, String>();
        TreeMap<String, String> treeMap = new TreeMap<String, String>();
        
        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("./src/main/java/uy/edu/ucu/aed/tas/ta3/listado-general_desordenado.txt");
        String[] palabrasBuscar = ManejadorArchivosGenerico.leerArchivo("./src/main/java/uy/edu/ucu/aed/tas/ta3/listado-general_palabrasBuscar.txt");
        for (String p : palabrasclave) {
                // insertar la palabra p en el trie
                trie.insertar(p);
                // insertar la palabra p en el linkedList
                linkedList.add(p);
                // insertar la palabra p en el arrayList
                arrayList.add(p);
                // insertar la palabra p en el hashMap
                hashMap.put(p, p);
                // insertar la palabra p en el treeMap
                treeMap.put(p, p);
        }
        
        // Crear un arreglo de objetos Medible para almacenar las mediciones
        Medible[] medibles = new Medible[5];
        int i = 0;
        medibles[i++] = new MedicionBuscarLinkedList(linkedList);
        medibles[i++] = new MedicionBuscarArrayList(arrayList);
        medibles[i++] = new MedicionBuscarTrie(trie);
        medibles[i++] = new MedicionBuscarHashMap(hashMap);
        medibles[i++] = new MedicionBuscarTreeMap(treeMap);
        Medicion mi;
	    i = 0;
        Object[] params = {REPETICIONES, palabrasBuscar};
        String[] lineas = new String[6];
		lineas[i++] = "algoritmo,tiempo,memoria";
		for (Medible m: medibles){
            mi= m.medir(params);
			System.out.println(mi.toString());
			lineas[i++] = mi.getTexto()+","+mi.getTiempoEjecucion().toString()+","+mi.getMemoria().toString();
        }
		
		 ManejadorArchivosGenerico.escribirArchivo("./src/salida.csv",lineas);

        // ----- Medición de PREDICCIÓN con prefijo "cas" -----
        System.out.println("\n=== Medición de predicción con prefijo 'cas' ===");

        String[] prefijos = {"cas"};
        Object[] paramsPrediccion = {REPETICIONES, prefijos};

        Medible[] mediblesPrediccion = new Medible[5];
        int j = 0;
        mediblesPrediccion[j++] = new MedicionPredecirLinkedList(linkedList);
        mediblesPrediccion[j++] = new MedicionPredecirArrayList(arrayList);
        mediblesPrediccion[j++] = new MedicionPredecirHashMap(hashMap);
        mediblesPrediccion[j++] = new MedicionPredecirTreeMap(treeMap);
        mediblesPrediccion[j++] = new MedicionPredecirTrie(trie);

        String[] lineasPrediccion = new String[6];
        lineasPrediccion[0] = "estructura,tiempo,memoria";
        j = 1;

        for (Medible m : mediblesPrediccion) {
            Medicion mp = m.medir(paramsPrediccion);
            System.out.println(mp.toString());
            lineasPrediccion[j++] = mp.getTexto() + "," + mp.getTiempoEjecucion() + "," + mp.getMemoria();
        }

        ManejadorArchivosGenerico.escribirArchivo("./src/salida_cas.csv", lineasPrediccion);
    }
}