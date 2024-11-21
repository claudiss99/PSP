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
    private static ArrayList<String> tareas = new ArrayList<>();

    public ListaTareas() {
        
    }
    
    
    public synchronized void anadirTarea(String tarea){
        tareas.add(tarea);
        System.out.println("P: "+tarea+" añadida");
        //System.out.println(tareas.size());
        this.notifyAll();
    }
    
    public synchronized String obtenerTarea() throws InterruptedException{
        System.out.println(tareas.size());
        while(tareas.isEmpty()){
            System.out.println("esperando");
            this.wait();
        }

        String tarea = tareas.remove(0);
        return tarea;
    }
    
}
