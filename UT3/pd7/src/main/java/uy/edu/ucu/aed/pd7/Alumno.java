package uy.edu.ucu.aed.pd7;

public class Alumno {
    private String ci;
    private String nombre;
    private  String apellido;

    public Alumno(String ci, String nombre, String apellido) {
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return ci.toString();
    }
}
