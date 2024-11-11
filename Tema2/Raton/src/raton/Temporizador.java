/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raton;

import java.util.Scanner;

/**
 *
 * @author Claudia
 */
public class Temporizador extends Thread{
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int tiempo = sc.nextInt();
        int tAlarma = sc.nextInt();
        Reloj hiloReloj = new Reloj();
        hiloReloj.start();
        Alarma hiloAlarma = new Alarma(tAlarma);
        hiloAlarma.setDaemon(true);
        hiloAlarma.start();
        Thread.sleep(tiempo*1000);
        hiloReloj.interrupt();
    }
}
