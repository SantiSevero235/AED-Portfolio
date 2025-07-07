package uy.edu.ucu.aed.tdas;

import java.util.Collection;
import java.util.LinkedList;

import uy.edu.ucu.aed.tas.IVerticeKevinBacon;

public class TVertice<T> implements IVertice , IVerticeKevinBacon {

    private final Comparable etiqueta;
    private LinkedList<IAdyacencia> adyacentes;
    private boolean visitado;
    private T datos;

    private int bacon = 0; // Para número de Bacon
    private int numBp = 0; // Para puntos de articulación
    private int numBajo = 0;

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public LinkedList<IAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public TVertice(Comparable unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList<>();
        visitado = false;
    }

    public void setVisitado(boolean valor) {
        this.visitado = valor;
    }

    public boolean getVisitado() {
        return this.visitado;
    }

    public void bpf(Collection<TVertice> visitado1) {
        this.visitado = true;
        visitado1.add(this);
        for (IAdyacencia ady : this.adyacentes) {
            TVertice destino = (TVertice) ady.getDestino();
            if (!destino.getVisitado()) {
                destino.bpf(visitado1);
            }
        }
    }

    @Override
    public IAdyacencia buscarAdyacencia(IVertice verticeDestino) {
        if (verticeDestino != null) {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }

    @Override
    public Double obtenerCostoAdyacencia(IVertice verticeDestino) {
        IAdyacencia ady = buscarAdyacencia(verticeDestino);
        if (ady != null) {
            return ady.getCosto();
        }
        return Double.MAX_VALUE;
    }

    @Override
    public boolean insertarAdyacencia(Double costo, IVertice verticeDestino) {
        if (buscarAdyacencia(verticeDestino) == null) {
            TAdyacencia ady = new TAdyacencia(costo, verticeDestino);
            return adyacentes.add(ady);
        }
        return false;
    }

    @Override
    public boolean eliminarAdyacencia(Comparable nomVerticeDestino) {
        IAdyacencia ady = buscarAdyacencia(nomVerticeDestino);
        if (ady != null) {
            adyacentes.remove(ady);
            return true;
        }
        return false;
    }

    @Override
    public IVertice primerAdyacente() {
        if (this.adyacentes.getFirst() != null) {
            return this.adyacentes.getFirst().getDestino();
        }
        return null;
    }

    public IVertice siguienteAdyacente(IVertice w) {
        IAdyacencia adyacente = buscarAdyacencia(w.getEtiqueta());
        int index = adyacentes.indexOf(adyacente);
        if (index + 1 < adyacentes.size()) {
            return adyacentes.get(index + 1).getDestino();
        }
        return null;
    }

    @Override
    public IAdyacencia buscarAdyacencia(Comparable etiquetaDestino) {
        for (IAdyacencia adyacencia : adyacentes) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
        }
        return null;
    }

    public T getDatos() {
        return datos;
    }

    @Override
    public String toString() {
        return this.etiqueta.toString();
    }

    @Override
    public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
        this.setVisitado(true);
        for (IAdyacencia adyacencia : this.getAdyacentes()) {
            IVertice destino = (TVertice) adyacencia.getDestino();
            if (!destino.getVisitado()) {
                if (destino.getEtiqueta().compareTo(etVertDest) == 0) {
                    TCamino copia = caminoPrevio.copiar();
                    copia.agregarAdyacencia((TAdyacencia) adyacencia);
                    todosLosCaminos.getCaminos().add(copia);
                } else {
                    caminoPrevio.agregarAdyacencia((TAdyacencia) adyacencia);
                    destino.todosLosCaminos(etVertDest, caminoPrevio, todosLosCaminos);
                    caminoPrevio.eliminarAdyacencia((TAdyacencia) adyacencia);
                }
            }
        }
        this.setVisitado(false);
        return todosLosCaminos;
    }

    @Override
    public boolean tieneCiclo(TCamino unCamino) {
        this.setVisitado(true);
        unCamino.getOtrosVertices().add(this.getEtiqueta());

        for (IAdyacencia adyacencia : adyacentes) {
            TVertice destino = (TVertice) adyacencia.getDestino();
            Comparable etiquetaDestino = destino.getEtiqueta();

            if (unCamino.getOtrosVertices().contains(etiquetaDestino)) {
                return true;
            }

            if (!destino.getVisitado()) {
                unCamino.agregarAdyacencia((TAdyacencia) adyacencia);
                boolean ciclo = destino.tieneCiclo(unCamino);
                unCamino.eliminarAdyacencia((TAdyacencia) adyacencia);
                if (ciclo) return true;
            }
        }

        unCamino.getOtrosVertices().remove(this.getEtiqueta());
        this.setVisitado(false);
        return false;
    }

    public boolean tieneCicloNoDirigido(TCamino camino, TVertice padre) {
        this.setVisitado(true);
        camino.getOtrosVertices().add(this.getEtiqueta());

        for (IAdyacencia ady : this.adyacentes) {
            TVertice vecino = (TVertice) ady.getDestino();

            if (!vecino.getVisitado()) {
                if (vecino.tieneCicloNoDirigido(camino, this)) {
                    return true;
                }
            } else if (!vecino.equals(padre)) {
                return true;
            }
        }

        camino.getOtrosVertices().remove(this.getEtiqueta());
        return false;
    }


    @Override
    public void bea(Collection<TVertice> visitados) {
        setVisitado(true);
        LinkedList<TVertice> lista = new LinkedList();
        lista.add(this);
        visitados.add(this);
        while (!lista.isEmpty()) {
            TVertice primero = lista.remove(0);
            LinkedList<TAdyacencia> ady = primero.getAdyacentes();
            for (TAdyacencia t : ady) {
                if (!t.getDestino().getVisitado()) {
                    t.getDestino().setVisitado(true);
                    lista.add((TVertice) t.getDestino());
                    visitados.add((TVertice) t.getDestino());
                }
            }
        }
    }


    public int getBacon() {
        return bacon;
    }

    public void setBacon(int bacon) {
        this.bacon = bacon;
    }

    public int getNumBajo() {
        return numBajo;
    }

    public int getNumBp() {
        return numBp;
    }

    public void puntosArticulacion(LinkedList<IVertice> puntos, int prof) {
        this.setVisitado(true);
        prof++;
        this.numBp = prof;
        this.numBajo = prof;

        LinkedList<TVertice> hijos = new LinkedList<>();
        for (IAdyacencia ady : this.getAdyacentes()) {
            TVertice adyacente = (TVertice) ady.getDestino();
            if (!adyacente.getVisitado()) {
                adyacente.puntosArticulacion(puntos, prof);
                hijos.add(adyacente);
                this.numBajo = Math.min(this.numBajo, adyacente.getNumBajo());
            } else {
                this.numBajo = Math.min(this.numBajo, adyacente.getNumBp());
            }
        }

        if (this.numBp > 1) {
            for (TVertice hijo : hijos) {
                if (hijo.getNumBajo() >= this.numBp) {
                    puntos.add(this);
                    break;
                }
            }
        } else {
            if (hijos.size() > 1) {
                puntos.add(this);
            }
        }
    }

    public void ordenParcial(LinkedList<TVertice> orden) {
        this.setVisitado(true);
        for (IAdyacencia adyacencia : this.adyacentes) {
            TVertice adyacente = (TVertice) adyacencia.getDestino();
            if (!adyacente.getVisitado()) {
                adyacente.ordenParcial(orden);
            }
        }
        orden.addFirst(this);
    }

}
