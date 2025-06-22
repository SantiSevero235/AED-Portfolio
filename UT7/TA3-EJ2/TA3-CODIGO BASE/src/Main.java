public class Main {
    public static void main(String[] args) {
        TGrafoDirigido grafo = UtilGrafos.cargarGrafo("src/aeropuertos.txt", "src/conexiones.txt", false, TGrafoDirigido.class);

        boolean[][] matrizWarshall = grafo.warshall();

        Comparable[][] matrizConvertible = convertirBooleanAMatrizComparable(matrizWarshall);

        UtilGrafos.imprimirMatrizMejorado(matrizConvertible, grafo.getVertices(), "Matriz Warshall");
    }

    public static Comparable[][] convertirBooleanAMatrizComparable(boolean[][] matriz) {
        Comparable[][] resultado = new Comparable[matriz.length][matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                resultado[i][j] = matriz[i][j] ? 1.0 : Double.MAX_VALUE;
            }
        }
        return resultado;
    }

}
