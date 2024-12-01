/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio26;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author ClaudissPerez
 */
public class Caja extends Thread{
    //Falta el numero de caja, se lo he ppreguntado a chat gpt y hay que hacer syncronized a la vez???
    private static Semaphore semaforo = new Semaphore(4);
    private static int tiempo;
    
    public Caja(String nombre){
        super(nombre);
        this.tiempo = new Random().nextInt(5, 11);
    }
    
    public void pagar(){
        System.out.println(getName()+" esta esperando una caja");
        try{
            semaforo.acquire();
            System.out.println(getName()+" Va a la caja");
            Thread.sleep(tiempo*1000);
            System.out.println(getName()+" ha terminado de pagar en la caja");
        }catch (InterruptedException e){
            System.err.println("Ha ocurrido una interrupcion en "+getName());
        }finally{
            semaforo.release();
        }
    }
    
    @Override
    public void run(){
        pagar();
    }
}
