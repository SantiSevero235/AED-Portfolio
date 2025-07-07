package uy.edu.ucu.aed.tdas;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class TGrafoNoDirigidoTest {

    private TGrafoNoDirigido crearGrafoBasico() {
        Collection<IArista> aristas = new LinkedList<>();
        Collection<IVertice> vertices = new LinkedList<>();
        TGrafoNoDirigido gd = new TGrafoNoDirigido(vertices, aristas);

        gd.insertarVertice("1");
        gd.insertarVertice("2");
        gd.insertarVertice("3");
        gd.insertarVertice("4");
        gd.insertarVertice("5");
        gd.insertarVertice("6");

        gd.insertarArista(new TArista("1", "2", 0));
        gd.insertarArista(new TArista("1", "3", 0));
        gd.insertarArista(new TArista("3", "4", 0));
        gd.insertarArista(new TArista("4", "5", 0));
        gd.insertarArista(new TArista("4", "6", 0));


        return gd;
    }

    @Test
    public void testPuntosDeArticulacion() {
        TGrafoNoDirigido gd = crearGrafoBasico();
        LinkedList<IVertice> puntos = gd.puntosArticulacion();

        LinkedList<String> expected = new LinkedList<>();
        expected.add("4");
        expected.add("3");
        expected.add("1");

        for (IVertice v : puntos) {
            assertTrue(expected.contains(v.getEtiqueta()));
        }
    }

@Test
public void testPuntosDeArticulacionSinPuntos() {
    Collection<IArista> aristas = new LinkedList<>();
    Collection<IVertice> vertices = new LinkedList<>();
    TGrafoNoDirigido gd = new TGrafoNoDirigido(vertices, aristas);

    // Crear grafo circular: 1 - 2 - 3 - 4 - 1
    gd.insertarVertice("1");
    gd.insertarVertice("2");
    gd.insertarVertice("3");
    gd.insertarVertice("4");

    gd.insertarArista(new TArista("1", "2", 1));
    gd.insertarArista(new TArista("2", "3", 1));
    gd.insertarArista(new TArista("3", "4", 1));
    gd.insertarArista(new TArista("4", "1", 1));

    LinkedList<IVertice> puntos = gd.puntosArticulacion();
    assertEquals(0, puntos.size());
}


    @Test
    public void testPuntosConGrafoVacio() {
        TGrafoNoDirigido gd = new TGrafoNoDirigido(new LinkedList<>(), new LinkedList<>());
        LinkedList<IVertice> puntos = gd.puntosArticulacion();
        assertEquals(0, puntos.size());
    }

    @Test
    public void testUnSoloVertice() {
        TGrafoNoDirigido gd = new TGrafoNoDirigido(new LinkedList<>(), new LinkedList<>());
        gd.insertarVertice("1");
        LinkedList<IVertice> puntos = gd.puntosArticulacion();
        assertEquals(0, puntos.size());
    }

    @Test
    public void testDosVertices() {
        TGrafoNoDirigido gd = new TGrafoNoDirigido(new LinkedList<>(), new LinkedList<>());
        gd.insertarVertice("1");
        gd.insertarVertice("2");
        gd.insertarArista(new TArista("1", "2", 0));
        LinkedList<IVertice> puntos = gd.puntosArticulacion();
        assertEquals(0, puntos.size());
    }

    @Test
    public void testTresVertices() {
        TGrafoNoDirigido gd = new TGrafoNoDirigido(new LinkedList<>(), new LinkedList<>());
        gd.insertarVertice("1");
        gd.insertarVertice("2");
        gd.insertarVertice("3");
        gd.insertarArista(new TArista("1", "2", 0));
        gd.insertarArista(new TArista("2", "3", 0));

        LinkedList<IVertice> puntos = gd.puntosArticulacion();
        assertEquals(1, puntos.size());
        assertEquals("2", puntos.get(0).getEtiqueta());
    }

@Test
public void testKruskal() {
    Collection<IArista> aristas = new LinkedList<>();
    Collection<IVertice> vertices = new LinkedList<>();
    TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);

    grafo.insertarVertice("1");
    grafo.insertarVertice("2");
    grafo.insertarVertice("3");
    grafo.insertarVertice("4");
    grafo.insertarVertice("5");
    grafo.insertarVertice("6");

    grafo.insertarArista(new TArista("1", "2", 3));
    grafo.insertarArista(new TArista("1", "3", 2));
    grafo.insertarArista(new TArista("2", "4", 1));
    grafo.insertarArista(new TArista("2", "6", 1));
    grafo.insertarArista(new TArista("3", "4", 4));
    grafo.insertarArista(new TArista("4", "5", 3));
    grafo.insertarArista(new TArista("4", "6", 5));

    TGrafoNoDirigido grafoKruskal = grafo.Kruskal();

    // Valida existencia de las aristas esperadas
    assertTrue(grafoKruskal.existeArista("1", "3"));
    assertTrue(grafoKruskal.existeArista("1", "2"));
    assertTrue(grafoKruskal.existeArista("2", "4"));
    assertTrue(grafoKruskal.existeArista("2", "6"));
    assertTrue(grafoKruskal.existeArista("4", "5"));

    // Valida que no estén aristas que no deberían
    assertFalse(grafoKruskal.existeArista("4", "6"));
    assertFalse(grafoKruskal.existeArista("3", "4"));

    assertEquals(5, grafoKruskal.getLasAristas().size()); // Verifica que haya 5 aristas únicas en el Arbol exapnsor minimo (una por conexión, sin duplicar ida y vuelta)
    
}




    @Test
    public void testPrim() {
        Collection<IArista> aristas = new LinkedList<>();
        Collection<IVertice> vertices = new LinkedList<>();
        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);

        grafo.insertarVertice("1");
        grafo.insertarVertice("2");
        grafo.insertarVertice("3");
        grafo.insertarVertice("4");
        grafo.insertarVertice("5");
        grafo.insertarVertice("6");

        grafo.insertarArista(new TArista("1", "2", 3));
        grafo.insertarArista(new TArista("1", "3", 2));
        grafo.insertarArista(new TArista("2", "4", 1));
        grafo.insertarArista(new TArista("2", "6", 1));
        grafo.insertarArista(new TArista("3", "4", 4));
        grafo.insertarArista(new TArista("4", "5", 3));
        grafo.insertarArista(new TArista("4", "6", 5));

        TGrafoNoDirigido grafoPrim = grafo.Prim();

        // Si imprimís solo una dirección por arista
        String esperado = "1 - 3 - 2.0\n" +
                        "1 - 2 - 3.0\n" +
                        "2 - 4 - 1.0\n" +
                        "2 - 6 - 1.0\n" +
                        "4 - 5 - 3.0\n";

        assertEquals(esperado, grafoPrim.getLasAristas().imprimirEtiquetas());

        // Validaciones adicionales
        assertTrue(grafoPrim.existeArista("1", "2"));
        assertTrue(grafoPrim.existeArista("1", "3"));
        assertTrue(grafoPrim.existeArista("2", "4"));
        assertTrue(grafoPrim.existeArista("2", "6"));
        assertFalse(grafoPrim.existeArista("3", "4"));
        assertTrue(grafoPrim.existeArista("4", "5"));
        assertFalse(grafoPrim.existeArista("4", "6"));
        System.out.println("Aristas en grafoPrim:");
        System.out.println(grafoPrim.getLasAristas().imprimirEtiquetas());
        System.out.println("Tiene ciclo? " + grafoPrim.tieneCiclo());

        assertFalse(grafoPrim.tieneCiclo());
    }


        @Test
    public void testBEADesdeUnVertice() {
        // Crear vértices
        TVertice a = new TVertice<>("A");
        TVertice b = new TVertice<>("B");
        TVertice c = new TVertice<>("C");
        TVertice d = new TVertice<>("D");

        // Crear aristas (grafo no dirigido)
        TArista ab = new TArista("A", "B", 1);
        TArista bc = new TArista("B", "C", 1);
        TArista cd = new TArista("C", "D", 1);

        Collection<IVertice> vertices = Arrays.asList(a, b, c, d);
        Collection<IArista> aristas = Arrays.asList(ab, bc, cd);

        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);

        Collection<TVertice> visitados = grafo.bea("A");

        assertEquals(4, visitados.size());
    }
}
