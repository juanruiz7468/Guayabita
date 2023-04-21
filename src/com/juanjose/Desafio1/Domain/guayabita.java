package com.juanjose.Desafio1.Domain;
import java.util.ArrayList;
import java.util.List;

public class guayabita {
    private int poteinicial=0;
    private List<jugador> jugadores;
    private int turno=0;

    public guayabita() {
        this.jugadores = new ArrayList();
    }

    public void apuestainicial(int valor_inicial){
        this.poteinicial=this.poteinicial+(valor_inicial*(jugadores.size()));
        for(jugador Jugador: jugadores) {
            Jugador.pierdeDinero(valor_inicial);
        }
    }
    public jugador turno() {
        jugador Jugador = null;
        if (this.turno < jugadores.size()) {
            Jugador = jugadores.get(this.turno);
        }
        if (this.turno >= jugadores.size()) {
            this.turno = 0;
            Jugador=jugadores.get(this.turno);
        }
        this.turno = this.turno + 1;
        return Jugador;


    }

    public int lanzardado() {
        int valordado =  (int)(Math.random()*6)+1;
        return valordado;
    }

    public void apostar( jugador jugadoractual, int valor_a_apostar) {
        jugadoractual.pierdeDinero(valor_a_apostar);
    }

    public void pierde(int valor_a_apostar) {
        this.poteinicial = this.poteinicial + valor_a_apostar;
    }

    public void gana( jugador jugadoractual,int valor_a_apostar) {

        jugadoractual.ganaDinero(2*valor_a_apostar);
        this.poteinicial=this.poteinicial-valor_a_apostar;

    }

    public int getPoteinicial() {
        return poteinicial;
    }

    public List<jugador> getJugadores() {
        return jugadores;
    }

    public int getTurno() {
        return turno;
    }
}
