package com.ut3_pd7;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        System.out.println("Ejercicio 2:");
        System.out.println("----------------------------------------------------");
        System.out.println("--------------------------");
        Alumno a1 = new Alumno("5219678-1","S","Se");
        Alumno a2 = new Alumno("5219678-3","Sa","Sev");
        Alumno a3 = new Alumno("5219678-4","San","Seve");
        Alumno a4 = new Alumno("5219678-5","Santi","Sever");
        Alumno a5 = new Alumno("5219678-2","Santiago","Severo");

        Nodo n1 = new Nodo<>(a1.getCi(),a1);
        Nodo n2 = new Nodo<>(a2.getCi(),a2);

        Nodo n3 = new Nodo<>(a3.getCi(),a3);
        Nodo n4 = new Nodo<>(a4.getCi(),a4);
        Nodo n5 = new Nodo<>(a5.getCi(),a5);

        IConjunto l1 = new Conjunto();
        IConjunto l2 = new Conjunto();

        l1.insertar(n1);
        l1.insertar(n2);

        l2.insertar(n3);
        l2.insertar(n4);
        l2.insertar(n5);

        IConjunto l3 = l1.union(l2);
        IConjunto l4 = l1.interseccion(l2);
        System.out.println(l3.imprimir());
        System.out.println(l4.imprimir());

        IConjunto AED1 = new Conjunto();
        IConjunto PF = new Conjunto();

        System.out.println("--------------------------");
        System.out.println("----------------------------------------------------");
        System.out.println("Ejercicio 3:");
        System.out.println("----------------------------------------------------");
        System.out.println("--------------------------");
        Alumno alumno1 = new Alumno("1234","A","AA");
        Alumno alumno2 = new Alumno("2345","B","BB");
        Alumno alumno3 = new Alumno("3456","C","CC");
        Alumno alumno4 = new Alumno("4567","D","DD");
        Alumno alumno5 = new Alumno("5678","E","EE");
        Alumno alumno6 = new Alumno("6789","F","FF");
        Alumno alumno7 = new Alumno("1234","A","AA");
        Alumno alumno8 = new Alumno("2345","B","BB");
        Alumno alumno9 = new Alumno("3456","C","CC");

        AED1.insertar(alumno1.getCi(),alumno1);
        AED1.insertar(alumno2.getCi(),alumno2);
        AED1.insertar(alumno3.getCi(),alumno3);
        AED1.insertar(alumno4.getCi(),alumno4);
        AED1.insertar(alumno9.getCi(),alumno9);

        PF.insertar(alumno5.getCi(),alumno5);
        PF.insertar(alumno6.getCi(),alumno6);
        PF.insertar(alumno7.getCi(),alumno7);
        PF.insertar(alumno8.getCi(),alumno8);

        System.out.println(AED1.imprimir());
        System.out.println(PF.imprimir());

        IConjunto conjuntoUnion = AED1.union(PF);
        System.out.println("Union de conjuntos");
        System.out.println(conjuntoUnion.imprimir());

        IConjunto conjuntoInterseccion = AED1.interseccion(PF);
        System.out.println("Interseccion de conjuntos");
        System.out.println(conjuntoInterseccion.imprimir());
    }
}
