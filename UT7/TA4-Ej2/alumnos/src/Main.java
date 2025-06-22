import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        TGrafoDirigido grafo = UtilGrafos.cargarGrafo("src/aeropuertos2", "src/conexiones2", false, TGrafoDirigido.class);

        System.out.println("Recorrido bpf: ");
        System.out.println(grafo.bpf());

        TVertice montevideo = (TVertice) grafo.getVertices().get("Montevideo");
        System.out.println("\nRecorrido bpf(TVertice)");
        Collection<TVertice> resultado = grafo.bpf(montevideo);
        System.out.println("Visitados: " + resultado.toString());

        System.out.println("\nRecorrido bpf(Comparable)");
        Collection<TVertice> resultado2 = grafo.bpf("Atlantis");
        System.out.println("Visitados: " + resultado2.toString());
    }
}
