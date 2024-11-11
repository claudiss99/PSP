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
        Hilos10 h1 = new Hilos10("Hilo 1", 2);
        Hilos10 h2 = new Hilos10("Hilo 2", 3);
        Hilos10 h3 = new Hilos10("Hilo 3", 5);
        
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
