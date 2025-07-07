package uy.edu.ucu.aed.TA;

public class Sucursal {
    private String nombre;

    public Sucursal(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
