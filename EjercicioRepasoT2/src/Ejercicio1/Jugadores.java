
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Jugadores extends Thread{
    private int id;
    private Juego juego;
    
    public Jugadores(int id, Juego juego) {
        this.id = id;
        this.juego = juego;
    }
    
    @Override
    public void run(){
        while(!juego.isNumeroAdivinado()){
            try {
                int numero = new Random().nextInt(1, 11);
                if(juego.probarNumero(id, numero)){
                    break;
                }
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Jugadores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
