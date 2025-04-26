package com.ut3_pd7;

public interface IConjunto<T> extends ILista<T> {
    public Nodo<T> obtenerPrimerNodo();
    public IConjunto<T> union(IConjunto<T> otroConjunto);
    public IConjunto<T> interseccion(IConjunto<T> otroConjunto);
    }
    