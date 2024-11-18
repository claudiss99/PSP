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
       /*
    ListaTareas recibe el numero de tareas? o recibe el arraylist que se 
    le pasa desde 
    el simulador
    */
    
    public ArrayList getTareas(){
        return tareas;
    }
    public synchronized String añadirTarea(){
        String tarea = "Tarea "+ Integer.toString(tareas.size());
        tareas.add(tarea);
        notify();
        return tarea;
    }
    
    public synchronized String obtenerTarea() throws InterruptedException{
        while(tareas.isEmpty()){
            wait();
        }
        String tarea = tareas.remove(0);
        
        return tarea;
    }
    
}
