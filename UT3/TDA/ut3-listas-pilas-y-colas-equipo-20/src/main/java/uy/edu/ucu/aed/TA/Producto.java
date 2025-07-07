package uy.edu.ucu.aed.TA;

public class Producto implements IProducto {

    private final Comparable etiqueta; // Código identificador
    private String nombre;
    private Integer precio;
    private Integer stock;

    public Producto(Comparable etiqueta, String nombre, Integer precio, Integer stock) {
        this.etiqueta = etiqueta;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public Integer getPrecio() {
        return precio;
    }

    @Override
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    @Override
    public Integer getStock() {
        return stock;
    }

    @Override
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre + " (Código: " + etiqueta + ", Precio: $" + precio + ", Stock: " + stock + ")";
    }
}
