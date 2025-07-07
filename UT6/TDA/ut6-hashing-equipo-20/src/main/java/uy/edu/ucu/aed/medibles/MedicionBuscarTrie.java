package uy.edu.ucu.aed.medibles;

import uy.edu.ucu.aed.tdas.TArbolTrie;


public class MedicionBuscarTrie extends Medible {

    private TArbolTrie arbolTrie;

    public MedicionBuscarTrie(TArbolTrie arbolTrie) {
        this.arbolTrie = arbolTrie;
    }

    @Override
    public void ejecutar(Object... params) {
        if (params.length != 2 || !(params[0] instanceof Integer) || !(params[1] instanceof String[])) {
            throw new IllegalArgumentException("Parámetros inválidos. Se esperan: (int repeticion, String[] palabras)");
        }

        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];
        for (int i = 0; i < repeticion; i++) {
            for (String palabra : palabras) {
                arbolTrie.buscar(palabra);
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return this.arbolTrie;
    }
}
