package com.juanjose.Desafio1.App;
import com.juanjose.Desafio1.Domain.guayabita;
import com.juanjose.Desafio1.Domain.jugador;

import javax.swing.*;
import java.util.Arrays;
public class appguayabita {
    boolean puedecontinuar = true;
    String nombre;
    private static final ImageIcon icono = new ImageIcon("D:/POB/projects/Guayabita/src/com/juanjose/Desafio1/App/img.png");
    private static final String titulo = "Guayabita";

    public static void main(String[] args) {
        guayabita Guayabita=new guayabita();
        while (true) {
            int opcion1 =  JOptionPane.showOptionDialog(null, "Bienvenidos al juego de la guayabita.\n\n¿Que quieres hacer?", titulo, 0,0, icono, Arrays.asList("JUGAR", "VER INSTRUCCIONES").toArray(),"JUGAR");
            switch (opcion1) {
                case 0 -> {
                    int jugador=0;
                    while (jugador<2) {
                        boolean puedeContinuar= true;
                        int monto=0 ;
                        String nombre;
                        do {
                            try {
                                monto = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el dinero del jugador"));
                                puedeContinuar = true;
                            } catch (Exception e) {
                                puedeContinuar = false;
                            }
                        } while (!puedeContinuar);

                        JOptionPane.showMessageDialog(null, monto);
                        do {
                            nombre = JOptionPane.showInputDialog("Hola! Ingresa tu nombre").trim();

                            if (nombre == null || nombre.trim().isEmpty()) {
                                puedeContinuar = false;
                            } else {
                                puedeContinuar = true;
                            }
                        } while (!puedeContinuar);


                        JOptionPane.showMessageDialog(null, nombre);

                        jugador Jugador_a_añadir=new jugador(nombre,monto);
                        Guayabita.getJugadores().add(Jugador_a_añadir);
                        jugador++;
                    }
                    int apuestainicial = 0;
                    boolean puedeContinuar1=true;
                    do {
                        try {
                        apuestainicial= Integer.parseInt(JOptionPane.showInputDialog("Ingresa la apuesta inicial de cada jugador:"));
                        puedeContinuar1 = true;
                    } catch (Exception e) {
                        puedeContinuar1 = false;
                    }
                    } while (!puedeContinuar1);
                    Guayabita.apuestainicial(apuestainicial);
                    jugador JugadorActual = Guayabita.turno();
                    boolean tienedinero=true;
                    while(tienedinero) {
                        int opcion2=JOptionPane.showConfirmDialog(null,JugadorActual.getNombre()+" deseas tirar el dado , el pote se encuentra en "+ Guayabita.getPoteinicial(),titulo,JOptionPane.YES_NO_OPTION);
                        switch (opcion2){
                            case JOptionPane.YES_OPTION -> {
                               int primerlanzada= Guayabita.lanzardado();
                               JOptionPane.showMessageDialog(null,JugadorActual.getNombre()+" tu valor en el dado fue de: "+primerlanzada,titulo,JOptionPane.INFORMATION_MESSAGE,icono);
                               if (primerlanzada>1 && primerlanzada<6) {
                                   int opcion3 = JOptionPane.showConfirmDialog(null, JugadorActual.getNombre() + " deseas hacer una apuesta, el pote se encuentra en " + Guayabita.getPoteinicial(), titulo, JOptionPane.YES_NO_OPTION);
                                   switch (opcion3) {
                                       case JOptionPane.YES_OPTION -> {
                                           int apuesta = 0;
                                           boolean puedeContinuar2 = true;
                                           do {
                                               try {
                                                   apuesta = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el monto a apostar"));
                                                   puedeContinuar2 = true;
                                               } catch (Exception e) {
                                                   puedeContinuar2 = false;
                                               }
                                               if (JugadorActual.getDinero() < apuesta) {
                                                   puedeContinuar2 = false;
                                               }
                                           } while (!puedeContinuar2);
                                           Guayabita.apostar(JugadorActual,apuesta);
                                           int segundalanzada = Guayabita.lanzardado();
                                           if (segundalanzada > primerlanzada) {
                                               Guayabita.gana(JugadorActual, apuesta);
                                           } else {
                                               Guayabita.pierde(apuesta);
                                               if (JugadorActual.getDinero() == 0) {
                                                   tienedinero = false;
                                               }
                                               JugadorActual=Guayabita.turno();
                                           }


                                       }
                                       case JOptionPane.NO_OPTION -> {
                                           JugadorActual = Guayabita.turno();
                                       }
                                   }
                               }
                               else{
                                   JugadorActual=Guayabita.turno();
                               }



                            }
                            case JOptionPane.NO_OPTION -> {
                                JugadorActual=Guayabita.turno();
                            }
                        }
                    }

                }
                case 1->{
                    JOptionPane.showMessageDialog(null,"Intstrucciones para el juego:\n\n1.Se agregaran dos jugadores , en donde se le pediran nombre y el dinero que tienen(por favor cuando ingresen nombre que sean letras y por favor el dinero sea en numero).\n\n2.ya añadido los jugadores , se le pediran a los usuarios cuanto es el monto inicial por el que desean jugar o el pote inicial , es decir si son 500 se le sacaran a cada jugador y 1000 es el pote inicial.\n\n3.si desea lanzar el dado y saca 1 0 6 perdera el turno , pero si saca un valor diferente se le preguntara si quiere apostar\n\n4.si su opcion fue apostar, se le preguntara el monto ;se gana si saca un valor mayor de la primera lanzada");
                }
                default -> System.exit(0);


            }
        }

    }


}

