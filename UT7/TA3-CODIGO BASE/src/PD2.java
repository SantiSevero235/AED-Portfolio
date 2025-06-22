import java.util.ArrayList;
import java.util.Collection;

public class PD2 {
    public static void main(String[] args) {
        Collection<TVertice> vertices = new ArrayList<>();
        Collection<TArista> aristas = new ArrayList<>();
        TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);

        TVertice artigas = new TVertice("Artigas");
        TVertice canelones = new TVertice("Canelones");
        TVertice durazno = new TVertice("Durazno");
        TVertice florida = new TVertice("Florida");
        TVertice montevideo = new TVertice("Montevideo");
        TVertice puntaDelEste = new TVertice("Punta Del Este");
        TVertice rocha = new TVertice("Rocha");

        grafo.insertarVertice(artigas);
        grafo.insertarVertice(canelones);
        grafo.insertarVertice(durazno);
        grafo.insertarVertice(florida);
        grafo.insertarVertice(montevideo);
        grafo.insertarVertice(puntaDelEste);
        grafo.insertarVertice(rocha);

        grafo.insertarArista(new TArista("Artigas", "Rocha", 400));
        grafo.insertarArista(new TArista("Canelones", "Artigas", 500));
        grafo.insertarArista(new TArista("Canelones", "Colonia", 200));
        grafo.insertarArista(new TArista("Canelones", "Durazno", 170));
        grafo.insertarArista(new TArista("Canelones", "Punta Del Este", 90));
        grafo.insertarArista(new TArista("Colonia", "Montevideo", 180));
        grafo.insertarArista(new TArista("Florida", "Durazno", 60));
        grafo.insertarArista(new TArista("Montevideo", "Artigas", 700));
        grafo.insertarArista(new TArista("Montevideo", "Canelones", 30));
        grafo.insertarArista(new TArista("Montevideo", "Punta Del Este", 130));
        grafo.insertarArista(new TArista("Punta Del Este", "Rocha", 90));
        grafo.insertarArista(new TArista("Rocha", "Montevideo", 270));
        grafo.insertarArista(new TArista("Florida", "Durazno", 60));

        Comparable[][] matriz = UtilGrafos.obtenerMatrizCostos(grafo.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, grafo.getVertices(), "Matriz");

        Double[][] floyd = grafo.floyd();
        UtilGrafos.imprimirMatrizMejorado(floyd, grafo.getVertices(), "Matriz con Floyd");

        System.out.println("La excentricidad de Artigas es: " + grafo.obtenerExcentricidad("Artigas"));
        System.out.println("La excentricidad de Canelones es: " + grafo.obtenerExcentricidad("Canelones"));
        System.out.println("La excentricidad de Durazno es: " + grafo.obtenerExcentricidad("Durazno"));
        System.out.println("La excentricidad de Florida es: " + grafo.obtenerExcentricidad("Florida"));
        System.out.println("La excentricidad de Montevideo es: " + grafo.obtenerExcentricidad("Montevideo"));
        System.out.println("La excentricidad de Punta Del Este es: " + grafo.obtenerExcentricidad("Punta Del Este"));
        System.out.println("La excentricidad de Rocha es: " + grafo.obtenerExcentricidad("Rocha"));

        System.out.println("\nEl centro del grafo es: " + grafo.centroDelGrafo());
    }
}
