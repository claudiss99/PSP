/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio12;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Persona extends Thread{
    private Cuenta cuenta;
    //No puede ponerse el nombre como super porque sino no puedo usarlo en retirar
    private String nombre;
    public Persona(String nombre, Cuenta cuenta) {
        this.nombre = nombre;
        this.cuenta = cuenta;
    }
    
    @Override
    public void run(){
        //Retirar 4 veces
        int n=0;
        while (n<4){
            try {
                cuenta.retirar(10, nombre);
            } catch (InterruptedException ex) {
                Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
            }
            n++;
        }
        
    }
    
    
}
