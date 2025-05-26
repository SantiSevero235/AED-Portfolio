package uy.edu.ucu.aed.pd3;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TArbolGenerico a = new TArbolGenerico<>();
        a.insertar("", "RECTORÍA");

        a.insertar("RECTORÍA", "VICERRECTORÍA DEL MEDIO UNIVERSITARIO");
        a.insertar("RECTORÍA", "VICERRECTORÍA ACADÉMICA");
        a.insertar("RECTORÍA", "VICERRECTORÍA ADMINISTRATIVA");

        a.insertar("VICERRECTORÍA ACADÉMICA", "FACULTAD DE CIENCIAS EMPRESARIALES");
        a.insertar("VICERRECTORÍA ACADÉMICA", "FACULTAD DE CIENCIAS HUMANAS");
        a.insertar("VICERRECTORÍA ACADÉMICA", "FACULTAD DE INGENIERÍA Y TECNOLOGÍAS");
        a.insertar("VICERRECTORÍA ACADÉMICA", "FACULTAD DE PSICOLOGÍA");

        a.insertar("FACULTAD DE INGENIERÍA Y TECNOLOGÍAS", "DEPARTAMENTO DE INFORMÁTICA Y CIENCIAS DE LA COMPUTACIÓN");
        a.insertar("FACULTAD DE INGENIERÍA Y TECNOLOGÍAS", "DEPARTAMENTO DE INGENIERÍA ELÉCTRICA");
        a.insertar("FACULTAD DE INGENIERÍA Y TECNOLOGÍAS", "DEPARTAMENTO DE MATEMÁTICAS");


        System.out.println(a.listarIndentado());
    }
    }