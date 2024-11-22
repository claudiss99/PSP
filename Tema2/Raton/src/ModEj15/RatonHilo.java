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
    private Lock cerrojoRaton;
    

    public RatonHilo(String nombre, int tiempo, Comedero comedero, int unidadesComida, Lock cerrojoComida, Lock cerrojoRaton) {
        super();
        this.nombre = nombre;
        this.tiempo = tiempo;
        this.comedero = comedero;
        this.unidadesComida = unidadesComida;
        this.cerrojoComida = cerrojoComida;
        this.cerrojoRaton = cerrojoRaton;
    }
    
    
    public void comer() throws InterruptedException{
        /*
        cerrojoRaton.lock();
        cerrojoComida.lock();
        if (comedero.getComidaDisponible() > unidadesComida){
            System.out.println("El ratón "+nombre+" ha empezado a comer");
            Thread.sleep(tiempo*1000);
            comedero.setComidaDisponible(comedero.getComidaDisponible()-unidadesComida);
            System.out.println("El ratón "+nombre+ " ha terminado de comer. Comida disponible: "+comedero.getComidaDisponible());
            cerrojoRaton.unlock();
            if(comedero.getComidaDisponible() > unidadesComida){
                cerrojoComida.unlock();
            }
        }else{
            cerrojoComida.unlock();
        }
        
        */
        while (true) {
            cerrojoComida.lock(); // Adquirir el lock antes de comprobar y consumir
            try {
                if (comedero.getComidaDisponible() >= unidadesComida) {
                    System.out.println("El ratón " + nombre + " ha empezado a comer.");
                    Thread.sleep(tiempo * 1000); // Simula el tiempo que tarda en comer
                    comedero.setComidaDisponible(comedero.getComidaDisponible() - unidadesComida);
                    System.out.println("El ratón " + nombre + " ha terminado de comer. Comida disponible: " + comedero.getComidaDisponible());
                    break; // Sale del bucle al comer
                } else {
                    System.out.println("El ratón " + nombre + " espera porque no hay suficiente comida.");
                }
            } finally {
                cerrojoComida.unlock(); // Liberar el lock
            }
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