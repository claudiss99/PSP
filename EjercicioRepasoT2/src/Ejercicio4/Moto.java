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
public class Moto extends Thread{
    private Aparcamiento parking;

    public Moto(String nombre, Aparcamiento parking) {
        super(nombre);
        this.parking = parking;
    }
    
    @Override
    public void run(){
        try {
            Thread.sleep(new Random().nextInt(3000, 20000));
        } catch (InterruptedException ex) {
            Logger.getLogger(Moto.class.getName()).log(Level.SEVERE, null, ex);
        }
        parking.aparcarMotos(this.getName());
    }
    
}
