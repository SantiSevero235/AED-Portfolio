package uy.edu.ucu.aed.pd5;

public class TAbonado {
    private String nombre;
    private String telefono;

    public TAbonado(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return nombre + "," + telefono;
    }
}
