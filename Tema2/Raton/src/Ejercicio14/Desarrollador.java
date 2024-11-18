/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio14;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ClaudissPerez
 */
public class Desarrollador extends Thread{
    private ListaTareas tareas;

    public Desarrollador(ListaTareas tareas) {
        this.tareas = tareas;
    }
    
    public void obtener() throws InterruptedException{
        while (true){
           String tarea = tareas.obtenerTarea();
           if (tarea !=null){
               System.out.println("D: "+tarea+ " recibida");
           }
       }
    }
    @Override
    public void run(){
        try {
            this.obtener();
        } catch (InterruptedException ex) {
            Logger.getLogger(Desarrollador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
