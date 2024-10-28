/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raton;


/**
 *
 * @author Claudia
 */
public class RatonRunnable implements Runnable{
     private String nombre;
     private int tiempo;

    public RatonRunnable(String nombre, int tiempo) {
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
        return "RatonRunnable{" + "nombre=" + nombre + ", tiempo=" + tiempo + '}';
    }
     
    public void comer() throws InterruptedException{
        System.out.println("El ratón "+nombre+" ha empezado a comer");
        Thread.sleep(tiempo);
        System.out.println("El ratón "+nombre+ " ha terminado de comer");
    }
    
    public void run(){
        try {
            this.comer();
        } catch (InterruptedException ex) {
            System.err.println("Ha ocurrido un error en el run");
        }
    } 
}
