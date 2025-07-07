package uy.edu.ucu.aed.tdas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
// import uy.edu.ucu.aed.tdas.Lista; // si después agregás lista

import static org.junit.jupiter.api.Assertions.*;

public class ConjuntoTest {

    private IConjunto<String, String> conjunto;

    @BeforeEach
    void setUp() {
        conjunto = new Conjunto<>();
    }

    // ========== TESTS DE CONJUNTO ==========

    @Test
    void testAgregarYMostrarConjunto() {
        conjunto.agregar("Manzana", "a");
        conjunto.agregar("Banana", "b");
        conjunto.agregar("Pera", "c");
        assertEquals(3, conjunto.tamanio());
    }

    @Test
    void testEvitaDuplicadosConjunto() {
        conjunto.agregar("Banana", "b");
        conjunto.agregar("Banana duplicada", "b");
        assertEquals(1, conjunto.tamanio());
    }

    @Test
    void testEliminarConjunto() {
        conjunto.agregar("Pera", "c");
        assertTrue(conjunto.eliminar("c"));
        assertEquals(0, conjunto.tamanio());
    }

    @Test
    void testEliminarInexistenteConjunto() {
        conjunto.agregar("Manzana", "a");
        assertFalse(conjunto.eliminar("z"));
        assertEquals(1, conjunto.tamanio());
    }

    @Test
    void testPerteneceConjunto() {
        conjunto.agregar("Kiwi", "k");
        assertTrue(conjunto.pertenece("k"));
        assertFalse(conjunto.pertenece("x"));
    }

    @Test
    void testTamanioInicialConjunto() {
        assertEquals(0, conjunto.tamanio());
    }

    @Test
void testUnionConjuntos() {
    IConjunto<String, String> a = new Conjunto<>();
    IConjunto<String, String> b = new Conjunto<>();

    a.agregar("Juan", "1");
    a.agregar("Lucía", "2");

    b.agregar("Lucía", "2");
    b.agregar("Martín", "3");

    IConjunto<String, String> union = a.union(b);

    assertEquals(3, union.tamanio());
    assertTrue(union.pertenece("1"));
    assertTrue(union.pertenece("2"));
    assertTrue(union.pertenece("3"));
}

@Test
void testInterseccionConjuntos() {
    IConjunto<String, String> a = new Conjunto<>();
    IConjunto<String, String> b = new Conjunto<>();

    a.agregar("Juan", "1");
    a.agregar("Lucía", "2");
    a.agregar("Martín", "3");

    b.agregar("Lucía", "2");
    b.agregar("Martín", "3");
    b.agregar("Pedro", "4");

    IConjunto<String, String> interseccion = a.interseccion(b);

    assertEquals(2, interseccion.tamanio());
    assertTrue(interseccion.pertenece("2")); // Lucía
    assertTrue(interseccion.pertenece("3")); // Martín
    assertFalse(interseccion.pertenece("1")); // Juan
    assertFalse(interseccion.pertenece("4")); // Pedro
}


}
