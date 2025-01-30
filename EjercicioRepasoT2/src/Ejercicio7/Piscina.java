/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio7;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Usuario
 */
public class Piscina {
    private Lock lock = new ReentrantLock();
    private Condition mantenimiento = lock.newCondition();
    private Condition salir = lock.newCondition();
    private Condition entrar = lock.newCondition();
    private int cPersonas = 0;
    
    public void accionSocorrista() throws InterruptedException{
        
        //Espero 10 segundo a que se bañen
        Thread.sleep(10000);
        lock.lock();
        //Aviso para que se salgan y me espero
        System.out.println("El socorrista pita y espera a que se salgan todas las personas");
        salir.signalAll();
        mantenimiento.await();
        //Cuando me despierten --> Hago mantenimiento
        System.out.println("REALIZANDO MANTENIMIENTO");
        Thread.sleep(3000);
        System.out.println("El socorrista avisa de que la piscina vuelve a estar disponible");
        entrar.signalAll();  
        lock.unlock();
    }
    
    public void entrar() throws InterruptedException{
        lock.lock();
        cPersonas++;
        lock.unlock();
    }
    
    public void nadando() throws InterruptedException{
        lock.lock();
        salir.await();
        lock.unlock();
        
    }
    
    public void salir(){
        lock.lock();
        cPersonas--;
        if(cPersonas==0){
            //Si ya no quedan personas aviso para hacer el mantenimiento
            mantenimiento.signalAll();
        }
        lock.unlock();
    }
}
