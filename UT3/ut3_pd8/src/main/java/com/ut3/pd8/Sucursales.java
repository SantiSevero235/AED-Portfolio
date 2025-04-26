package com.ut3.pd8;

public class Sucursales {
    private String ciudad;

    public Sucursales(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    @Override
    public String toString() {
        return "Sucursal en: " + ciudad;
    }
}
