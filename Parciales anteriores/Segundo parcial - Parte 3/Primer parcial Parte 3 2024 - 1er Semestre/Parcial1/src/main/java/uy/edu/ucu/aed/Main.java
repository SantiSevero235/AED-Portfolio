package uy.edu.ucu.aed;

public class Main {
    public static void main(String[] args) {
        // Crear árbol de productos
        TArbolDeProductos arbol = new TArbolDeProductos();

        // Leer archivo de entrada
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/productos.txt");
        for (String linea : lineas) {
            String[] partes = linea.split(",");
            int id = Integer.parseInt(partes[0]);
            String nombre = partes[1];
            Producto prod = new Producto(id, nombre);
            arbol.insertar(id, prod);
        }

        // Invocar métodos requeridos
        int lti = arbol.longitudTrayectoriaInterna();
        double ltim = arbol.longitudTrayectoriaInternaMedia();
        int altura = arbol.obtenerAltura();

        // Mostrar en consola
        System.out.println("LTI: " + lti);
        System.out.println("Altura: " + altura);
        System.out.println("LTIM: " + ltim);

        // Escribir en salida.txt (una línea por dato)
        String[] salida = new String[3];
        salida[0] = String.valueOf(lti);
        salida[1] = String.valueOf(altura);
        salida[2] = String.valueOf(ltim);
        ManejadorArchivosGenerico.escribirArchivo("src/salida.txt", salida);
    }
}
