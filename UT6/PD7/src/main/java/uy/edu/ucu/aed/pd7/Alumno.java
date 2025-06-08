package uy.edu.ucu.aed.pd7;

public class Alumno {
    private int id;
    private String nombreCompleto;
    private String email;

    public Alumno(int id, String nombreCompleto, String email) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true; // Son el mismo objeto
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Diferente tipo de objeto o nulo
        }

        Alumno alumno = (Alumno) obj;

        return id == alumno.id &&
                (nombreCompleto != null ? nombreCompleto.equals(alumno.nombreCompleto) : alumno.nombreCompleto == null) &&
                (email != null ? email.equals(alumno.email) : alumno.email == null);
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(id);
        result = 31 * result + (nombreCompleto != null ? nombreCompleto.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
