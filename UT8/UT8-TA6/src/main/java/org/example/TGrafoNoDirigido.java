package org.example;

import java.util.*;

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
        Collection<Comparable> V = new ArrayList<>();
        Collection<Comparable> U = new ArrayList<>();
        Collection<TArista> AristasAAM = new ArrayList<>();
        double costoPrim = 0;

        for (TVertice vertice : this.getVertices().values()) {
            V.add(vertice.getEtiqueta());
        }

        U.add(V.iterator().next());
        V.remove(V.iterator().next());

        while (V.size() != 0) {
            TArista tempArista = this.lasAristas.buscarMin(U, V);
            AristasAAM.add(tempArista);
            V.remove(tempArista.getEtiquetaDestino());
            U.add(tempArista.getEtiquetaDestino());
            costoPrim = costoPrim + tempArista.getCosto();
        }

        Collection<TVertice> VerticesSeleccionados = new ArrayList<>();

        for (Comparable vertice : U) {
            VerticesSeleccionados.add(new TVertice(vertice));
        }

        return new TGrafoNoDirigido(VerticesSeleccionados, AristasAAM);
    }
    @Override
    public TGrafoNoDirigido Kruskal() {
        TGrafoNoDirigido AAM = new TGrafoNoDirigido(getVertices().values(),new TAristas());
        var aristasDesordenadas = lasAristas;
        aristasDesordenadas.sort((TArista a1, TArista a2) -> {
            if (a1.costo < a2.costo){
                return -1;
            } else if(a1.costo > a2.costo){
                return 1;
            } else{
                return 0;
            }
        });;
        TAristas aristasOrdenadas = new TAristas();
        aristasOrdenadas.addAll(aristasDesordenadas);
        int aristasAgregadas = 0;

        while (aristasAgregadas != getVertices().size() - 1){
            TArista aristaMin = aristasOrdenadas.removeFirst();
            TVertice verticeOrigen = AAM.getVertices().get(aristaMin.getEtiquetaOrigen());
            TVertice verticeDestino = AAM.getVertices().get(aristaMin.getEtiquetaDestino());
            if (!AAM.estanConectados(verticeOrigen.getEtiqueta(), verticeDestino.getEtiqueta())){
                AAM.insertarArista(aristaMin);
                AAM.getLasAristas().add(aristaMin);
                AAM.getLasAristas().add(aristaMin.aristaInversa());
                aristasAgregadas++;
            }
        }
        return AAM;
    }

    private boolean estanConectados(Comparable etiqueta, Comparable etiqueta1) {
        TVertice v = buscarVertice(etiqueta);
        if (v.buscarAdyacencia(etiqueta1) != null){
            return true;
        }
        return false;
    }


    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
