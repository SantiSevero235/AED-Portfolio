package uy.edu.ucu.aed.tdas;

public interface IPila<T> {

    //Agrega un elemento a la pila
    public void apilar(T dato);

    //Elimina el ultimo en entrar
    public void desapilar();
    
    //Nos devuelve el tope de la pila, osea el objeto que va ser eliminado si usamos el metodo desapilar
    public T tope();

    //Elimina todos los objetos de la pila
    public void anular();

    //Nos desvuelve si la lsita esta vacia o no
    public boolean esVacia();

}
