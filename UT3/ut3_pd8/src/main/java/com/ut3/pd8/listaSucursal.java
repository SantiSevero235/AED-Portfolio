package com.ut3.pd8;

import java.util.ArrayList;

public class listaSucursal {

    ArrayList<Sucursales> lista = new ArrayList<>();

    public void agregarSucursal(Sucursales nuevaSucursal) {
        lista.add(nuevaSucursal);
    }

    public void buscarSucursal(ArrayList<Sucursales> lista, String ciudad) {
        boolean resultado = false;

        for (Sucursales sucursal : lista) {
            if (sucursal.getCiudad().equals(ciudad)) {
                resultado = true;
                break;
            }
        }
        System.out.println("¿En la ciudad " + ciudad + " se encuentra la sucursal? " + resultado);
    }

    public void quitarSucursal(String ciudad) {
        lista.removeIf(sucursal -> sucursal.getCiudad().equals(ciudad));
        System.out.println("La sucursal en: " + ciudad + " ha sido eliminada.");
    }

    public void listarSucursales() {
        for (Sucursales sucursal : lista) {
            System.out.println(sucursal);
        }
    }

    public int cantSucursales() {
        return lista.size();
    }

    public boolean estaVacio() {
        return lista.isEmpty();
    }
}