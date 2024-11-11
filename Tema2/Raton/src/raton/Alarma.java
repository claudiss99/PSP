/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raton;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Claudia
 */
public class Alarma extends Thread{

    public Alarma() {
        super();
    }
    
    public void mostrar(){
        System.out.println("¡Alarma! Han pasado 5 segundos");
    }
    @Override
    public void run(){
        while(true){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Alarma.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.mostrar();
        }
    }
    
}