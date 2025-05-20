public class Main {
    public static void main(String[] args) {
        Almacen a = new Almacen("La Artiguense");
        System.out.println(a.actualizarStock("src/altasPrueba.txt"));
        System.out.println(a.ventasProductos("src/ventasPrueba.txt"));
        System.out.println(a.ventasProductos("src/elimPrueba.txt"));

        Producto p1 = new Producto("1000073","p1");
        Producto p2 = new Producto("1000087","p2");
        Producto p3 = new Producto("1000088","p3");
        Producto p4 = new Producto("1000096","p4");
        Producto p5 = new Producto("1000097","p5");
        Producto p6 = new Producto("1000073","p6");
        Producto p7 = new Producto("1000088","p7");
        a.insertarProducto(p1);
        a.insertarProducto(p2);
        a.insertarProducto(p3);
        a.insertarProducto(p4);
        a.insertarProducto(p5);
        a.insertarProducto(p6);
        a.insertarProducto(p7);
        System.out.println(a.imprimirProductos());

    }
}