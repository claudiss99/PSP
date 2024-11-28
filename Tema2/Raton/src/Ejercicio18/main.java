/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio18;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ClaudissPerez
 */
public class main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce cuantos ratones hay:");
        int nRatones = sc.nextInt();
        Comedero comedero = new Comedero(0);
        int tiempo;
        int unidadesComida;
        Random random = new Random();
        Lock cerrojoComida = new ReentrantLock(true);
        //Lock cerrojoRaton= new ReentrantLock(true);
        Cuidador cuidador = new Cuidador(comedero, cerrojoComida);
        //Para que cuando los ratones terminen de comer no siga reponiendo
        cuidador.setDaemon(true);
        cuidador.start();
        
        for(int i=0; i<nRatones; i++){
            String nombre = "Raton "+Integer.toString(i);
            tiempo = random.nextInt(1,4);
            unidadesComida = random.nextInt(1, 6);
            RatonHilo raton = new RatonHilo(nombre, tiempo, comedero, unidadesComida, cerrojoComida);
            raton.start();
        }
    }
}