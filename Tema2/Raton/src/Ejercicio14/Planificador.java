/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio14;

/**
 *
 * @author ClaudissPerez
 */
public class Planificador extends Thread{
    private  ListaTareas listaTareas;
    private int nTareas;

    public Planificador(int nTareas, ListaTareas listaTareas) {
        this.nTareas = nTareas;
        this.listaTareas = listaTareas;
    }
    
    
    public void crearTarea(){
        for(int i=0; i<nTareas;i++){
            listaTareas.anadirTarea("Tarea "+String.valueOf(i));
            
        }
    }
    
    @Override
    public void run(){
        this.crearTarea();
    }
}
