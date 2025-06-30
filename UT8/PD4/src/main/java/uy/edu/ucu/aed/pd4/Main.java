package uy.edu.ucu.aed.pd4;

public class Main {
    public static void main(String[] args) {
        TGrafoNoDirigido grafoND = UtilGrafos.cargarGrafo(
                "src/vertices.txt",
                "src/aristas.txt",
                false,
                TGrafoNoDirigido.class
        );

        TVertice a = grafoND.buscarVerticePublic("A");
        TVertice b = grafoND.buscarVerticePublic("B");
        TVertice c = grafoND.buscarVerticePublic("C");
        TVertice d = grafoND.buscarVerticePublic("D");
        TVertice e = grafoND.buscarVerticePublic("E");
        TVertice f = grafoND.buscarVerticePublic("F");
        TVertice g = grafoND.buscarVerticePublic("G");
        TVertice h = grafoND.buscarVerticePublic("H");
        TVertice i = grafoND.buscarVerticePublic("I");

        System.out.println("¿A está conectado con D? → " + grafoND.conectados(a, d)); // true
        System.out.println("¿B está conectado con A? → " + grafoND.conectados(b, a)); // true
        System.out.println("¿E está conectado con G? → " + grafoND.conectados(e, g)); // true
        System.out.println("¿A está conectado con G? → " + grafoND.conectados(a, g)); // false
        System.out.println("¿C está conectado con F? → " + grafoND.conectados(c, f)); // false
        System.out.println("¿H está conectado con I? → " + grafoND.conectados(h, i)); // true
        System.out.println("¿A está conectado con H? → " + grafoND.conectados(a, h)); // false
        System.out.println("¿E está conectado con I? → " + grafoND.conectados(e, i)); // false
        System.out.println("¿F está conectado con G? → " + grafoND.conectados(f, g)); // true
    }
}
