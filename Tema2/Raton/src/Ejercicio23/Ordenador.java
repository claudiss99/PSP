/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio23;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ClaudissPerez
 */
public class Ordenador extends Thread{
    private static Semaphore semaforo = new Semaphore(4);
    private int tiempo;

    public Ordenador(String nombre, int tiempo) {
        super(nombre);
        this.tiempo = tiempo;
    }
    
    public void imprimir() throws InterruptedException{
        System.out.println(getName()+": ha enviado el documento. Esperando impresora");
        try {
            semaforo.acquire();
            System.out.println(getName()+": ha comenzado a imprimir");
            Thread.sleep(tiempo*1000);
            System.out.println(getName()+": ha terminado de imprimir"); 
            
        } finally {
            semaforo.release();
        }
    }
    
    @Override
    public void run(){
        try {
            this.imprimir();
        } catch (InterruptedException ex) {
            Logger.getLogger(Ordenador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

