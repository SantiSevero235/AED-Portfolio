public class Almacen implements IAlmacen {

    private String nombre;
    private String direccion;
    private String telefono;

    private TArbolBB<Producto> productos;

    public Almacen(String nombre) {
        this.nombre = nombre;
        this.productos = new TArbolBB<Producto>();
    }

    @Override
    public void insertarProducto(Producto unProducto) {
        TElementoAB elemento = new TElementoAB<>(unProducto.getEtiqueta(),unProducto);
        productos.insertar(elemento);
    }

  

    @Override
    public String imprimirProductos() {
        return (productos.imprimir());
    }

    @Override
    public Boolean agregarStock(Comparable clave, Integer cantidad) {
        TElementoAB e = productos.buscar(clave);
        if (e != null) {
            Producto p = (Producto) e.getDatos();
            p.agergarStock(cantidad);
            return true;
        }
        return false;
    }

    @Override
    public Integer restarStock(Comparable clave, Integer cantidad) {
        TElementoAB e = productos.buscar(clave);
        if (e != null){
            Producto p = (Producto) e.getDatos();
            return p.restarStock(cantidad);
        }
        return 0;
    }

    @Override
    public Producto buscarPorCodigo(Comparable clave) {
        TElementoAB e = productos.buscar(clave);
        if (e != null){
            return  (Producto) e.getDatos();
        }
        return null;
    }

    @Override
    public boolean eliminarProducto(Comparable clave) {
        if (productos.buscar(clave) != null){
            productos.eliminar(clave);
            return true;
        }
        return false;
    }
    public String actualizarStock(String archivo){
        String resumenProductos = "";
        String[] contenido = ManejadorArchivosGenerico.leerArchivo(archivo);
        for (String lineas: contenido) {
            String[] elementos = lineas.split(",");
            if (elementos.length == 4){
                String codigo = elementos[0];
                String nombre = elementos[1];
                int precioUnitario = Integer.parseInt(elementos[2]);
                int cantidad = Integer.parseInt(elementos[3]);
                if (productos.buscar(codigo) != null){
                    Producto p = (Producto) productos.buscar(codigo).getDatos();
                    agregarStock(codigo,cantidad);
                    resumenProductos += "Producto: " + nombre + " - Codigo: " + codigo + " - Stock: 1- Dinero gastado en la adquisición: " + cantidad * precioUnitario + "\n";
                }else {
                    Producto p = new Producto(codigo,nombre);
                    p.setStock(cantidad);
                    p.setPrecio(precioUnitario);
                    insertarProducto(p);
                    resumenProductos += "Producto: " + nombre + " - Codigo: " + codigo + " - Stock: " + cantidad + " - Dinero gastado en la adquisición: " + cantidad * precioUnitario + "\n";
                }
            } else {
                resumenProductos += "Producto con formato incorrecto: " + elementos[0];
            }
        }
        return resumenProductos;
    }

    public String ventasProductos(String archivo){
        String resumenProductos = "";
        String[] contenido = ManejadorArchivosGenerico.leerArchivo(archivo);
        for (String lineas: contenido) {
            String[] elementos = lineas.split(",");
            if (elementos.length == 1){
                String codigo = elementos[0];
                if (productos.buscar(codigo) != null){
                    Producto p = (Producto) productos.buscar(codigo).getDatos();
                    int stock = p.getStock();
                    restarStock(codigo,stock);
                    resumenProductos += "Código producto: " + codigo + " - Dinero ganado por ventas: " + stock * p.getPrecio() + "\n";
                }else {
                    resumenProductos += "Producto con código " + codigo + " no se encuentra." + "\n";
                }
            } else if (elementos.length == 2){
                String codigo = elementos[0];
                Integer cantidad = Integer.parseInt(elementos[1]);
                if (productos.buscar(codigo) != null){
                    Producto p = (Producto) productos.buscar(codigo).getDatos();
                    if (cantidad > p.getStock()){
                        int stock = p.getStock();
                        restarStock(codigo,stock);
                        resumenProductos += "Codigo del producto: " + codigo + " - Dinero ganado por ventas: " + stock * p.getPrecio() + "\n";
                    }else {
                        restarStock(codigo,cantidad);
                        resumenProductos += "Código producto: " + codigo + " - Dinero ganado por ventas: " + cantidad * p.getPrecio() + "\n";
                    }
                }else {
                    resumenProductos += "Producto con código " + codigo + " no se encuentra." + "\n";
                }
            }else {
                resumenProductos += "Hay productos que no se pudieron ingresar, por favor, revisar el archivo";
            }
        }
        return resumenProductos;
    }
}
