/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio22;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author ClaudissPerez
 */
public class Copisteria {
    private static Lock puedeImprimir = new ReentrantLock();
   
    
    public static void main(String[] args) {
        Random random = new Random();
        int i = 0;
        
        while (i<10){
            Ordenador computer = new Ordenador("Ordenador "+String.valueOf(i), puedeImprimir, random.nextInt(3,7));
            computer.start();
            i++;
        }
    }
}
