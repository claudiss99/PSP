/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio23;

import java.util.Random;

/**
 *
 * @author ClaudissPerez
 */
public class Copisteria {

    public static void main(String[] args) {
        Random random = new Random();
        int i = 0;
        
        while (i<10){
            Ordenador computer = new Ordenador("Ordenador "+String.valueOf(i), random.nextInt(3,7));
            computer.start();
            i++;
        }
    }
}
