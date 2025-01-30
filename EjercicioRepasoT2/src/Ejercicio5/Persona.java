/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio5;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Persona extends Thread{
    private Laberinto laberinto;
    
    public Persona(String nombre, Laberinto laberinto) {
        super(nombre);
        this.laberinto = laberinto;
    }
    
    @Override
    public void run(){
        try {
            boolean entrar= true;
            //Damos un paseo
            Thread.sleep(new Random().nextInt(3000, 15000));
            while(entrar){
                entrar = laberinto.entrarLaberinto(this.getName());
            }
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
