/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio6;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Usuario
 */
public class Gasolinera {
    Semaphore zonaRepostaje = new Semaphore(6, true);
    Lock lock = new ReentrantLock(true);
    Condition pagar = lock.newCondition();
    
    
    public void repostar(String nombre) throws InterruptedException{
        //reposta y sino espero por defecto
        System.out.println(nombre+" quiere repostar");
        zonaRepostaje.acquire();
        System.out.println(nombre+" está repostando");
        //Tiempo de repostar
        Thread.sleep(new Random().nextInt(5000, 10000));
        zonaRepostaje.release();
        System.out.println(nombre+" va a pagar");
    }
    
    public void pagar(String nombre) throws InterruptedException{
        lock.lock();
        Thread.sleep(new Random().nextInt(3000, 5000));
        System.out.println(nombre+" ha pagado");
        lock.unlock();
    }
}
