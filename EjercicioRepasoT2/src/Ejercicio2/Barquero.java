/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Barquero extends Thread{
    private Barca barca;

    public Barquero(Barca barca) {
        this.barca = barca;
    }
    
    @Override
    public void run(){
        try {
            while(true){
                barca.esperoLleno();
                System.out.println("Se inicia el viaje");
                Thread.sleep(new Random().nextInt(5000, 11000));             
                System.out.println("Se termina el viaje");
                barca.finViaje();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Barquero.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
