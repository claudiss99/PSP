/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Barca {
    private Semaphore semaforo= new Semaphore(5);
    private Lock lock = new ReentrantLock();
    private Condition iniciarViaje = lock.newCondition();
    private Condition puedoBajar = lock.newCondition();
    private Condition puedoSubir = lock.newCondition();
    
    public void subePasajero(int idPasajero) throws InterruptedException{
        lock.lock();
        //Mientras no pueda subirme
        while(this.getPlazasLibres()==0){
            puedoSubir.await();
        }
        //Subo
        semaforo.acquire();
        System.out.println("Pasajero "+idPasajero+" ha subido a la barca");
        //soy el ultimo?
        if(this.getPlazasLibres()==0){
            //Aviso al barquero que ya nos podemos ir
            iniciarViaje.signal();
        }
        //me espero en la barca
        puedoBajar.await();
        semaforo.release();
        System.out.println("Pasajero "+idPasajero+" ha bajado de la Barca");
        Thread.sleep(100);
        //Si soy el ultimo en bajar, aviso al resto
        if(this.getPlazasLibres()==5){
            System.out.println("*************************************");
            puedoSubir.signalAll();
        }
        lock.unlock();
    }
    
    public void esperoLleno() throws InterruptedException{
        lock.lock();
        //Si  no esta lleno --> espero
        try {
            while (this.getPlazasLibres()>0){
                iniciarViaje.await(); 
            }
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Barca.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
            lock.unlock(); 
        }
        
          
    }
    
    public void finViaje() throws InterruptedException{
        lock.lock();
        puedoBajar.signalAll();
        iniciarViaje.await();
        lock.unlock();
    }
    public int getPlazasLibres(){
        return semaforo.availablePermits();
    }
}
