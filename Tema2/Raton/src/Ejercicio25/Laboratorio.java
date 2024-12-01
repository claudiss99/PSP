/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio25;

import java.util.Random;

/**
 *
 * @author ClaudissPerez
 */
public class Laboratorio {
    public static void main(String[] args) {
        Random random = new Random();
        String nombre;
        int tiempo;
        for(int i=0; i<10; i++){
            nombre = "Cientifico"+String.valueOf(i);
            tiempo = random.nextInt(3, 7);
            SalaA salaA = new SalaA(nombre, tiempo) ;
            salaA.start();
        }
    }
}
