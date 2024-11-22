/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio13;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Claudia
 */
public class RatonHilo extends Thread{
    private String nombre;
    private int tiempo;
    private Comedero comedero;

    public RatonHilo(String nombre, int tiempo, Comedero comedero) {
        //Para que se inicialice el hilo
        super();
        this.nombre = nombre;
        this.tiempo = tiempo;
        this.comedero = comedero;
    }
    
    public synchronized void comer() throws InterruptedException{
        System.out.println("El ratón "+nombre+" ha empezado a comer");
        Thread.sleep(tiempo);
        System.out.println("El ratón "+nombre+ " ha terminado de comer");
        comedero.setComidaConsumida(comedero.getComidaConsumida()+1);
    }
    
    @Override
    public void run(){
        try {
            this.comer();
        } catch (InterruptedException ex) {
            Logger.getLogger(RatonHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
