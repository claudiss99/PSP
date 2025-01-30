/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio7;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Socorrista extends Thread{
    private Piscina piscina;

    public Socorrista(Piscina piscina) {
        this.piscina = piscina;
    }
    
    
    @Override
    public void run(){
        while(true){
            try {
                piscina.accionSocorrista();
            } catch (InterruptedException ex) {
                Logger.getLogger(Socorrista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
