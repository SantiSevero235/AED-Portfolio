import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class TArbolTrieTest {

    private TArbolTrie trie;

    @BeforeEach
    void setUp() {
        trie = new TArbolTrie();
    }

    @Test
    void testInsertarYBuscarPalabraExistente() {
        trie.insertar("hola");
        assertTrue(trie.buscar("hola") > 0, "La palabra 'hola' debería existir en el trie.");
    }

    @Test
    void testBuscarPalabraInexistente() {
        trie.insertar("hola");
        assertEquals(0, trie.buscar("chau"), "La palabra 'chau' no debería estar en el trie.");
    }

    @Test
    void testPredecirPrefijo() {
        trie.insertar("perro");
        trie.insertar("persona");
        trie.insertar("pelota");
        trie.insertar("gato");

        LinkedList<String> predicciones = trie.predecir("pe");
        assertTrue(predicciones.contains("perro"));
        assertTrue(predicciones.contains("persona"));
        assertTrue(predicciones.contains("pelota"));
        assertFalse(predicciones.contains("gato"));
        assertEquals(3, predicciones.size());
    }

    @Test
    void testPredecirPrefijoInexistente() {
        trie.insertar("perro");
        LinkedList<String> predicciones = trie.predecir("za");
        assertTrue(predicciones.isEmpty(), "No debería haber predicciones para prefijo 'za'.");
    }

    @Test
    void testBuscarEnTrieVacio() {
        assertEquals(0, trie.buscar("algo"));
    }

    @Test
    void testPredecirEnTrieVacio() {
        LinkedList<String> predicciones = trie.predecir("a");
        assertTrue(predicciones.isEmpty(), "Trie vacío no debería devolver predicciones.");
    }
}
