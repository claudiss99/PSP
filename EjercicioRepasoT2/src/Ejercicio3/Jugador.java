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
public class Jugador extends Thread{
    private int id;
    private Juego juego;

    public Jugador(int id, Juego juego) {
        this.id = id;
        this.juego = juego;
    }
    
    @Override
    public void run(){
        try {
            boolean conseguido = true;
            while (conseguido){
                conseguido = juego.participal(id);
            }
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
