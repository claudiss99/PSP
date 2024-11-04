/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raton;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Claudia
 */
public class RatonVarComp extends Thread{
    private String nombre;
    private int tiempo;
    private static int comidaConsumida = 0;

    public RatonVarComp (String nombre, int tiempo) {
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
            Logger.getLogger(RatonHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int getComidaConsumida(){
        return comidaConsumida;
    }
    public static void main(String[] args) throws InterruptedException {
        RatonVarComp fievel = new RatonVarComp("Fievel", 1000);
        RatonVarComp jerry = new RatonVarComp("Jerry", 2000);
        RatonVarComp pinky = new RatonVarComp("Pinky", 3000);
        RatonVarComp mickey = new RatonVarComp("Mickey", 4000);
        

        fievel.start();
        jerry.start();
        pinky.start();
        mickey.start();
        
        fievel.join();
        jerry.join();
        pinky.join();
        mickey.join();
        
        System.out.println("Comida consumida: "+RatonVarComp.getComidaConsumida());
    }
    
}


