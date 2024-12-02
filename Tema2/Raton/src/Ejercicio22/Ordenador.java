/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio22;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ClaudissPerez
 */
public class Ordenador extends Thread{
    private Lock puedeImprimir;
    private int tiempo;

    public Ordenador(String nombre, Lock puedeImprimir, int tiempo) {
        super(nombre);
        this.puedeImprimir = puedeImprimir;
        this.tiempo = tiempo;
    }
    
    public void imprimir() throws InterruptedException{
        System.out.println(getName()+": ha enviado el documento. Esperando impresora");
        puedeImprimir.lock();
        try {
            System.out.println(getName()+": ha comenzado a imprimir");
            Thread.sleep(tiempo*1000);
            System.out.println(getName()+": ha terminado de imprimir");
            
        } finally {
            puedeImprimir.unlock();
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
