/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio25;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author ClaudissPerez
 */
public class SalaB extends Thread{
    private static Semaphore semaforo = new Semaphore(2);
    int tiempo;
    
    public SalaB (String nombre){
        super(nombre);
        this.tiempo= new Random().nextInt(2,5);
    }
    
    
    public void entrarSala(){
        System.out.println(getName()+" esperando para entrar a Sala B");
        try{
            semaforo.acquire();
            System.out.println(getName()+" ha entrado en Sala B");
            Thread.sleep(tiempo*1000);
            System.out.println(getName()+" ha salido de la Sala B");
        }catch(InterruptedException e){
            System.err.println("Ha ocurrido un interrupcion en "+getName());
        }finally{
            semaforo.release();
        }
    }
    
    
    @Override
    public void run(){
        entrarSala();
    }
}
