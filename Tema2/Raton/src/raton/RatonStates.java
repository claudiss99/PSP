/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raton;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Claudia
 */
public class RatonStates extends Thread{
    private String nombre;
    private int tiempo;
    private static int comidaConsumida = 0;

    public RatonStates (String nombre, int tiempo) {
        //Para que se inicialice el hilo
        super();
        this.nombre = nombre;
        this.tiempo = tiempo;
    }
    
    public void comer() throws InterruptedException{
        System.out.println("El ratón "+nombre+" ha empezado a comer");
        Thread.sleep(tiempo);
        comidaConsumida ++;
        System.out.println("El ratón "+nombre+ " ha terminado de comer");
        
    }
    
    
    @Override
    public void run(){
        try {
            this.comer();
        } catch (InterruptedException ex) {
            Logger.getLogger(RatonStates.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int getComidaConsumida(){
        return comidaConsumida;
    }
    public static void main(String[] args) throws InterruptedException {
        ArrayList<State> estados = new ArrayList<>();
        RatonStates fievel = new RatonStates("Fievel", 6000);
        

        fievel.start();
        fievel.join();
        System.out.println("Comida consumida: "+RatonVarComp.getComidaConsumida());
        
        
        estados.add(fievel.getState());
        System.out.println(estados);
        
        
    }
}
