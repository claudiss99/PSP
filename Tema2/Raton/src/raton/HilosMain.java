/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raton;

/**
 *
 * @author Claudia
 */
public class HilosMain {
    public static void main(String[] args) throws InterruptedException{
        HiloInfinito h = new HiloInfinito("Demonio");
        h.start();
        Thread.sleep(3000);
        System.out.println("Han pasado 3 segundos");
        h.interrupt();
    }
}
