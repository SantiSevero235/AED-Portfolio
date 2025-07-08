package uy.edu.ucu.aed;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import uy.edu.ucu.aed.SistemaTransporte.RutaConectada;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido {
protected TAristas lasAristas = new TAristas() ;
       /**
     *
     * @param vertices
     * @param aristas
     */
    public TGrafoNoDirigido(Collection<IVertice> vertices, Collection<IArista> aristas) {
        super(vertices, aristas);
        lasAristas.insertarAmbosSentidos(aristas);
       
    }
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TGrafoNoDirigido Kruskal() {
        LinkedList<IArista> aristasKruskal = new LinkedList(); //Aqui se almacenaran las aristas seleccionadas.
        Map<Comparable, IVertice> vertices = getVertices();

        if (!vertices.isEmpty()) {
            desvisitarVertices();
            HashMap<Comparable, LinkedList<IVertice>> colecciones = new HashMap(vertices.size());
            LinkedList<IVertice> colTemp;

            //Creamos una "coleccion" para cada arista
            for (IVertice v : vertices.values()) {
                colTemp = new LinkedList();
                colTemp.add(v);
                colecciones.put(v.getEtiqueta(), colTemp);
            }

            //Ordenamos todas las aristas del grafo de menor costo a mayor
            LinkedList<IArista> aristasOrdenadas = new LinkedList();
            forAristas:
            for (IArista a : lasAristas) {
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

            //Conectamos las colecciones de vertices (no conectados) mediante la arista de menor costo posible
            IArista menorArista;
            LinkedList<IVertice> colOrigen, colDestino;
            while (!aristasOrdenadas.isEmpty()) {
                menorArista = aristasOrdenadas.pollFirst();
                colOrigen = colecciones.get(menorArista.getEtiquetaOrigen());
                colDestino = colecciones.get(menorArista.getEtiquetaDestino());
                if (colOrigen != colDestino) {
                    colOrigen.addAll(colDestino);
                    for (IVertice v : colDestino) {
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
    public Collection<IVertice> bea() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<IVertice> bea(Comparable etiquetaOrigen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<SistemaTransporte.RutaConectada> parcial(TGrafoNoDirigido gNoDirigido) {
        List<SistemaTransporte.RutaConectada> listaResult = new LinkedList<SistemaTransporte.RutaConectada>();
        for (IArista elem : gNoDirigido.lasAristas) {
            SistemaTransporte.RutaConectada ruta = new RutaConectada();
            ruta.destino = elem.getEtiquetaDestino().toString();
            ruta.origen = elem.getEtiquetaOrigen().toString();
            ruta.tiempo = (int) elem.getCosto();
            listaResult.add(ruta);
        }
        return listaResult;
    };
}
