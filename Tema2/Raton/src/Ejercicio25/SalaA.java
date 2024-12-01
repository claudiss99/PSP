/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio25;

import java.util.concurrent.Semaphore;

/**
 *
 * @author ClaudissPerez
 */
public class SalaA extends Thread{
    private static int tiempo;
    private static Semaphore semaforo = new Semaphore(4);
    
    public SalaA (String nombre, int tiempo){
        super(nombre);
        this.tiempo= tiempo;
    }
    
    public void entrarSala(){
        System.out.println(getName()+" esperando para entrar a Sala A");
        try{
            semaforo.acquire();
            System.out.println(getName()+" ha entrado en Sala A");
            Thread.sleep(tiempo*1000);
            System.out.println(getName()+" ha salido de la Sala A");
            SalaB salaB = new SalaB(getName());
            salaB.start();
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
