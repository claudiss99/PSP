/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio28;

import java.util.Random;

/**
 *
 * @author joseg
 */
public class Barbero extends Thread{
   private Barberia barberia;

    public Barbero(Barberia barberia) {
        super("Barbero");
        this.barberia = barberia;
    }

    @Override
    public void run() {
        while(true){
            try {
                barberia.barberoEsperandoClientes();
                Thread.sleep(new Random().nextInt(3000, 6001));
                barberia.pelarCliente();
            } catch (InterruptedException ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        }
    }
}
