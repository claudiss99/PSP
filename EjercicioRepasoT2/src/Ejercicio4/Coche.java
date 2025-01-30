/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Coche extends Thread{
    private Aparcamiento parking;

    public Coche(String nombre, Aparcamiento parking) {
        super(nombre);
        this.parking = parking;
    }
    
    @Override
    public void run(){
        try {
            Thread.sleep(new Random().nextInt(3000, 20000));
        } catch (InterruptedException ex) {
            Logger.getLogger(Coche.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            parking.aparcarCoches(this.getName());
        } catch (InterruptedException ex) {
            Logger.getLogger(Coche.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
