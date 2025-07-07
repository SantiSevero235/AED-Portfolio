package uy.edu.ucu.aed.TA;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectorioSucursalesTest {

    @Test
    void agregarSucursal() {
        DirectorioSucursales directorio = new DirectorioSucursales();
        assertEquals(0, directorio.cantidadSucursales());

        directorio.agregarSucursal("Toronto");

        assertEquals(1, directorio.cantidadSucursales());
        assertTrue(directorio.buscarSucursal("Toronto"));
    }

    @Test
    void quitarSucursal() {
        DirectorioSucursales directorio = new DirectorioSucursales();
        directorio.agregarSucursal("Buenos Aires");
        assertTrue(directorio.buscarSucursal("Buenos Aires"));

        directorio.quitarSucursal("Buenos Aires");

        assertFalse(directorio.buscarSucursal("Buenos Aires"));
        assertEquals(0, directorio.cantidadSucursales());
    }

    @Test
    void buscarSucursal() {
        DirectorioSucursales directorio = new DirectorioSucursales();
        directorio.agregarSucursal("Tokio");

        assertTrue(directorio.buscarSucursal("Tokio"));
        assertFalse(directorio.buscarSucursal("Londres"));
    }

    @Test
    void cantidadSucursales() {
        DirectorioSucursales directorio = new DirectorioSucursales();
        assertEquals(0, directorio.cantidadSucursales());

        directorio.agregarSucursal("Paris");
        directorio.agregarSucursal("Roma");

        assertEquals(2, directorio.cantidadSucursales());
    }

    @Test
    void esVacia() {
        DirectorioSucursales directorio = new DirectorioSucursales();
        assertTrue(directorio.esVacia());

        directorio.agregarSucursal("Madrid");
        assertFalse(directorio.esVacia());
    }
}
