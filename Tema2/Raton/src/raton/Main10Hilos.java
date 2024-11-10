/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raton;

import java.util.Random;

/**
 *
 * @author Claudia
 */
public class Main10Hilos {
    public static void main(String[] args) throws InterruptedException {
        Hilo1 h1 = new Hilo1("Hilo 1", 2);
        Hilo1 h2 = new Hilo1("Hilo 2", 3);
        Hilo1 h3 = new Hilo1("Hilo 3", 5);
        
        h1.start();
        h2.start();
        h3.start();
        int aleat = new Random().nextInt(10000);
        System.out.println(aleat);
        Thread.sleep(aleat);
        h1.interrupt();
        h2.interrupt();
        h3.interrupt();
        System.out.println("Tiempo agotado");

    }
}
