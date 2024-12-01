/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio24;

import java.util.Random;

/**
 *
 * @author ClaudissPerez
 */
public class Piscina {
    
    public static void main(String[] args) {
        Random random = new Random();
        for(int i=0;  i<15; i++){
            int tiempo = random.nextInt(5, 11);
            Persona persona = new Persona("Persona "+String.valueOf(i), tiempo);
            persona.start();
        }
    }
}
