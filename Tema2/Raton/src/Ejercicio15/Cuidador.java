/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio15;

import java.util.Random;

/**
 *
 * @author ClaudissPerez
 */
public class Cuidador extends Thread{
    private Comedero comedero;

    public Cuidador(Comedero comedero) {
        this.comedero = comedero;
    }
    
    
    
    @Override
    public void run (){
        this.recargar();
    }
    
    public synchronized void recargar(){
        while (true){
            if (comedero.getComidaDisponible() < 5){
                notifyAll();
                int aleat = new Random().nextInt(20, 31);
                comedero.setComidaDisponible(aleat);
                System.out.println("Cuidador recargando "+aleat+" unidades de comida");
            }
            
        }
    }
}
