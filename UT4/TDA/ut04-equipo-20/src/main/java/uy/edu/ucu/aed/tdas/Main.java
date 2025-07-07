package uy.edu.ucu.aed.tdas;

public class Main {
    public static void main(String[] args) {
        TArbolBB<Integer> arbol = new TArbolBB<>();

        arbol.insertar(30, 30);
        arbol.insertar(20, 20);
        arbol.insertar(40, 40);
        arbol.insertar(10, 10);
        arbol.insertar(5, 5);
        arbol.insertar(25, 25);
        arbol.insertar(15, 15);
        arbol.insertar(12, 12);
        arbol.insertar(17, 17);


        System.out.println("InOrden inicial: " + arbol.inOrden());
        System.out.println("PostOrden inicial: " + arbol.postOrden());
        System.out.println("PreOrden inicial: " + arbol.preOrden());

        // Eliminar hoja
        arbol.eliminar(5);
        System.out.println("InOrden después de eliminar 5: " + arbol.inOrden());

        // Eliminar nodo con un hijo
        arbol.eliminar(10);
        System.out.println("InOrden después de eliminar 10: " + arbol.inOrden());

        // Eliminar nodo con dos hijos
        arbol.eliminar(30);
        System.out.println("InOrden después de eliminar 30: " + arbol.inOrden());

        System.out.println(arbol.buscar(15));
    }
}
