package uy.edu.ucu.aed.tdas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

class PilaConArregloTest {

    private PilaConArreglo<Integer> pila;

    @BeforeEach
    void setUp() {
        pila = new PilaConArreglo<>(10);
    }


    @Test
    public void testPilaVaciaAlInicio() {
        IPila<Integer> pila = new PilaConArreglo<>(10);
        assertTrue(pila.esVacia());
    }

    @Test
    public void testapilarYtope() {
        IPila<String> pila = new PilaConArreglo<>(10);
        pila.apilar("Hola");
        pila.apilar("Mundo");
        assertEquals("Mundo", pila.tope());
    }

    @Test
    public void testdesapilar() {
        IPila<Integer> pila = new PilaConArreglo<>(10);
        pila.apilar(10);
        pila.apilar(20);
        pila.desapilar(); // Quita 20
        assertEquals(10, pila.tope());
    }

    @Test
    public void testanular() {
        IPila<Integer> pila = new PilaConArreglo<>(10);
        pila.apilar(1);
        pila.apilar(2);
        pila.anular();
        assertTrue(pila.esVacia());
        assertThrows(IllegalStateException.class, () -> pila.tope());
    }

    @Test
    public void testtopeEnPilaVaciaLanzaExcepcion() {
        IPila<Double> pila = new PilaConArreglo<>(0);
        assertThrows(IllegalStateException.class, () -> pila.tope());
    }

    @Test
    public void testdesapilarEnPilaVaciaLanzaExcepcion() {
        IPila<Double> pila = new PilaConArreglo<>(0);
        assertThrows(IllegalStateException.class, () -> pila.tope());
    }

    @Test
    public void testCrecimientoDinamico() {
        IPila<Integer> pila = new PilaConArreglo<>(2); // Tamaño inicial chico
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(3); // Esto debería forzar el crecimiento

        assertEquals(3, pila.tope());
        pila.desapilar();
        assertEquals(2, pila.tope());
    }
}
