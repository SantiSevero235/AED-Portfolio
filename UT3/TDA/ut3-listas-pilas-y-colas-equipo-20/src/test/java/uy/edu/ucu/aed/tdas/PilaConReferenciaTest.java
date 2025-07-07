package uy.edu.ucu.aed.tdas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class PilaConReferenciaTest {

    private PilaConReferencia<String> pilaStr;

    @BeforeEach
    void setUp() {
        pilaStr = new PilaConReferencia<>();
    }

    @Test
    public void testPilaVacia(){
        assertTrue(pilaStr.esVacia());
    }

    @Test
    public void testApilarDesapilaryTope(){
        pilaStr.apilar("The Beatles");
        pilaStr.apilar("Queen");
        pilaStr.apilar("Pink Floyd");
        assertEquals("Pink Floyd", pilaStr.tope());
        pilaStr.desapilar();
        assertNotEquals("Pink Floyd", pilaStr.tope());
        assertEquals("Queen", pilaStr.tope());
    }

    @Test
    public void testApilarVacioLanzaExcepcion(){
        assertThrows(IllegalArgumentException.class, () -> {pilaStr.apilar(null);});
    }

    @Test
    public void testTopeConListaVaciaNull(){
        assertEquals(null, pilaStr.tope());
    }

    @Test
    public void testAnulaEliminaLaLista(){
        pilaStr.apilar("Juego de Tronos Tomo 1");
        pilaStr.apilar("Juego de Tronos Tomo 2");
        pilaStr.apilar("Juego de Tronos Tomo 3");
        pilaStr.apilar("Juego de Tronos Tomo 4");
        assertEquals("Juego de Tronos Tomo 4", pilaStr.tope());
        pilaStr.anular();
        assertNull(pilaStr.tope());
    }

    @Test
    public void testDesapilarPilaVaciaLanzaExcepcion(){
        assertThrows(IllegalStateException.class, () -> {pilaStr.desapilar();});
    }

    @Test
    public void testPilaesVacia(){
        assertTrue(pilaStr.esVacia());
        pilaStr.apilar("Plato");
        assertFalse(pilaStr.esVacia());
        pilaStr.desapilar();
        assertTrue(pilaStr.esVacia());
    }

}
