/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Usuario
 */
public class Laberinto {
    //2 entradas --> 2 semafotos
    private Semaphore entrada1 = new Semaphore(4);
    private Semaphore entrada2 = new Semaphore(4);
    boolean entrar;
    
    public boolean entrarLaberinto(String nombre) throws InterruptedException{
        int tiempo = new Random().nextInt(4000, 8000);
        System.out.println(nombre+" quiere entrar");
        //Hay sitio en la primera entrada
            if(entrada1.tryAcquire()){
                System.out.println(nombre+" ha entrado en la sala 1");
                Thread.sleep(tiempo);
                System.out.println("       "+nombre+" ha salido de la sala 1");
                entrada1.release();
                entrar= false;
            }else{
                if(entrada2.tryAcquire()){
                    System.out.println(nombre+" ha entrado en la sala 2");
                    Thread.sleep(tiempo);
                    System.out.println("       "+nombre+" ha salido de la sala 2");
                    entrada2.release();
                    entrar=false;
                }else{
                    System.out.println(nombre+" no ha podido entrar, esperando");
                    entrar = true;
                }  
            }
        return entrar;
    }
    
}
