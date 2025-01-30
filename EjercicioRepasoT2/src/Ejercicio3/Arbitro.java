/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Arbitro extends Thread{
    private Juego juego;

    public Arbitro(Juego juego) {
        this.juego = juego;
    }
    
    
    @Override
    public void run(){
        try {
           while(true){
                juego.esperarJugadores();
                juego.pararMusica();
           }
        } catch (InterruptedException ex) {
            Logger.getLogger(Arbitro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
