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
    private ListaTareas tareas;
    private int nTareas;

    public Planificador(ListaTareas tareas, int nTareas) {
        this.tareas = tareas;
        this.nTareas = nTareas;
    }
    
    
    public void crearTarea(){
        for(int i=0; i<nTareas;i++){
            String tarea = tareas.añadirTarea();
            System.out.println("P: "+tarea+" añadida");
        }
    }
    
    @Override
    public void run(){
        
        this.crearTarea();
    }
}
