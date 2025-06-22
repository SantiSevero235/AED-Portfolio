public class Main {
    public static void main(String[] args) {
        TGrafoDirigido grafo = UtilGrafos.cargarGrafo("src/aeropuertos_2.txt", "src/conexiones_2.txt", false, TGrafoDirigido.class);

        TCaminos caminos = grafo.todosLosCaminos("Rio_de_Janeiro", "San_Pablo");
        System.out.println("Caminos desde Rio de Janeiro a San Pablo");
        for (TCamino camino : caminos.getCaminos()) {
            System.out.println("Camino: " + camino.imprimirEtiquetas());
            System.out.println("Costo total: " + camino.getCostoTotal()+ "\n");
        }
    }
}
