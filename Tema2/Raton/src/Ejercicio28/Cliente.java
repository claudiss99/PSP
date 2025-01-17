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
public class Cliente extends Thread{
    private Barberia barberia;

    public Cliente(int id, Barberia barberia) {
        super("Cliente " + id);
        this.barberia = barberia;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(1000, 20001));
            if(barberia.haySitio()){
                System.out.println(getName() + ": Estoy en la sala de espera");
                barberia.esperoTurno();
                System.out.println(getName() + ": El cliente se está pelando");
                barberia.clientePelandose();
                System.out.println(getName() + ": El cliente ha terminado de pelarse y se va");
            }else{
                System.out.println(getName() + ": No hay sitio, no puedo pelarme");
            }
        } catch (InterruptedException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
}
