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
    private Socket socket;
    private Jugador jugador;
    private SalaJuego sala;
    private ArrayList<String> nombres;
    
    public Gestion(){
        nombres = new ArrayList<>();
    }
    
    public void newJugador(Jugador jugador){
        //Mientras que no me introduz el nombre correcto --> No tengo un jugador
        boolean listo = false;
        while(!listo){
            //Consigo su nombre
            String nombre = jugador.getNombre();
            //Compruebo el nombre
            if(nombres.contains(nombre)){
                jugador.enviarMensaje("FALLO#USUARIO_DUPLICADO");
            }else{
                //Añadimos usuario
                nombres.add(nombre);
                //enviamos conectado
                jugador.enviarMensaje("CONECTADO");
                listo = true;
            }
        }
    }
}
