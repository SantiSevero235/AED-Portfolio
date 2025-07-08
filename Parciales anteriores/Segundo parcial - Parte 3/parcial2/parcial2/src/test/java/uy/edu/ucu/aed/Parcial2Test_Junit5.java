package uy.edu.ucu.aed;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class Parcial2Test_Junit5 {

    TGrafoRedDatos grafoRed;
    TMedidor medidor;

    @BeforeEach
    public void setUp() {
        // Set up grafo
        Collection<TVertice> vertices = new LinkedList<>();
        Collection<TArista> aristas = new LinkedList<>();
        grafoRed = new TGrafoRedDatos(vertices, aristas);

        grafoRed.insertarVertice(new TVertice("a"));
        grafoRed.insertarVertice(new TVertice("b"));
        grafoRed.insertarVertice(new TVertice("c"));
        grafoRed.insertarVertice(new TVertice("d"));
        grafoRed.insertarVertice(new TVertice("x")); // aislado

        grafoRed.insertarArista(new TArista("a", "b", 1));
        grafoRed.insertarArista(new TArista("b", "c", 1));
        grafoRed.insertarArista(new TArista("c", "d", 1));

        // Set up medidor
        medidor = new TMedidor();
    }

    @AfterEach
    public void tearDown() {
        grafoRed = null;
        medidor = null;
    }

    // --------------------------
    // Tests de conectividad
    // --------------------------
    @Test
    public void testVerticesConectados() {
        assertTrue(grafoRed.conectados("a", "d"));
    }

    @Test
    public void testVerticesNoConectados() {
        assertFalse(grafoRed.conectados("a", "x"));
    }

    @Test
    public void testMedicionValoresPositivos() {
        TDato d1 = new TDato(10.0, 20240101);
        TDato d2 = new TDato(25.5, 20240705);
        TDato d3 = new TDato(7.8, 20240312);
        TDato[] datos = { d1, d2, d3 };

        TDato resultado = medidor.obtenerMayorMedicion(datos);
        assertNotNull(resultado);
        assertEquals(25.5, resultado.getValor(), 0.001);
        assertEquals(20240705, resultado.getFecha());
    }

}
