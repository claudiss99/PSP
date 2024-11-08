/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raton;

/**
 *
 * @author Claudia
 */
public class Temporizador extends Thread{
    public static void main(String[] args) throws InterruptedException {
        Reloj hiloReloj = new Reloj();
        hiloReloj.start();
        Alarma hiloAlarma = new Alarma();
        hiloAlarma.setDaemon(true);
        hiloAlarma.start();
        Thread.sleep(20000);
        hiloReloj.interrupt();
    }
}
