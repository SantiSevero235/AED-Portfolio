package uy.edu.ucu.aed.medibles;

import java.util.Collection;
import java.util.TreeMap;

public class MedicionPredecirTreeMap extends Medible {

    private TreeMap<String, String> treeMap;

    public MedicionPredecirTreeMap(TreeMap<String, String> treeMap) {
        this.treeMap = treeMap;
    }

    @Override
    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];
        Collection<String> valores = treeMap.values();
        for (int i = 0; i < repeticion; i++) {
            for (String palabra : palabras) {
                for (String elemento : valores) {
                    elemento.startsWith(palabra);
                }
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return this.treeMap;
    }
}
