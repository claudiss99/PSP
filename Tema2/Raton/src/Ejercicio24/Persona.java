/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio24;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author ClaudissPerez
 */
public class Persona extends Thread{
    private static Semaphore semaforo = new Semaphore(10);
    private static int tiempo;
    
    public Persona (String nombre, int tiempo){
        super(nombre);
        this.tiempo= tiempo;
    }
    
    public void entrarPiscina(){
        System.out.println(getName()+" esperando a entrar");
        try{
            semaforo.acquire();
            System.out.println(getName()+" esta en la piscina");
            Thread.sleep(tiempo*1000);
            System.out.println(getName()+" ha salido de la piscina");
        }catch (InterruptedException e){
            System.err.println("Ha ocurrido una interrupcion en "+getName());
        }finally{
            semaforo.release();
        }
    }
    
    @Override
    public void run(){
        Random random = new Random();
        int numEntrar= random.nextInt(1, 4);
        System.out.println(getName()+" quiere entrar "+numEntrar+" veces a la piscina");
        for(int i=0; i<numEntrar; i++){
            entrarPiscina();
        }
        
    }
}
