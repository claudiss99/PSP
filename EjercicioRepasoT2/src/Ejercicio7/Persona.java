/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio7;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Persona extends Thread{
    private Piscina piscina;

    public Persona(String nombre, Piscina piscina) {
        super(nombre);
        this.piscina = piscina;
    }
    
    @Override
    public void run(){
        try {
            Boolean again= true;
            int opc;
            while(again){
                 Thread.sleep(new Random().nextInt(5000, 20000));
                //Quiero bañarme
                piscina.entrar();
                System.out.println("La "+getName()+ " ha entrado en la piscina");
                piscina.nadando(); 
                piscina.salir();
                System.out.println("La "+getName()+" ha SALIDO de la piscina");
                opc= new Random().nextInt(1, 3);
                if(opc == 2){
                    again = false;
                }
            }
           
        } catch (InterruptedException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
