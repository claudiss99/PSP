/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package raton;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Claudia
 */
public class RatonHilo extends Thread{
    private String nombre;
    private int tiempo;

    public RatonHilo(String nombre, int tiempo) {
        this.nombre = nombre;
        this.tiempo = tiempo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "Raton{" + "nombre=" + nombre + ", tiempo=" + tiempo + '}';
    }
    
    public void comer() throws InterruptedException{
        System.out.println("El ratón "+nombre+" ha empezado a comer");
        Thread.sleep(tiempo);
        System.out.println("El ratón "+nombre+ " ha terminado de comer");
    }
    
    @Override
    public void run(){
        try {
            this.comer();
        } catch (InterruptedException ex) {
            Logger.getLogger(RatonHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
