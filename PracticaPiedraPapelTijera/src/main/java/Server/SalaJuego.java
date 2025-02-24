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
public class SalaJuego extends Thread{
    private Socket socket;
    private Jugador jugador;
    private SalaJuego sala;
    private ArrayList<String> nombres;
    
    public SalaJuego(){
        nombres = new ArrayList<>();
    }
    
    @Override
    public void run(){
        
    }
}
