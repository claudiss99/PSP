/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio14;

import java.util.ArrayList;

/**
 *
 * @author ClaudissPerez
 */
public class ListaTareas {
    private ArrayList<String> tareas = new ArrayList<>();

    public ListaTareas() {
        
    }
    
    
    public synchronized void anadirTarea(String tarea){
        tareas.add(tarea);
        System.out.println("P: "+tarea+" añadida");
        this.notifyAll();
    }
    
    public synchronized String obtenerTarea() throws InterruptedException{
        while(tareas.isEmpty()){
            this.wait();
        }

        String tarea = tareas.remove(0);
        return tarea;
    }
    
}
