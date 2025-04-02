package org.pd1;

public class Alumno {
    private String nombre;
    public Alumno () {
        nombre = " ";
    }

    public static int recorrer (String cadena) {
        int res = 0;
        for (int i = 0; i <= cadena.length() - 1; i++) {
            if (cadena.charAt(i) != ' ') {
                res++;
            }
        }
        return res;
    }

    public static int getValor() {
        int vector[] = { 6, 16, 26,36,46,56,66,76 };
        int idx = 7;
        return vector[idx];
    }

    public static char getPrimerCaracter(String palabra) {
        String string[] = new String[5];
        string[1] = "rock";
        return (string[1].charAt(0));
    }

    public static String paraAString(int a) {
        return String.valueOf(a) ;
    }

    public String getNombreAdmiracion() {
        return nombre.concat("!");
    }
    public static void main (String[] args) {
        Alumno alumno = new Alumno();
        System.out.println(alumno.getNombreAdmiracion());
        System.out.println(recorrer("recorrida"));
        System.out.println(getValor());
        System.out.println(getPrimerCaracter("rock"));
        System.out.println(paraAString(15));
    }
}

