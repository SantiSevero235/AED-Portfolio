package uy.edu.ucu.aed;
import java.util.Collection;

public interface IGrafoNoDirigido {

    public Collection <IVertice> bea();
    public Collection <IVertice> bea(Comparable etiquetaOrigen);
    public TGrafoNoDirigido Prim();
    public TGrafoNoDirigido Kruskal();
}
