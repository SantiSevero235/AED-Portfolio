package uy.edu.ucu.aed.pd7;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Conjunto<Alumno> AED1 = new Conjunto<>();
        Conjunto<Alumno> PF = new Conjunto<>();

        Alumno a1 = new Alumno("1234", "Ana", "Pérez");
        Alumno a2 = new Alumno("2345", "Luis", "Gómez");
        Alumno a3 = new Alumno("3456", "Sofía", "Díaz");
        Alumno a4 = new Alumno("4567", "Carlos", "Ramos");
        Alumno a5 = new Alumno("5678", "Lucía", "Fernández");

        AED1.insertar(a1, a1.getCi());
        AED1.insertar(a2, a2.getCi());
        AED1.insertar(a3, a3.getCi());
        AED1.insertar(a4, a4.getCi());

        PF.insertar(a1, a1.getCi());
        PF.insertar(a2, a2.getCi());
        PF.insertar(a4, a4.getCi());
        PF.insertar(a5, a5.getCi());

        IConjunto<Alumno> union = AED1.union(PF);
        System.out.println("=== UNIÓN (alumnos en AED1 o PF) ===");
        System.out.println(union.imprimir("\n"));

        // Mostrar intersección (alumnos en ambos cursos)
        IConjunto<Alumno> interseccion = AED1.interseccion(PF);
        System.out.println("\n=== INTERSECCIÓN (alumnos en ambos cursos) ===");
        System.out.println(interseccion.imprimir("\n"));
    }
}