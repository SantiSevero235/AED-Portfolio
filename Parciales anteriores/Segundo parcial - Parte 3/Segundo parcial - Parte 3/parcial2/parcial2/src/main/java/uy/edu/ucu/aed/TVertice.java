package uy.edu.ucu.aed;


import java.util.LinkedList;
import java.util.List;

public class TVertice implements IVertice
{

    private final Comparable etiqueta;
    private final LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private Object datos;


    @Override
    public Comparable getEtiqueta()
    {
        return etiqueta;
    }

    @Override
    public LinkedList<TAdyacencia> getAdyacentes()
    {
        return adyacentes;
    }

    public TVertice(Comparable unaEtiqueta)
    {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList();
        visitado = false;
    }

    @Override
    public void setVisitado(boolean valor)
    {
        this.visitado = valor;
    }

    @Override
    public boolean getVisitado()
    {
        return this.visitado;
    }

    @Override
    public TAdyacencia buscarAdyacencia(TVertice verticeDestino)
    {
        if (verticeDestino != null)
        {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }

    @Override
    public Double obtenerCostoAdyacencia(TVertice verticeDestino)
    {
        TAdyacencia ady = buscarAdyacencia(verticeDestino);
        if (ady != null)
        {
            return ady.getCosto();
        }
        return Double.MAX_VALUE;
    }

    @Override
    public boolean insertarAdyacencia(Double costo, TVertice verticeDestino)
    {
        if (buscarAdyacencia(verticeDestino) == null)
        {
            TAdyacencia ady = new TAdyacencia(costo, verticeDestino);
            return adyacentes.add(ady);
        }
        return false;
    }

    @Override
    public boolean eliminarAdyacencia(Comparable nomVerticeDestino)
    {
        TAdyacencia ady = buscarAdyacencia(nomVerticeDestino);
        if (ady != null)
        {
            adyacentes.remove(ady);
            return true;
        }
        return false;
    }

    @Override
    public TVertice primerAdyacente()
    {
        if (this.adyacentes.getFirst() != null)
        {
            return this.adyacentes.getFirst().getDestino();
        }
        return null;
    }

    @Override
    public TAdyacencia buscarAdyacencia(Comparable etiquetaDestino)
    {
        for (TAdyacencia adyacencia : adyacentes)
        {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0)
            {
                return adyacencia;
            }
        }
        return null;
    }

    @Override
    public Object getDatos()
    {
        return datos;
    }

    public void bpf(List<TVertice> lista)
    {
        this.visitado = true;
        lista.add(this);
        for (IAdyacencia ady : this.adyacentes) {
            TVertice destino = (TVertice) ady.getDestino();
            if (!destino.getVisitado()) {
                destino.bpf(lista);
            }
        }
    }
    
    public void bea(List<TVertice> lista)
    {
        setVisitado(true);
        LinkedList<TVertice> list = new LinkedList();
        list.add(this);
        lista.add(this);
        while (!list.isEmpty()) {
            TVertice primero = list.remove(0);
            LinkedList<TAdyacencia> ady = primero.getAdyacentes();
            for (TAdyacencia t : ady) {
                if (!t.getDestino().getVisitado()) {
                    t.getDestino().setVisitado(true);
                    list.add(t.getDestino());
                    lista.add( t.getDestino());
                }
            }
        }
    }

    
}
