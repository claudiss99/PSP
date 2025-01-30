/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Usuario
 */
public class Aparcamiento {
    //10 aparcamientos coches
    private Semaphore cochesParking = new Semaphore(10);
    // 5 aparcamientos motos
    private Semaphore motosParking = new Semaphore(5);
    
    
    public void aparcarCoches(String nombre) throws InterruptedException{
        //Si puedo aparcar, aparco sino nada
        if(cochesParking.availablePermits()>0){
            cochesParking.acquire();
            System.out.println(nombre+" aparcando");
            Thread.sleep(new Random().nextInt(4000, 7000));
            System.out.println(nombre+" termina aparcamiento");
            cochesParking.release();
        }else{
            System.out.println(nombre+" no ha podido aparcar");
        }
    }
    
    public void aparcarMotos(String nombre) throws InterruptedException{
        //Si puedo aparcar, aparco sino nada
        if(motosParking.availablePermits()>0){

            motosParking.acquire();
            System.out.println(nombre+" aparcando");
            Thread.sleep(new Random().nextInt(4000, 7000));
            System.out.println(nombre+" termina aparcamiento");
            motosParking.release();
        }else{
            System.out.println(nombre+" no ha podido aparcar");
        }
    }
}
