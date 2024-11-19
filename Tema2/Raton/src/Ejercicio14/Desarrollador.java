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
    private int nTareas;
    private static ListaTareas listaTareas;

    public Desarrollador(int nTareas) {
        this.nTareas = nTareas;
    }
    
    public void obtener() throws InterruptedException{
        for (int i =0; i<nTareas;i++){
           String tarea = listaTareas.obtenerTarea();
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
