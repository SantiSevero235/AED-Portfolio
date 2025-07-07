package uy.edu.ucu.aed.medibles;

import java.util.Collection;
import java.util.HashMap;
import java.util.TreeMap;

public class MedicionPredecirHashMap extends Medible {

    private HashMap<String, String> hashMap;

    public MedicionPredecirHashMap(HashMap<String, String> hashMap) {
        this.hashMap = hashMap;
    }

    @Override
    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];
        Collection<String> valores = hashMap.values();
        for (int i = 0; i < repeticion; i++) {
            for (String palabra : palabras) {
                for (String object : valores) {
                    object.startsWith(palabra);
                }
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return this.hashMap;
    }
}
