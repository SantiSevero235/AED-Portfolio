package uy.edu.ucu.aed;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for implemented methods.
 */
public class Parcial2Test_Junit5
{
    private SistemaTransporte sistemaTransporte;
    String instanceVariable;
    
    @BeforeEach
    public void setUp() {
        sistemaTransporte = new SistemaTransporte();
        sistemaTransporte.agregarRuta("A", "B", 10);
        sistemaTransporte.agregarRuta("B", "C", 20);
        sistemaTransporte.agregarRuta("A", "C", 25);
        sistemaTransporte.agregarRuta("B", "D", 30);
        instanceVariable = "Value before test";
    }

    @Test
    public void testConsultaTiempoMinimo_RutaExistente() {
        int tiempo = sistemaTransporte.consultaTiempoMinimo("A", "B");
        assertEquals(10, tiempo, "El tiempo mínimo entre A y C debería ser 25.");
    }

    @Test
    public void testConsultaTiempoMinimo_RutaConIntermedios() {
        int tiempo = sistemaTransporte.consultaTiempoMinimo("A", "D");
        assertEquals(40, tiempo, "El tiempo mínimo entre A y B debería ser 40.");
    }

    @Test
    public void testConsultaTiempoMinimo_SinRuta() {
        int tiempo = sistemaTransporte.consultaTiempoMinimo("C", "A");
        assertEquals(-1, tiempo, "Debería devolver -1 si no hay ruta entre C y A.");
    }

    @Test
    public void testConsultaTiempoMinimo_EstacionInexistente() {
        int tiempo = sistemaTransporte.consultaTiempoMinimo("A", "X");
        assertEquals(-1, tiempo, "Debería devolver -1 si una estación no existe.");
    }

    @Test
    public void testConsultaTiempoMinimo_MismaEstacion() {
        int tiempo = sistemaTransporte.consultaTiempoMinimo("A", "A");
        assertEquals(0, tiempo, "El tiempo mínimo entre la misma estación debería ser 0.");
    }

    

    @AfterEach
    public void tearDown() {
        // Release any resources or clean up after the tests
        instanceVariable = null;
    }

    /**
     * Sample test in JUnit 5
     */
    @Test
    public void shouldAnswerWithTrueInJUnit5Test()
    {
        assertTrue(instanceVariable != null);
    }
}