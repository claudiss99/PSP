/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio26;

import java.util.Random;

/**
 *
 * @author ClaudissPerez
 */
public class Supermercado {
    
    
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        String nombre;
        for(int i=0; i<10; i++){
            nombre = "Cliente"+String.valueOf(i);
            System.out.println(nombre+" ha entrado en  la tienda");
            Thread.sleep(random.nextInt(5, 16));
            System.out.println(nombre+" ha terminado de comprar");
            Caja caja = new Caja(nombre);
            caja.start();
        }
    }
    
}
