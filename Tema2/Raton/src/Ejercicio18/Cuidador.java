/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModEj15;

import java.util.Random;
import java.util.concurrent.locks.Lock;

/**
 *
 * @author ClaudissPerez
 */
public class Cuidador extends Thread {

    private Comedero comedero;
    private Lock cerrojoComida;

    public Cuidador(Comedero comedero, Lock cerrojoComida) {
        this.comedero = comedero;
        this.cerrojoComida = cerrojoComida;
    }

    @Override
    public void run() {
        this.recargar();
    }

    public void recargar() {

        while (true) {
            if (comedero.getComidaDisponible() <= 5) {
                cerrojoComida.lock(); // Adquirir el lock antes de recargar
                try {

                    int aleat = new Random().nextInt(20, 31); // Generar un número aleatorio de comida
                    comedero.setComidaDisponible(comedero.getComidaDisponible() + aleat);
                    System.out.println("Cuidador recargando " + aleat + " unidades de comida. Comida disponible: " + comedero.getComidaDisponible());

                } finally {
                    cerrojoComida.unlock(); // Liberar el lock
                }
            }
        }
    }
}
