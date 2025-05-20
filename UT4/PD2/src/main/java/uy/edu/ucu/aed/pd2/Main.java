package uy.edu.ucu.aed.pd2;

public class Main {
    public static void main(String[] args) {
        TArbolBB<String> arbol = new TArbolBB<>();
        String[] claves = ManejadorArchivosGenerico.leerArchivo("src/clavesPrueba.txt");

        for (String clave : claves) {
            Integer claveNumerica = Integer.parseInt(clave);
            arbol.insertar(new TElementoAB<>(claveNumerica, clave));
        }

        String preorden = arbol.preOrden();
        String inorden = arbol.inOrden();
        String postorden = arbol.postOrden();

        String[] preordenArray = preorden.trim().split(" ");
        String[] inordenArray = inorden.trim().split(" ");
        String[] postordenArray = postorden.trim().split(" ");

        ManejadorArchivosGenerico.escribirArchivo("src/preOrden.txt", preordenArray);
        ManejadorArchivosGenerico.escribirArchivo("src/inOrden.txt", inordenArray);
        ManejadorArchivosGenerico.escribirArchivo("src/postOrden.txt", postordenArray);
    }
}
