/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio15;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ClaudissPerez
 */
public class RatonHilo extends Thread{
    private String nombre;
    private int tiempo;
    private Comedero comedero;
    private int unidadesComida;
    

    public RatonHilo(String nombre, int tiempo, Comedero comedero, int unidadesComida) {
        super();
        this.nombre = nombre;
        this.tiempo = tiempo;
        this.comedero = comedero;
        this.unidadesComida = unidadesComida;
    }
    
    public synchronized void comer() throws InterruptedException{
        while (comedero.getComidaDisponible() < unidadesComida){
            wait();
        }
        System.out.println("El ratón "+nombre+" ha empezado a comer");
        Thread.sleep(tiempo*1000);
        comedero.setComidaDisponible(comedero.getComidaDisponible()-unidadesComida);
        System.out.println("El ratón "+nombre+ " ha terminado de comer. Comida disponible: "+comedero.getComidaDisponible());
        
        
        
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