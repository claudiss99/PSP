/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Vehiculo extends Thread{
    private Gasolinera gasolinera;

    public Vehiculo(String nombre, Gasolinera gasolinera) {
        super(nombre);
        this.gasolinera = gasolinera;
    }
    
    @Override
    public void run(){
        try {
            gasolinera.repostar(this.getName());
            gasolinera.pagar(this.getName());
        } catch (InterruptedException ex) {
            Logger.getLogger(Vehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
