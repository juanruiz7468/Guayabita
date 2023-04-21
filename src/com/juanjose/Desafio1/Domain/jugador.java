package com.juanjose.Desafio1.Domain;

public class jugador {
    private String nombre;
    private int dinero;

    public jugador(String nombre, int dinero) {
        this.nombre = nombre;
        this.dinero = dinero;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDinero() {
        return dinero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void pierdeDinero(int dinero) {
        this.dinero = this.dinero-dinero;
    }
    public void ganaDinero(int dinero){
        this.dinero=this.dinero+dinero;
    }
}
