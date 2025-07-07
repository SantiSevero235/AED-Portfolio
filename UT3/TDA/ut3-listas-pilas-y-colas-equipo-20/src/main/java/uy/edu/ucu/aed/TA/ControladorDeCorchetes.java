package uy.edu.ucu.aed.TA;

import uy.edu.ucu.aed.tdas.ILista;
import uy.edu.ucu.aed.tdas.Lista;
import uy.edu.ucu.aed.tdas.PilaConReferencia;

public class ControladorDeCorchetes {
    
    public static boolean validacionDeSecuencia(ILista<Character> listaDeEntrada){

        PilaConReferencia<Character> laPila = new PilaConReferencia<>();

        //Agrego este if ya que si leo un .txt o un archivo null tendria que poder detectar que hubo un fallo
        if (listaDeEntrada == null) {
            throw new IllegalArgumentException("La lista de entrada no puede ser null.");
        }

        if (listaDeEntrada.esVacia()){
            System.err.println("Error: Expresion vacia");
            return false;
        }

        // Este cast a Lista es necesario porque ILista no expone una forma de recorrer los nodos, 
        // por lo que accedemos a getPrimero(), desde la implementación concreta para recorrer la lista nodo a nodo.
        Nodo<Character> nodoAux = ((Lista<Character>) listaDeEntrada).getPrimero();
        if (nodoAux.getSiguiente() == null){
            return false;
        }

        //Con nodoAux.Siguiente no llegamos a recorrer el ultimo nodo de la lista, por ello utilizamos nodoAux.
        while (nodoAux != null){
            if (nodoAux.getDato() == '{'){
                laPila.apilar(nodoAux.getDato());
            }else if (nodoAux.getDato() == '}'){
                    if (laPila.esVacia()){
                        return false;
                }
                laPila.desapilar();
            }
            nodoAux = nodoAux.getSiguiente();
        }

        return laPila.esVacia();
    }
}
