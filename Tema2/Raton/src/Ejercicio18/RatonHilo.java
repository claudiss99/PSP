/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModEj15;

import java.util.concurrent.locks.Lock;
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
    private Lock cerrojoComida;
    

    public RatonHilo(String nombre, int tiempo, Comedero comedero, int unidadesComida, Lock cerrojoComida) {
        super();
        this.nombre = nombre;
        this.tiempo = tiempo;
        this.comedero = comedero;
        this.unidadesComida = unidadesComida;
        this.cerrojoComida = cerrojoComida;
    }
    
    
    public void comer() throws InterruptedException{
        while (comedero.getComidaDisponible() < unidadesComida) {}
        // Adquirir el lock antes de comprobar y consumir
        
        cerrojoComida.lock();
        try {
            System.out.println("El ratón " + nombre + " ha empezado a comer.");
            Thread.sleep(tiempo * 1000); // Simula el tiempo que tarda en comer
            comedero.setComidaDisponible(comedero.getComidaDisponible() - unidadesComida);
            System.out.println("El ratón " + nombre + " ha terminado de comer. Comida disponible: " + comedero.getComidaDisponible());
        } finally { 
            cerrojoComida.unlock();
        }
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