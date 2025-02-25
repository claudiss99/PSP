/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Gestion {
    private static ArrayList<String> nombreJugadores;
    private ArrayList<SalaJuego> salas = new ArrayList<>();
    private ArrayList<Jugador> jugadoresEnEspera = new ArrayList<>();
    
    public Gestion(){
        nombreJugadores = new ArrayList<>();
        salas = new ArrayList<>();
        jugadoresEnEspera = new ArrayList<>();
    }
    
    public ArrayList<String> getNombreJugadores(){
        return nombreJugadores;
    }
    
    public void newJugador(Jugador jugador){
        nombreJugadores.add(jugador.getNombre());
        jugadoresEnEspera.add(jugador);
        
        if(jugador.recibirRespuesta().equalsIgnoreCase("COMENZAR")){
            //Comprobamos si tenemos al menos 2 en cola
            enviarASala();
        }else{
            eliminarJugador(jugador.getNombre());
            jugadoresEnEspera.remove(jugador.getNombre());
        }
        
    }
    
    public void enviarASala(){
        if(jugadoresEnEspera.size() >= 2){
            Jugador j1 = jugadoresEnEspera.remove(0);
            Jugador j2 = jugadoresEnEspera.remove(0);
            
            SalaJuego sala = new SalaJuego(j1, j2);
            salas.add(sala);
            //como ya tenemos los jugadores y su sala --> comemnzamos
            sala.start(); 
        }else{
            //Tenemos que responder  “ESPERANDO_JUGADORES”.
            for (Jugador jugador : jugadoresEnEspera) {
                jugador.enviarMensaje("ESPERANDO_JUGADORES");
            }
        }
    }
    
    public static void eliminarJugador(String nombre){
        nombreJugadores.remove(nombre);
    }
}
