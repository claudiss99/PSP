/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class SalaJuego extends Thread{
    private Jugador jugador1;
    private Jugador jugador2;
    private int puntosJ1=0;
    private int puntosJ2=0;

    public SalaJuego(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }
    
    private String comprobarGanador(String eleccionJ1, String eleccionJ2){
        if (eleccionJ1.equals(eleccionJ2)){
            return "EMPATE";
        }
        if ((eleccionJ1.equals("PIEDRA") && eleccionJ2.equals("TIJERA")) ||
            (eleccionJ1.equals("PAPEL") && eleccionJ2.equals("PIEDRA")) ||
            (eleccionJ1.equals("TIJERA") && eleccionJ2.equals("PAPEL"))) {
            return jugador1.getNombre();
        }else{
            return jugador2.getNombre();
        }
        
    }
    @Override
    public void run(){
        try {
            jugador1.enviarMensaje("JUEGO_INICIADO#" + jugador2.getNombre());
            jugador2.enviarMensaje("JUEGO_INICIADO#" + jugador1.getNombre());

            while (puntosJ1 < 3 && puntosJ2 < 3) {
                jugador1.enviarMensaje("RONDA");
                jugador2.enviarMensaje("RONDA");

                String eleccionJ1 = jugador1.recibirEleccion();
                String eleccionJ2 = jugador2.recibirEleccion();

                String ganador = comprobarGanador(eleccionJ1, eleccionJ2);
                if (ganador.equals(jugador1.getNombre())) puntosJ1++;
                if (ganador.equals(jugador2.getNombre())) puntosJ2++;

                String resultado = "RESULTADO#" + jugador1.getNombre() + "#" + eleccionJ1 + "#" +
                        jugador2.getNombre() + "#" + eleccionJ2 + "#" + ganador + "#" + puntosJ1 + "-" + puntosJ2;

                jugador1.enviarMensaje(resultado);
                jugador2.enviarMensaje(resultado);
            }

            if (puntosJ1 == 3) {
                jugador1.enviarMensaje("GANA");
                jugador2.enviarMensaje("PIERDE");
            } else {
                jugador1.enviarMensaje("PIERDE");
                jugador2.enviarMensaje("GANA");
            }
            
            //Mando a gestion por si quieren volver a jugar
            Gestion gestion = new Gestion();
            gestion.newJugador(jugador1);
            gestion.newJugador(jugador2);
            
         } catch (Exception e) {
            System.err.println("Error en la sala: " + e.getMessage());
        } finally {
            jugador1.cerrarConexion();
            jugador2.cerrarConexion();
        }
    }
}
