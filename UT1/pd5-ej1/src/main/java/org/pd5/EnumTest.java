package org.pd5;

public class EnumTest {
    meses mes;

    public enum meses {
        ENERO, FEBRERO, MARZO, ABRIL, MAYO, JUNIO,
        JULIO, AGOSTO, SEPTIEMBRE, OCTUBRE, NOVIEMBRE, DICIEMBRE
    }

    public EnumTest(meses mes) {
        this.mes = mes;
    }

    public void feriadosNoLaborablesUY() {
        switch (mes) {
            case ENERO:
                System.out.println("Feriado de Año nuevo");
                break;

            case MARZO:
                System.out.println("Asunción Presidencial");
                break;

            case MAYO:
                System.out.println("Dia de los trabajores");
                break;

            case JULIO:
                System.out.println("Jura de la constitución");
                break;

            case AGOSTO:
                System.out.println("Declaratoria de la independencia");
                break;

            case DICIEMBRE:
                System.out.println("Feriado de Navidad");
                break;

            default:
                System.out.println("Este día no tiene feriados no laborables");

        }
    }

    public static void main(String[] args) {
        for (meses mes : meses.values()) {
            EnumTest test = new EnumTest(mes);
            test.feriadosNoLaborablesUY();
            System.out.println("----------------------------");
        }
    }
}
