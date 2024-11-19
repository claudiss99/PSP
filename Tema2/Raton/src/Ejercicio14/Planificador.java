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
public class Planificador extends Thread{
    private static ListaTareas listaTareas;
    /*
    Recorre el for y crea las tareas en el orden correspondiente, añadir tarea
    coge una tarea no la devuelve, y el desarrollador recibe el numero de tareas 
    entonces tiene un for hasta ese numero para leer
    */
    private int nTareas;

    public Planificador(int nTareas) {
        this.nTareas = nTareas;
    }
    
    
    public void crearTarea(){
        for(int i=0; i<nTareas;i++){
            listaTareas.añadirTarea("Tarea "+String.valueOf(i));
            
        }
    }
    
    @Override
    public void run(){
        this.crearTarea();
    }
}
